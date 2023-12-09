package dev.radom.constructmanage.file.web;

import lombok.Builder;

@Builder
public record FileDto(String name,
                      String uri,
                      String downloadUri,
                      Long size,
                      String extension) {
}
