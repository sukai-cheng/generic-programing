package com.jpa.entity;

import com.jpa.constants.Gender;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 4315730587998916008L;
    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Long id;
    @Column(name = "last_name",length = 50) //这是和数据表对应的一个列
    private String lastName;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "email",length = 255)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    private Gender gender;

    @Column(name = "address")
    private String address;
    @Version
    private Long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", version=" + version +
                '}';
    }
}
