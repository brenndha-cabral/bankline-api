package com.dio.santander.bankline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dio.santander.bankline.api.model.Transition;
import java.util.List;

public interface TransitionRepository extends JpaRepository<Transition, Integer> {
  public List<Transition>findByIdAccount(Integer idAccount);
}
