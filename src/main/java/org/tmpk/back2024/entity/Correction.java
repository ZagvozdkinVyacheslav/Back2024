package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "correction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Correction {
    @Id
    @GeneratedValue(generator="correction_seq")
    @SequenceGenerator(name="correction_seq",sequenceName="CORRECTION_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "value")
    private Double value;

    @Column(name = "clientid")
    private Long clientId;

    @Column(name = "operatorid")
    private Long operatorId;

    @Column(name = "created")
    private LocalDateTime created;


}
