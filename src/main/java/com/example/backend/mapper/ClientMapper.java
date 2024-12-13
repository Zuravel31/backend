package com.example.backend.mapper;

import com.example.backend.dto.ClientNameDto;
import com.example.backend.entity.Client;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(componentModel = "spring")
@Component
public interface ClientMapper {
    List<ClientNameDto> toNameDtoList(List<Client> client);

    Client toEntity(ClientNameDto dto);

    ClientNameDto toNameDto(Client entity);
}

