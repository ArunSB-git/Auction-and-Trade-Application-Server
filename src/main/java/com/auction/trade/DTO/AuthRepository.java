package com.auction.trade.DTO;

import com.auction.trade.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<Users,Integer> {

    List<Users> findByRole(String role);




}
