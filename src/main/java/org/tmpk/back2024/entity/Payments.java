package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payments {
    @Id
    @GeneratedValue(generator="payments_seq")
    @SequenceGenerator(name="payments_seq",sequenceName="PAYMENTS_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "clientid")
    private Long clientId;

    @OneToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "paymenttypeid",referencedColumnName = "id")
    private PaymentType paymentType;

    @Column(name = "value")
    private Double value;
}
