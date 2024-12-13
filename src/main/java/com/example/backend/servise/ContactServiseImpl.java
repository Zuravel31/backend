package com.example.backend.servise;

import com.example.backend.dto.ContactCreateDto;
import com.example.backend.dto.ContactDto;
import com.example.backend.entity.Client;
import com.example.backend.entity.Contact;
import com.example.backend.mapper.ContactMapper;
import com.example.backend.repository.ClientRepository;
import com.example.backend.repository.ContactRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Slf4j
@Service
public class ContactServiseImpl implements ContactServise {
    private final ContactMapper mapper;

    private final ContactRepository repository;

    private final ClientRepository clientRepository;

    @Transactional
    @Override
    public ContactCreateDto createContacts(ContactCreateDto dto) {
        Client client = clientRepository.findById(dto.getClientsId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));

        System.out.println("Client found: " + client.getId());

        Contact entity = mapper.toEntity(dto);
        entity.setClient(client);
        System.out.println("Contacts entity created: " + entity);

        Contact entitySave = repository.save(entity);
        System.out.println("Contacts entity saved: " + entitySave.getId());

        return mapper.toCreateDto(entitySave);
    }

    @Override
    public List<ContactDto> getClientsId(Long clientsId) {
        List<Contact> contacts = repository.findByClientId(clientsId);
        return contacts.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> getIdAndType(Long clientsId, String type) {
        List<Contact> contacts = repository.findByIdAndType(clientsId, type);
        return contacts.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
