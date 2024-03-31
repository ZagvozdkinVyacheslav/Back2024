package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "expenses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expenses {
    @Id
    @GeneratedValue(generator="expenses_seq")
    @SequenceGenerator(name="expenses_seq",sequenceName="EXPENSES_SEQ", allocationSize=1)
    private Long id;


    @Column(name = "clientid")
    private Long clientId;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "servicetariffid",referencedColumnName = "id")
    private ServiceTariff serviceTariff;

    @Column(name = "value")
    private Double value;
}
