package com.example.backend.servise;

import com.example.backend.dto.ContactsCreateDto;
import com.example.backend.dto.ContactsDto;

import java.util.List;

public interface ContactsServise {

    ContactsCreateDto createContacts(ContactsCreateDto dto);

    List<ContactsDto> getClientsId(Long clientId);

    List<ContactsDto> getIdAndType(Long clientsId, String type);
}
