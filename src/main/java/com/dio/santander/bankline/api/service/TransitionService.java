package com.dio.santander.bankline.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dio.santander.bankline.api.dto.NewTransition;
import com.dio.santander.bankline.api.model.Transition;
import com.dio.santander.bankline.api.model.Client;
import com.dio.santander.bankline.api.model.TransitionType;
import com.dio.santander.bankline.api.repository.TransitionRepository;
import com.dio.santander.bankline.api.repository.ClientRepository;

@Service
public class TransitionService {
	@Autowired
	private TransitionRepository repository;
	
	@Autowired
	private ClientRepository clientRepository;

	public void save(NewTransition newTransition) {
		Transition transition = new Transition();
		
		Double value = newTransition.getType() == TransitionType.INCOME ? newTransition.getValue() : newTransition.getValue() * -1;

		transition.setDateHour(LocalDateTime.now());
		transition.setDescription(newTransition.getDescription());
		transition.setIdAccount(newTransition.getIdAccount());
		transition.setType(newTransition.getType());
		transition.setValue(value);
		
		Client client = clientRepository.findById(newTransition.getIdAccount()).orElse(null);
		
		if(client != null) {
			client.getAccount().setBalance(client.getAccount().getBalance() + value);
			clientRepository.save(client);
		}
		
		repository.save(transition);
	}
}
