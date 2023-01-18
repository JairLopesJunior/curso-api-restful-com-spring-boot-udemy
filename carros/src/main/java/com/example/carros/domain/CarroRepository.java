package com.example.carros.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Long> {

    List<Carro> findByTipo(String tipo);
}
