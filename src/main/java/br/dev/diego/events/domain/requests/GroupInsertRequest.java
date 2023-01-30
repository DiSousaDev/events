package br.dev.diego.events.domain.requests;

import br.dev.diego.events.domain.entities.Event;
import br.dev.diego.events.domain.entities.User;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record GroupInsertRequest(Long id, @NotBlank(message = "Campo não pode ser vazio.") String name, String address, String city, String stateOrProvince,
                                 String country, String postalCode, User user, Set<Event> events) {
}
