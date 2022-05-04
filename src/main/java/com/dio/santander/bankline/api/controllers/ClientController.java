package com.dio.santander.bankline.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dio.santander.bankline.api.model.Client;
import com.dio.santander.bankline.api.repository.ClientRepository ;

@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private ClientRepository repository;
	@GetMapping
	public List<Client> findAll() {
		return repository.findAll();
	}
}
