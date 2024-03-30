package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "actionType")
    private String actionType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Clients clientId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Operators operatorId;

    @Column(name = "created")
    private LocalDateTime created;
}