package com.example.backend.dto;

import com.example.backend.entity.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    private ContactType type;

    private String contact_value;
}
