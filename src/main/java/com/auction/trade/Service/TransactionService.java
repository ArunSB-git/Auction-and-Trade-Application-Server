package com.auction.trade.Service;


import com.auction.trade.DTO.TransactionHistoryRepository;
import com.auction.trade.DTO.TransactionRepository;
import com.auction.trade.Models.Players;
import com.auction.trade.Models.TransactionHistory;
import com.auction.trade.Models.TransactionStatusUpdateRequest;
import com.auction.trade.Models.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    PlayerService playerService;

    @Autowired
    TransactionHistoryRepository transactionHistoryRepository;

    public Transactions createTransaction(Transactions transactions){
        if (transactionRepository.existsByUseridAndPlayerid(transactions.getUserid(), transactions.getPlayerid())) {
            throw new IllegalArgumentException("User has already placed a bid for this player.");
        }
        return transactionRepository.save(transactions);
    }

    public Transactions updateTransactionStatus(TransactionStatusUpdateRequest request) {
        Transactions transaction = transactionRepository.findById(request.getTransactionId())
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found"));

        // Validate the status
        String status = request.getStatus();
        if (!"approved".equalsIgnoreCase(status) && !"rejected".equalsIgnoreCase(status)) {
            throw new IllegalArgumentException("Invalid status. Must be 'approved' or 'rejected'.");
        }

        // Fetch the player to check its status
        Players player = playerService.getPlayerById(transaction.getPlayerid());
        if (!"available".equalsIgnoreCase(player.getStatus())) {
            throw new IllegalArgumentException("Player is not available for bidding.");
        }

        // Update the transaction status
        transaction.setStatus(status);
        Transactions updatedTransaction = transactionRepository.save(transaction);

        // If approved, update the player status
        if ("approved".equalsIgnoreCase(status)) {
            player.setStatus("sold");
            playerService.updatePlayer(player); // Assuming you have an update method in PlayerService
        }

        return updatedTransaction;
    }


    public List<TransactionHistory> getAllTransactions() {
        return transactionHistoryRepository.findAll();
    }
}
