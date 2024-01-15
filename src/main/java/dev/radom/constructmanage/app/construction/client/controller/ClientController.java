package dev.radom.constructmanage.app.construction.client.controller;

import dev.radom.constructmanage.app.construction.client.service.ClientService;
import dev.radom.constructmanage.app.construction.client.dto.AddNewClientDto;
import dev.radom.constructmanage.app.construction.client.model.ClientDto;
import dev.radom.constructmanage.app.construction.client.dto.UpdateClientDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.findAllClient();
    }

    @PostMapping
    public void addNewClient(@RequestBody @Valid AddNewClientDto addNewClientDto) {
        clientService.addNewClient(addNewClientDto);
    }

    @GetMapping("/{code}")
    public ClientDto getClientByCode(@PathVariable String code) {
        return clientService.findClientByCode(code);
    }

    @PutMapping("/{code}")
    public void updateClientByCode(@PathVariable String code, @RequestBody UpdateClientDto updateClientDto) {
        clientService.updateClientByCode(code, updateClientDto);
    }

    @DeleteMapping("/{code}")
    public void deleteClientByCode(@PathVariable String code) {
        clientService.deleteClientByCode(code);
    }
}
