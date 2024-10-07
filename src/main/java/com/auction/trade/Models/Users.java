package com.auction.trade.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    private int userid;

    private String username;
    private String role;
    private String password;
    private Integer amountspend;
    private Integer amountremaining;
    private String userabb;



}
