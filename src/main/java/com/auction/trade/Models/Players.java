package com.auction.trade.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Players {
    @Id
    private int playerid;

    private String playername;
    private String nationality;
    @Column(name = "auction_price")
    private Integer auctionPrice;
    private String status;
    private String playerImage;

}
