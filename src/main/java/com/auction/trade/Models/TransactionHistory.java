package com.auction.trade.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "transactions")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionid;

    private Integer userid;
    private Integer playerid;

    @Column(name = "bid_amount")
    private Integer bidAmount;

    private String status = "pending";

    // Assuming you have a Player entity
    @ManyToOne
    @JoinColumn(name = "playerid", insertable = false, updatable = false)
    private Players player; // Assuming you have a Player entity

    // Assuming you have a User entity
    @ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private Users user; // Assuming you have a User entity

}
