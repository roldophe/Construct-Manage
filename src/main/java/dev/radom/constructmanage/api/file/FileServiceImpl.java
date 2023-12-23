package dev.radom.constructmanage.api.file;

import dev.radom.constructmanage.api.file.web.FileDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileServiceImpl implements FileService {
    @Value("${FILE_SERVER_PATH}")
    private String serverPath;

    @Value("${FILE_BASE_URI}")
    private String fileBaseUri;

    @Value("${FILE_DOWNLOAD_URI}")
    private String fileDownloadUri;

    @Override
    public Resource downloadByName(String name) {
        Path path = Paths.get(serverPath + name);
        if (Files.exists(path)) {
            return UrlResource.from(path.toUri());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not Found!");
    }

    @Override
    public FileDto uploadSingle(MultipartFile file) {
        return this.save(file);
    }

    @Override
    public List<FileDto> uploadMultiple(List<MultipartFile> files) {
        return files.stream().map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public FileDto findByName(String name) {
        //Start loading the file name
        Path path = Paths.get(serverPath + name);
        if (Files.exists(path)) {
            Resource resource = UrlResource.from(path.toUri());
            try {
                return FileDto.builder()
                        .name(name)
                        .uri(fileBaseUri + name)
                        .downloadUri(fileDownloadUri + name)
                        .extension(this.getExtension(name))
                        .size(resource.contentLength())
                        .build();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found!");
    }

    @Override
    public void deleteAll() {
        Path path = Paths.get(serverPath);
        try {
            List<Path> pathList;
            try (Stream<Path> paths = Files.list(path)) {
                pathList = paths.toList();
            }
            for (Path p : pathList) {
                Files.delete(p);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FileDto> findAll() {
        List<FileDto> fileDtos = new ArrayList<>();
        Path path = Paths.get(serverPath);
        try {
            List<Path> pathList;
            try (Stream<Path> paths = Files.list(path)) {
                pathList = paths.toList();
            }
            for (Path p : pathList) {
                Resource resource = UrlResource.from(p.toUri());
                fileDtos.add(FileDto.builder()
                        .name(resource.getFilename())
                        .uri(fileBaseUri + resource.getFilename())
                        .downloadUri(fileDownloadUri + resource.getFilename())
                        .extension(this.getExtension(Objects.requireNonNull(resource.getFilename())))
                        .size(resource.contentLength())
                        .build());
            }
            return fileDtos;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByName(String name) {
        Path path = Paths.get(serverPath + name);
        try {
            boolean isDeleted = Files.deleteIfExists(path);
            if (!isDeleted) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String getExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        return fileName.substring(lastDotIndex + 1);
    }

    private FileDto save(MultipartFile file) {
        //Get a file extension
        String extension = this.getExtension(Objects.requireNonNull(file.getOriginalFilename()));
        //rename file
        String name = UUID.randomUUID() + "." + extension;
        String uri = fileBaseUri + name;
        long size = file.getSize();

        //Create a file path
        Path path = Paths.get(serverPath + name);
        try {
            Files.copy(file.getInputStream(), path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return FileDto.builder()
                .name(name)
                .downloadUri(fileDownloadUri + name)
                .extension(extension)
                .size(size)
                .uri(uri).build();
    }

}
