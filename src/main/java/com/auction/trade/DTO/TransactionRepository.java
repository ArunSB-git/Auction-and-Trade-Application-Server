package com.auction.trade.DTO;

import com.auction.trade.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer> {

    boolean existsByUseridAndPlayerid(Integer userid, Integer playerid);



}
