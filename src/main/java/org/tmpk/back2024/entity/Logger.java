package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "logger")
public class Logger {
    @Id
    @GeneratedValue(generator="logger_seq")
    @SequenceGenerator(name="logger_seq",sequenceName="LOGGER_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "actiontype")
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