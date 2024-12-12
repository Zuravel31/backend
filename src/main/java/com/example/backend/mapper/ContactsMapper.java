package com.example.backend.mapper;

import com.example.backend.dto.ContactsCreateDto;
import com.example.backend.dto.ContactsDto;
import com.example.backend.entity.Contacts;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ContactsMapper {
    Contacts toEntity(ContactsCreateDto dto);

    ContactsDto toDto(Contacts entity);

    ContactsCreateDto toCreateDto(Contacts entity);


}
