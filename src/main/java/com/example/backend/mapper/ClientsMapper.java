package com.example.backend.mapper;

import com.example.backend.dto.ClientsDto;
import com.example.backend.dto.ClientsNameDto;
import com.example.backend.entity.Clients;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ClientsMapper {
    List<ClientsNameDto> toNameDtoList(List<Clients> clients);


    Clients toEntity(ClientsNameDto dto);

    ClientsNameDto toNameDto(Clients entity);




}
