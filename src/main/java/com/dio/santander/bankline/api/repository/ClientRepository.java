package com.dio.santander.bankline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dio.santander.bankline.api.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}