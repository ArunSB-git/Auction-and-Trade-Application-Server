package com.auction.trade.Controllers;


import com.auction.trade.Models.*;
import com.auction.trade.Service.AuthService;
import com.auction.trade.ErrorResponse;
import com.auction.trade.Service.PlayerService;
import com.auction.trade.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    PlayerService playerService;

    @Autowired
    TransactionService transactionService;

    @PostMapping("/auth")
    @CrossOrigin(origins = "http://localhost:5173")
    public void login() {

    }

    @GetMapping("/listOfUsers")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Users> getUsers(@RequestParam(required = false) String role) {

        if (role != null && !role.isEmpty()) {
            return authService.getAllByUserRole(role);
        } else {

            return authService.getAllUsers();
        }
    }

    @GetMapping("/listOfPlayers")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Players> getPlayers(@RequestParam(required = false) String nationality, @RequestParam(required = false, defaultValue = "desc") String sort) {


        if (nationality != null && !nationality.isEmpty()) {
            return playerService.getAllByPlayerNationality(nationality, sort);
        } else {
            return playerService.getAllByPlayers(sort);
        }
    }

    @PostMapping("/createBid")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> bidPlayer(@RequestBody Transactions transactions) {
        try {
            Transactions createdPlayer = transactionService.createTransaction(transactions);
            return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ErrorResponse("User has already bid."), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/transactionHistory")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<TransactionHistory> getTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping("/updateTransactionStatus")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> updateTransactionStatus(@RequestBody TransactionStatusUpdateRequest request) {
        try {
            Transactions updatedTransaction = transactionService.updateTransactionStatus(request);
            return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


}
