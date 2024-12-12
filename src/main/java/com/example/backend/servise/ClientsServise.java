package com.example.backend.servise;

import com.example.backend.dto.ClientsDto;
import com.example.backend.dto.ClientsNameDto;
import com.example.backend.entity.Clients;

import java.util.List;
import java.util.Optional;

public interface ClientsServise {
    ClientsNameDto createClients(ClientsNameDto nameDto);

    List<ClientsNameDto> getName(String name);

    Optional<Clients> getId(Long id);
}
