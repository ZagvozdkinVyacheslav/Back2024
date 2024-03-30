package org.tmpk.back2024.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorDto {
    private String lastname;
    private String firstname;
    private String middlename;
    private String phoneNumber;
    private Date birthdate;
    private String login;
    private String password;
    private String role;
    private Long creatorId;
}
