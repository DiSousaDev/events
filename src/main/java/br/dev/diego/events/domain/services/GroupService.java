package br.dev.diego.events.domain.services;

import br.dev.diego.events.domain.requests.GroupInsertRequest;
import br.dev.diego.events.domain.requests.GroupUpdateRequest;
import br.dev.diego.events.domain.responses.GroupFullResponse;

import java.util.Collection;

public interface GroupService {

    Collection<GroupFullResponse> findAll();
    GroupFullResponse findById(Long id);
    GroupFullResponse save(GroupInsertRequest group);
    GroupFullResponse update(GroupUpdateRequest group, Long id);
    void deleteById(Long id);
}
