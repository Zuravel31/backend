package com.example.backend.dto;

import com.example.backend.entity.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactCreateDto {
    private Long clientsId;

    private ContactType type;

    private String contact_value;
}
