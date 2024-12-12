package com.example.backend.servise;

import com.example.backend.dto.ClientsDto;
import com.example.backend.dto.ClientsNameDto;
import com.example.backend.entity.Clients;
import com.example.backend.mapper.ClientsMapper;
import com.example.backend.repository.ClientsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ClientsServiseImpl implements ClientsServise{
    private final ClientsMapper mapper;

    private final ClientsRepository repository;

    @Override
    public ClientsNameDto createClients(ClientsNameDto nameDto) {
        Clients entity = mapper.toEntity(nameDto);
        Clients entitySave = repository.save(entity);
        return mapper.toNameDto(entitySave);
    }

    @Override
    public List<ClientsNameDto> getName(String name) {
        List<Clients> clients = repository.findByName(name);
        return  mapper.toNameDtoList(clients);
    }

    @Override
    public Optional<Clients> getId(Long id) {
        return repository.findById(id);
    }
}
