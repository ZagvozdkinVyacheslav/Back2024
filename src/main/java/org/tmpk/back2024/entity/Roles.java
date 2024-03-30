package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(generator="roles_seq")
    @SequenceGenerator(name="roles_seq",sequenceName="ROLES_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "name")
    private String name;


}