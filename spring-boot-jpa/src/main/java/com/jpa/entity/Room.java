package com.jpa.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Room implements Serializable {
    @Serial
    private static final long serialVersionUID = 353469695178473427L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToMany
    @ToString.Exclude
    private List<Guest> guests;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Room room = (Room) o;
        return getId() != null && Objects.equals(getId(), room.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
