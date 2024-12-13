package com.example.backend.mapper;

import com.example.backend.dto.ContactCreateDto;
import com.example.backend.dto.ContactDto;
import com.example.backend.entity.Contact;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ContactMapper {
    Contact toEntity(ContactCreateDto dto);

    ContactDto toDto(Contact entity);

    ContactCreateDto toCreateDto(Contact entity);
}
