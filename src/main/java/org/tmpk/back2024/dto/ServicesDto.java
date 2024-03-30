package org.tmpk.back2024.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicesDto {
    private String name;

    private String tariffName;

    private String tariffDescription;

    private Double tariffPrice;
}
