package com.hana.app.data.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddrDto {
    private int addrId;
    private String addrName;
    private String addrDetail;
    private String custId;
}
