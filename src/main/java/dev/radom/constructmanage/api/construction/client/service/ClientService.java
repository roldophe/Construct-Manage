package dev.radom.constructmanage.api.construction.client.service;

import dev.radom.constructmanage.api.construction.client.dto.AddNewClientDto;
import dev.radom.constructmanage.api.construction.client.model.ClientDto;
import dev.radom.constructmanage.api.construction.client.dto.UpdateClientDto;

import java.util.List ;

public interface ClientService {
    void addNewClient(AddNewClientDto addNewClientDto);

    void deleteClientByCode(String code);
    void updateClientByCode(String code, UpdateClientDto updateClientDto);
    ClientDto findClientByCode(String code);

    List<ClientDto> findAllClient();
}
