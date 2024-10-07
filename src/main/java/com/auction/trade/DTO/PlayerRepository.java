package com.auction.trade.DTO;

import com.auction.trade.Models.Players;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Players, Integer> {

    List<Players> findByNationality(String nationality);

    List<Players> findByNationality(String nationality, Sort sort);


}
