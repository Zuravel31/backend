package com.example.backend.servise;

import com.example.backend.dto.ContactCreateDto;
import com.example.backend.dto.ContactDto;

import java.util.List;

public interface ContactServise {
    ContactCreateDto createContacts(ContactCreateDto dto);

    List<ContactDto> getClientsId(Long clientId);

    List<ContactDto> getIdAndType(Long clientsId, String type);
}
