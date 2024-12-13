package com.example.backend.servise;

import com.example.backend.dto.ClientNameDto;
import com.example.backend.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientServise {
    ClientNameDto createClient(ClientNameDto nameDto);

    List<ClientNameDto> getName(String name);

    Optional<Client> getId(Long id);
}
