package com.dio.santander.bankline.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dio.santander.bankline.api.dto.NewClient;
import com.dio.santander.bankline.api.model.Client;
import com.dio.santander.bankline.api.repository.ClientRepository;
import com.dio.santander.bankline.api.model.Account;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;
	public void save(NewClient newClient) {
		Client client = new Client();
		client.setCpf(newClient.getCpf());
		client.setName(newClient.getName());
		
		Account account = new Account();
		account.setBalance(0.0);
		account.setNumber(new Date().getTime());

		client.setAccount(account);
		repository.save(client);
	}
}
