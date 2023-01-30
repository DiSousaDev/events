package br.dev.diego.events.domain.repositories;

import br.dev.diego.events.domain.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findByName(String name);

}
