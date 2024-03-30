package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Tariffs tariffId;
}
