package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "ClientInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "organisationName")
    private String organisationName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "city")
    private String city;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "street")
    private String street;

    @Column(name = "buildingNumber")
    private String buildingNumber;

    @Column(name = "flatNumber")
    private String flatNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Clients clientTypeId;

}
