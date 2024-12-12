package com.example.backend.servise;

import com.example.backend.dto.ContactsCreateDto;
import com.example.backend.dto.ContactsDto;
import com.example.backend.entity.Clients;
import com.example.backend.entity.Contacts;
import com.example.backend.mapper.ContactsMapper;
import com.example.backend.repository.ClientsRepository;
import com.example.backend.repository.ContactsRepository;
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
public class ContactsServiseImpl implements ContactsServise {
    private final ContactsMapper mapper;

    private final ContactsRepository repository;

    private final ClientsRepository clientsRepository;

    @Transactional
    @Override
    public ContactsCreateDto createContacts(ContactsCreateDto dto) {
        Clients client = clientsRepository.findById(dto.getClientsId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));

        System.out.println("Client found: " + client.getId());

        Contacts entity = mapper.toEntity(dto);
        entity.setClients(client); // Установите связь с клиентом
        System.out.println("Contacts entity created: " + entity);

        Contacts entitySave = repository.save(entity);
        System.out.println("Contacts entity saved: " + entitySave.getId());

        return mapper.toCreateDto(entitySave);
    }

    @Override
    public List<ContactsDto> getClientsId(Long clientsId) {
        List<Contacts> contacts = repository.findByClientsId(clientsId);
        return contacts.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContactsDto> getIdAndType(Long clientsId, String type) {
        List<Contacts> contacts = repository.findByIdAndType(clientsId, type);
        return contacts.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
