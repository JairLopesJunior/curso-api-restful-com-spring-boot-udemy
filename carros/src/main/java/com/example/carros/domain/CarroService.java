package com.example.carros.domain;

import com.example.carros.domain.dto.CarroDTO;
import com.example.carros.domain.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public List<CarroDTO> getCarros() {
        return rep.findAll().stream()
                .map(CarroDTO::create)
                .collect(Collectors.toList());
    }

    /*public List<Carro> getCarrosFake() {
        return Arrays.asList(
            new Carro(1L, "Fusca"),
            new Carro(2L, "Brasilia"),
            new Carro(3L, "Chevette")
        );
    }*/

    public CarroDTO getCarroById(Long id) {
        return rep.findById(id)
                .map(CarroDTO::create)
                .orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado!!"));
    }

    public List<CarroDTO> getCarrosByTipo(String tipo) {
        return rep.findByTipo(tipo).stream()
                .map(CarroDTO::create)
                .collect(Collectors.toList());
    }

    public CarroDTO save(Carro carro) {
        return CarroDTO.create(rep.save(carro));
    }

    public CarroDTO update(Carro carro, Long id) {
        Assert.notNull(id, "Não foi possível atualizar o registro");

        if(getCarroById(id) != null) {
            CarroDTO db = new CarroDTO();
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            rep.save(carro);

            return db;
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        if(getCarroById(id) != null) {
            rep.deleteById(id);
            return true;
        }
        return false;
    }
}




















































