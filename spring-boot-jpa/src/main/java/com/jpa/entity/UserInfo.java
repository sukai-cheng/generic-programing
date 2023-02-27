package com.jpa.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@IdClass(UserInfoID.class)
@AllArgsConstructor
public class UserInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = -7381113643332966333L;

    @Id
    private String name;
    @Id
    private String telephone;
    private Integer ages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && Hibernate.getClass(this) == Hibernate.getClass(o);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
