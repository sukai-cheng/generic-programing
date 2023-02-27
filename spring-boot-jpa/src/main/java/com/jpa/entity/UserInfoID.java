package com.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoID implements Serializable {
    @Serial
    private static final long serialVersionUID = 1700694403739060145L;

    private String name, telephone;

}
