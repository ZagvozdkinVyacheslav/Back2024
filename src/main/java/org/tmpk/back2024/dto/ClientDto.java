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
public class ClientDto {
    private Long balance;

    private Long limit;

    private String clientStatusType;

    private String clientType;

    private String lastname;

    private String firstname;

    private String middlename;

    private String organisationName;

    private String phoneNumber;

    private Date birthdate;

    private String city;

    private String postalCode;

    private String street;

    private String buildingNumber;

    private String flatNumber;
    private Long creatorId;
}
