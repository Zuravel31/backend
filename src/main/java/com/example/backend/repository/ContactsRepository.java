package com.example.backend.repository;

import com.example.backend.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Long> {
    List<Contacts> findByIdAndType(Long clientsId, String type);

    List<Contacts> findByClientsId(Long clientsID);


}
