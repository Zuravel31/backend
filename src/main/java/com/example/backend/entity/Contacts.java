package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Contacts {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String contact_value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clients_id", nullable = false)
    @JsonBackReference
    @ToString.Exclude
    private Clients clients;
}
