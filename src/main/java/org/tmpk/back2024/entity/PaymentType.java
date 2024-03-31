package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "paymenttype")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentType {

    @Id
    @GeneratedValue(generator="paymenttype_seq")
    @SequenceGenerator(name="paymenttype_seq",sequenceName="PAYMENTTYPE_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "name")
    private String name;

}