package br.dev.diego.events.domain.responses;

import br.dev.diego.events.domain.entities.Event;
import br.dev.diego.events.domain.entities.Group;
import br.dev.diego.events.domain.entities.User;

import java.util.Set;

public record GroupFullResponse(Long id, String name, String address, String city, String stateOrProvince,
                                String country, String postalCode, User user, Set<Event> events) {

    public GroupFullResponse(Group entity) {
        this(entity.getId(), entity.getName(), entity.getAddress(), entity.getCity(), entity.getStateOrProvince(),
                entity.getCountry(), entity.getPostalCode(), entity.getUser(), entity.getEvents());
    }
}
