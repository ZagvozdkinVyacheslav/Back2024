package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Operators")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Operators {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operatorInfoId")
    private Long operatorInfoId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Roles roleId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Operators creatorId;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;
}
