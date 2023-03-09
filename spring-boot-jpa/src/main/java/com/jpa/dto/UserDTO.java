package com.jpa.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDTO {
    private String firstName;

    private List<String> userIdList;

    private List<Integer> ageList;

    private Date birthDayBegin;

    private Date birthDayEnd;
}
