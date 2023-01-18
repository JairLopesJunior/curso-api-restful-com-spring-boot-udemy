package com.example.carros.domain;

import com.example.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public List<CarroDTO> getCarros() {
        return rep.findAll().stream()
                .map(CarroDTO::new)
                .collect(Collectors.toList());
    }

    /*public List<Carro> getCarrosFake() {
        return Arrays.asList(
            new Carro(1L, "Fusca"),
            new Carro(2L, "Brasilia"),
            new Carro(3L, "Chevette")
        );
    }*/

    public Optional<CarroDTO> getCarroById(Long id) {
        return rep.findById(id)
                .map(CarroDTO::new);
    }

    public List<CarroDTO> getCarrosByTipo(String tipo) {
        return rep.findByTipo(tipo).stream()
                .map(CarroDTO::new)
                .collect(Collectors.toList());
    }

    public Carro save(Carro carro) {
        return rep.save(carro);
    }

    public CarroDTO update(Carro carro, Long id) {
        Assert.notNull(id, "Não foi possível atualizar o registro");

        return getCarroById(id).map(db -> {
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            rep.save(carro);

            return db;
        }).orElseThrow(() -> new RuntimeException("Não foi possível atualizar o registro"));
    }

    public void delete(Long id) {
        getCarroById(id).ifPresent(carro -> {
            rep.deleteById(id);
        });
    }
}




















































