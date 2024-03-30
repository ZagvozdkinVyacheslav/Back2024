package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clients {
    @Id
    @GeneratedValue(generator="clients_seq")
    @SequenceGenerator(name="clients_seq",sequenceName="CLIENTS_SEQ", allocationSize=1)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Balance balanceId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private ClientStatusType clientStatusTypeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private ClientInfo clientInfoId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Operators creatorId;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;
}
