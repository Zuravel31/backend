package com.example.backend.controller;

import com.example.backend.dto.ClientsDto;
import com.example.backend.dto.ClientsNameDto;
import com.example.backend.dto.ContactsCreateDto;
import com.example.backend.dto.ContactsDto;
import com.example.backend.entity.Clients;
import com.example.backend.servise.ClientsServise;
import com.example.backend.servise.ContactsServise;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("api/test")
@RequiredArgsConstructor
public class Controller {
    private final ClientsServise clientsServise;

    private final ContactsServise contactsServise;

    @PostMapping("/clients/crate")
    public ClientsNameDto createClients(@RequestBody @Validated ClientsNameDto nameDto) {
        return clientsServise.createClients(nameDto);
    }

    @PostMapping("/contacts/crate")
    public ResponseEntity<ContactsCreateDto> createContact(@RequestBody ContactsCreateDto dto) {
        ContactsCreateDto createdDto = contactsServise.createContacts(dto);
        return ResponseEntity.ok(createdDto);
    }

    @GetMapping("/name")
    public ResponseEntity<List<ClientsNameDto>> getNameClients(@RequestParam String name) {
        List<ClientsNameDto> nameDtos = clientsServise.getName(name);
        return ResponseEntity.ok(nameDtos);
    }

    @GetMapping("/{id}")
    public Optional<Clients> getClients(@PathVariable Long id) {
        return clientsServise.getId(id);
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<List<ContactsDto>> getContects(@PathVariable @RequestParam Long clientId) {
        List<ContactsDto> contactsDtos = contactsServise.getClientsId(clientId);
        return ResponseEntity.ok(contactsDtos);
    }


    @GetMapping("/contacts")
    public ResponseEntity<List<ContactsDto>> getContectsIdAndType(@RequestParam Long clientId, String type) {
        List<ContactsDto> contactsDtos = contactsServise.getIdAndType(clientId, type);
        return ResponseEntity.ok(contactsDtos);
    }
}