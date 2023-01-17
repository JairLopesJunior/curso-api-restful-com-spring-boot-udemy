package com.example.carros.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public Iterable<Carro> getCarros() {
        return rep.findAll();
    }

    public List<Carro> getCarrosFake() {
        return Arrays.asList(
            new Carro(1L, "Fusca"),
            new Carro(2L, "Brasilia"),
            new Carro(3L, "Chevette")
        );
    }
}
