package com.example.carros;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import com.example.carros.domain.dto.CarroDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CarrosApplicationTests {

	@Autowired
	private CarroService service;

	@Test
	void test1() {
		Carro c = new Carro();
		c.setNome("Ferrari");
		c.setTipo("esportivos");

		CarroDTO carro = this.service.save(c);

		Assertions.assertNotNull(carro);

		Long id = c.getId();
		Assertions.assertNotNull(id);

		// Buscar o Objeto
		Optional<CarroDTO> op = service.getCarroById(id);
		Assertions.assertTrue(op.isPresent());

		carro = op.get();
		Assertions.assertEquals("Ferrari", carro.getNome());
		Assertions.assertEquals("esportivos", carro.getTipo());

		// Deletar o objeto
		service.delete(id);

		// Verificar se deletou
		Assertions.assertFalse(service.getCarroById(id).isPresent());
	}

}
