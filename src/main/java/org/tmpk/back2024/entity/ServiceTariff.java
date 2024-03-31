package org.tmpk.back2024.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "servicetariff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServiceTariff {

    @Id
    @GeneratedValue(generator="servicetariff_seq")
    @SequenceGenerator(name="servicetariff_seq",sequenceName="SERVICETARIFF_SEQ", allocationSize=1)
    private Long id;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @JoinColumn(name = "clientid",referencedColumnName = "id")
    private Clients client;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @JoinColumn(name = "tariffsid",referencedColumnName = "id")
    private Tariffs tariffs;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @JoinColumn(name = "servicesid",referencedColumnName = "id")
    private Services services;

}