package com.dio.santander.bankline.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dio.santander.bankline.api.dto.NewTransition;
import com.dio.santander.bankline.api.model.Transition;
import com.dio.santander.bankline.api.repository.ClientRepository ;
import com.dio.santander.bankline.api.repository.TransitionRepository;
import com.dio.santander.bankline.api.service.TransitionService;


@RestController
@RequestMapping("/transitions")
public class TransitionController {
	@Autowired
	private TransitionRepository repository;
	@Autowired
	private TransitionService service;
	@GetMapping
	public List<Transition> findAll() {
		return repository.findAll();
	}
	@PostMapping
	public void save(@RequestBody NewTransition transition) {
		service.save(transition);
	}
	@GetMapping("/{idAccount}")
	public List<Transition> findAll(@PathVariable("idAccount") Integer idAccount){
		return repository.findByIdAccount(idAccount);
}
