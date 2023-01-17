package com.example.carros.domain;

import java.util.Arrays;
import java.util.List;

public class CarroService {

    public List<Carro> getCarros() {
        return Arrays.asList(
            new Carro(1L, "Fusca"),
            new Carro(2L, "Brasilia"),
            new Carro(3L, "Chevette")
        );
    }
}
