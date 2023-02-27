package com.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Guest implements Serializable {
    @Serial
    private static final long serialVersionUID = 8245648337454350442L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "guests")
    @ToString.Exclude
    private List<Room> rooms;

}
