package dev.radom.constructmanage.api.construction.client.service;

import dev.radom.constructmanage.api.construction.client.repository.ClientMapper;
import dev.radom.constructmanage.api.construction.client.model.Client;
import dev.radom.constructmanage.api.construction.client.repository.ClientRepository;
import dev.radom.constructmanage.api.construction.client.dto.AddNewClientDto;
import dev.radom.constructmanage.api.construction.client.model.ClientDto;
import dev.radom.constructmanage.api.construction.client.dto.UpdateClientDto;
import dev.radom.constructmanage.utils.GenerateCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public void addNewClient(AddNewClientDto addNewClientDto) {
        boolean existByName = clientRepository.existsByName(addNewClientDto.name());
        if (existByName) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Name already exists!");
        }
        Client client = clientMapper.INSTANCE.fromAddNewClientDto(addNewClientDto);
        client.setCode("CL-" + GenerateCode.generateCode());
        clientRepository.save(client);
    }

    @Override
    public void deleteClientByCode(String code) {
        Client client = clientRepository.findClientByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!"));
        clientRepository.delete(client);
    }

    @Override
    public void updateClientByCode(String code, UpdateClientDto updateClientDto) {
        Client client = clientRepository.findClientByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!"));

        clientRepository.save(client);
    }

    @Override
    public ClientDto findClientByCode(String code) {
        Client client = clientRepository.findClientByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!"));
        return clientMapper.INSTANCE.toClientDto(client);
    }

    @Override
    public List<ClientDto> findAllClient() {
        return clientMapper.toClientDtoList(clientRepository.findAll());
    }
}
