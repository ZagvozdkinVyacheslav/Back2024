package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
@Entity
@Table(name = "operatorinfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorInfo {
    @Id
    @GeneratedValue(generator="operatorinfo_seq")
    @SequenceGenerator(name="operatorinfo_seq",sequenceName="OPERATORINFO_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "birthdate")
    private Date birthdate;

}