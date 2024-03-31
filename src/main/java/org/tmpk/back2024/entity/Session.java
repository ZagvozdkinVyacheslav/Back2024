package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sessions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Session {
    @Id
    @GeneratedValue(generator="sessions_seq")
    @SequenceGenerator(name="sessions_seq",sequenceName="SESSIONS_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "operatorid")
    private Long operatorId;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "expirytime")
    private LocalDateTime expiryTime;
}
