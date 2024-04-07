package com.hana.app.data.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    private int itemId;
    private String itemName;
    private int itemPrice;
    private String imgName;
    private LocalDate regDate;
    private LocalDate updateDate;
    private MultipartFile image;
}
