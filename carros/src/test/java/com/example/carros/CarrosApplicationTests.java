package com.example.carros;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import com.example.carros.domain.dto.CarroDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class CarrosApplicationTests {

	@Autowired
	private CarroService service;

	@Test
	void testSave() {
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

	@Test
	public void testLista() {

		List<CarroDTO> carros = service.getCarros();

		Assertions.assertEquals(30, carros.size());
	}

	@Test
	public void testGet() {

		Optional<CarroDTO> op = service.getCarroById(11L);

		Assertions.assertTrue(op.isPresent());

		CarroDTO carroDTO = op.get();

		Assertions.assertEquals("Ferrari FF", carroDTO.getNome());
	}

	@Test
	public void testListaPorTipo() {
		Assertions.assertEquals(10, service.getCarrosByTipo("classicos").size());
		Assertions.assertEquals(10, service.getCarrosByTipo("esportivos").size());
		Assertions.assertEquals(10, service.getCarrosByTipo("luxo").size());
	}
}





















