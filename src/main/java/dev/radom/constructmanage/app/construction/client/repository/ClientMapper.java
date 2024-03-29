package dev.radom.constructmanage.app.construction.client.repository;

import dev.radom.constructmanage.app.construction.client.model.Client;
import dev.radom.constructmanage.app.construction.client.dto.AddNewClientDto;
import dev.radom.constructmanage.app.construction.client.model.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

     Client fromAddNewClientDto(AddNewClientDto addNewClientDto);

    List<ClientDto> toClientDtoList(List<Client> clients);

    ClientDto toClientDto(Client client);

}