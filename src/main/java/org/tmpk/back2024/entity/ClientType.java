package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clienttype")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientType {
    @Id
    @GeneratedValue(generator="clienttype_seq")
    @SequenceGenerator(name="clienttype_seq",sequenceName="CLIENTTYPE_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "name")
    private String name;
}
