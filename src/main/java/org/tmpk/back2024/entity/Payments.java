package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Clients clientId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private PaymentType paymentTypeId;

    @Column(name = "value")
    private Double value;
}
