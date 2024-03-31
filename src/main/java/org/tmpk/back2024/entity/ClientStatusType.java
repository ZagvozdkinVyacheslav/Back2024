package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "clientstatustype")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientStatusType {

    @Id
    @GeneratedValue(generator="clientstatustype_seq")
    @SequenceGenerator(name="clientstatustype_seq",sequenceName="CLIENTSTATUSTYPE_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "name")
    private String name;


}