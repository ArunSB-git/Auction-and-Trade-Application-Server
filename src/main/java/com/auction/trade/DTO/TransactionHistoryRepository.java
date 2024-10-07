package com.auction.trade.DTO;

import com.auction.trade.Models.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Integer> {

    List<TransactionHistory> findAll();
}
