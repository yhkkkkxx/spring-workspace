package com.hana.app.data.dto;

import lombok.*;

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
