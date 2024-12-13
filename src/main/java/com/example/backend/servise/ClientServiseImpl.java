package com.example.backend.servise;

import com.example.backend.dto.ClientNameDto;
import com.example.backend.entity.Client;
import com.example.backend.mapper.ClientMapper;
import com.example.backend.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ClientServiseImpl implements ClientServise{
    private final ClientMapper mapper;

    private final ClientRepository repository;

    @Override
    public ClientNameDto createClient(ClientNameDto nameDto) {
        Client entity = mapper.toEntity(nameDto);
        Client entitySave = repository.save(entity);
        return mapper.toNameDto(entitySave);
    }

    @Override
    public List<ClientNameDto> getName(String name) {
        List<Client> clients = repository.findByName(name);
        return  mapper.toNameDtoList(clients);
    }

    @Override
    public Optional<Client> getId(Long id) {
        return repository.findById(id);
    }
}
