package br.dev.diego.events.domain.entities;

import br.dev.diego.events.domain.requests.GroupInsertRequest;
import br.dev.diego.events.domain.requests.GroupUpdateRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    private String address;
    private String city;
    private String stateOrProvince;
    private String country;
    private String postalCode;
    @ManyToOne(cascade= CascadeType.PERSIST)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<Event> events;

    public Group(GroupInsertRequest group) {
        this.name = group.name();
        this.address = group.address();
        this.city = group.city();
        this.stateOrProvince = group.stateOrProvince();
        this.country = group.country();
        this.postalCode = group.postalCode();
        this.user = group.user();
        this.events = group.events();
    }

    public void update(GroupUpdateRequest group) {
        if(group.name() != null) {
            this.name = group.name();
        }
        if(group.address() != null) {
            this.address = group.address();
        }
    }
}
