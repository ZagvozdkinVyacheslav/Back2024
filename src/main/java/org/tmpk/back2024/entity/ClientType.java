package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ClientType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
