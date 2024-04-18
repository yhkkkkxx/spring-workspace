package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "db_custinfo")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString(exclude = "cust") // or (exclude = "CustInfoEntity")
public class CustInfoEntity {
    @Id
    @Column(name = "custinfo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id")
    private CustEntity cust;
    private String addr;
    private int age;
}
