package com.example.backend.controller;

import com.example.backend.dto.ClientNameDto;
import com.example.backend.dto.ContactCreateDto;
import com.example.backend.dto.ContactDto;
import com.example.backend.entity.Client;
import com.example.backend.servise.ClientServise;
import com.example.backend.servise.ContactServise;
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
    private final ClientServise clientServise;

    private final ContactServise contactServise;

    @PostMapping("/client/create")
    public ClientNameDto createClients(@RequestBody @Validated ClientNameDto nameDto) {
        return clientServise.createClient(nameDto);
    }

    @PostMapping("/contact/create")
    public ResponseEntity<ContactCreateDto> createContact(@RequestBody ContactCreateDto dto) {
        ContactCreateDto createdDto = contactServise.createContacts(dto);
        return ResponseEntity.ok(createdDto);
    }

    @GetMapping("/name")
    public ResponseEntity<List<ClientNameDto>> getNameClients(@RequestParam String name) {
        List<ClientNameDto> nameDtos = clientServise.getName(name);
        return ResponseEntity.ok(nameDtos);
    }


    @GetMapping("/{id}")
    public Optional<Client> getClients(@PathVariable Long id) {
        return clientServise.getId(id);
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<List<ContactDto>> getContects(@PathVariable @RequestParam Long clientId) {
        List<ContactDto> contactsDtos = contactServise.getClientsId(clientId);
        return ResponseEntity.ok(contactsDtos);
    }


    @GetMapping("/contact/name-type")
    public ResponseEntity<List<ContactDto>> getContectsIdAndType(@RequestParam Long clientId, String type) {
        List<ContactDto> contactDtos = contactServise.getIdAndType(clientId, type);
        return ResponseEntity.ok(contactDtos);
    }
}