package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/transaction/v1/")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    public Transaction getTransaction(Long id){
        return transactionService.getTransaction(id);
    }


}
