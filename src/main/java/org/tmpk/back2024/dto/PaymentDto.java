package org.tmpk.back2024.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private Long clientId;
    private String paymentType;
    private Double value;
}
