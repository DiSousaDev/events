package br.dev.diego.events.domain.services.impl;

import br.dev.diego.events.domain.entities.Group;
import br.dev.diego.events.domain.requests.GroupInsertRequest;
import br.dev.diego.events.domain.requests.GroupUpdateRequest;
import br.dev.diego.events.domain.responses.GroupFullResponse;
import br.dev.diego.events.domain.repositories.GroupRepository;
import br.dev.diego.events.domain.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

    private GroupRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Collection<GroupFullResponse> findAll() {
        return repository.findAll().stream().map(GroupFullResponse::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public GroupFullResponse findById(Long id) {
        Group group = repository.getReferenceById(id);
        return new GroupFullResponse(group);
    }

    @Override
    @Transactional
    public GroupFullResponse save(GroupInsertRequest group) {
        Group save = repository.save(new Group(group));
        return new GroupFullResponse(save);
    }

    @Override
    @Transactional
    public GroupFullResponse update(GroupUpdateRequest group, Long id) {
        Group entity = repository.getReferenceById(id);
        entity.update(group);
        return new GroupFullResponse(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
