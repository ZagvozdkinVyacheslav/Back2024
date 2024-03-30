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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Clients clientId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Tariffs tariffsId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Services servicesId;

}