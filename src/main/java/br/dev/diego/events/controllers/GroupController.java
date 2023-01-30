package br.dev.diego.events.controllers;

import br.dev.diego.events.domain.requests.GroupInsertRequest;
import br.dev.diego.events.domain.requests.GroupUpdateRequest;
import br.dev.diego.events.domain.responses.GroupFullResponse;
import br.dev.diego.events.domain.services.GroupService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api")
class GroupController {

    private GroupService groupService;

    @GetMapping("/groups")
    ResponseEntity<Collection<GroupFullResponse>> groups() {
        return ResponseEntity.ok(groupService.findAll());
    }

    @GetMapping("/group/{id}")
    ResponseEntity<GroupFullResponse> getGroup(@PathVariable Long id) {
        GroupFullResponse group = groupService.findById(id);
        return ResponseEntity.ok().body(group);
    }

    @PostMapping("/group")
    ResponseEntity<GroupFullResponse> createGroup(@Valid @RequestBody GroupInsertRequest group) {
        log.info("Request to create group: {}", group);
        GroupFullResponse result = groupService.save(group);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.id()).toUri();
        return ResponseEntity.created(uri).body(result);
    }

    @PutMapping("/group/{id}")
    ResponseEntity<GroupFullResponse> updateGroup(@PathVariable Long id, @RequestBody GroupUpdateRequest group) {
        log.info("Request to update group: {}", group);
        GroupFullResponse result = groupService.update(group, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        log.info("Request to delete group: {}", id);
        groupService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
