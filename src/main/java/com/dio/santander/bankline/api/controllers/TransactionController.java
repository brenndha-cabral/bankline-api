package com.dio.santander.bankline.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dio.santander.bankline.api.dto.NewTransaction;
import com.dio.santander.bankline.api.model.Transaction;
import com.dio.santander.bankline.api.repository.ClientRepository ;
import com.dio.santander.bankline.api.repository.TransactionRepository;
import com.dio.santander.bankline.api.service.TransactionService;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	private TransactionRepository repository;
	@Autowired
	private TransactionService service;
	@GetMapping
	public List<Transaction> findAll() {
		return repository.findAll();
	}
	@PostMapping
	public void save(@RequestBody NewTransaction transaction) {
		service.save(transaction);
	}
	@GetMapping("/{idAccount}")
	public List<Transaction> findAll(@PathVariable("idAccount") Integer idAccount){
		return repository.findByIdAccount(idAccount);
	}
}
