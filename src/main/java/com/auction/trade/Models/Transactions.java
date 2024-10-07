package com.auction.trade.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionid;

    private Integer userid;
    private Integer playerid;
    @Column(name = "bid_amount")
    private Integer bidAmount;
    private String status="pending";
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;

}
