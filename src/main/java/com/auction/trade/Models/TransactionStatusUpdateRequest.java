package com.auction.trade.Models;

import lombok.Data;

@Data
public class TransactionStatusUpdateRequest {
    private int transactionId;
    private String status; // "approved" or "rejected"
}
