package org.tmpk.back2024.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorrectionDto {
    private Long clientId;
    private Long operatorId;
    private Double value;
}
