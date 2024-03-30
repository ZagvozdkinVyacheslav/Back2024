package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Balance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balanceValue")
    private Double balanceValue;

    @Column(name = "limitValue")
    private Double limitValue;

    @Column(name = "modified")
    private LocalDateTime modified;

}