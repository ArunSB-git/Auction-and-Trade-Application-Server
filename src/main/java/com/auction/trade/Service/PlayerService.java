package com.auction.trade.Service;

import com.auction.trade.DTO.PlayerRepository;
import com.auction.trade.Models.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Players> getAllByPlayerNationality(String nationality) {
        return playerRepository.findByNationality(nationality);
    }

    public List<Players> getAllByPlayers(String sortDirection) {
        Sort sort = Sort.by("auctionPrice");
        sort = "asc".equalsIgnoreCase(sortDirection) ? sort.ascending() : sort.descending();

        return playerRepository.findAll(sort);
    }

    public List<Players> getAllByPlayerNationality(String nationality,String sortDirection) {
        Sort sort = Sort.by("auctionPrice");
        sort = "asc".equalsIgnoreCase(sortDirection) ? sort.ascending() : sort.descending();

        return playerRepository.findByNationality(nationality, sort);
    }

    // Method to get a player by ID
    public Players getPlayerById(int playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));
    }

    // Method to update player details
    public Players updatePlayer(Players player) {
        return playerRepository.save(player);
    }


}
