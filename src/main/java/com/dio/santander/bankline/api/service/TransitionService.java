package com.dio.santander.bankline.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dio.santander.bankline.api.dto.NewTransaction;
import com.dio.santander.bankline.api.model.Transaction;
import com.dio.santander.bankline.api.model.Client;
import com.dio.santander.bankline.api.model.TransactionType;
import com.dio.santander.bankline.api.repository.TransactionRepository;
import com.dio.santander.bankline.api.repository.ClientRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository repository;
	
	@Autowired
	private ClientRepository clientRepository;

	public void save(NewTransaction newTransaction) {
		Transaction transaction = new Transaction();
		
		Double value = newTransaction.getType() == TransactionType.INCOME ? newTransaction.getValue() : newTransaction.getValue() * -1;

		transaction.setDateHour(LocalDateTime.now());
		transaction.setDescription(newTransaction.getDescription());
		transaction.setIdAccount(newTransaction.getIdAccount());
		transaction.setType(newTransaction.getType());
		transaction.setValue(value);
		
		Client client = clientRepository.findById(newTransaction.getIdAccount()).orElse(null);
		
		if(client != null) {
			client.getAccount().setBalance(client.getAccount().getBalance() + value);
			clientRepository.save(client);
		}
		
		repository.save(transaction);
	}
}
