package com.example.carros.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public Optional<Carro> getCarroById(Long id) {
        return rep.findById(id);
    }

    public Iterable<Carro> getCarrosById(String tipo) {
        return rep.findByTipo(tipo);
    }

    public Carro save(Carro carro) {
        return rep.save(carro);
    }
}




















































