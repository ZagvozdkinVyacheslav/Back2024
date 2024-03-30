package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Correction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Correction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Double value;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Clients clientId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Operators operatorId;

    @Column(name = "created")
    private LocalDateTime created;


}
