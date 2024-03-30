package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;

@Entity
@Table(name = "operators")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Operators {
    @Id
    @GeneratedValue(generator="operators_seq")
    @SequenceGenerator(name="operators_seq",sequenceName="OPERATORS_SEQ", allocationSize=1)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "operatorinfoid",referencedColumnName = "id")
    private OperatorInfo operatorInfo;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    private Roles role;

    @Column(name = "creatorid")
    private Long creator;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;
}
