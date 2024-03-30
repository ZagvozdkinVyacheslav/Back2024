package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "clientinfo")
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

    @Column(name = "organisationname")
    private String organisationName;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "city")
    private String city;

    @Column(name = "postalcode")
    private String postalCode;

    @Column(name = "street")
    private String street;

    @Column(name = "buildingnumber")
    private String buildingNumber;

    @Column(name = "flatnumber")
    private String flatNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Clients clientTypeId;

}
