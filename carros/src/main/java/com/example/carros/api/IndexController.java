package com.example.carros.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String get() {
        return "Get Spring Boot";
    }

//    @GetMapping("/login")
//    public String get(@RequestParam("login") String login, @RequestParam("senha") String senha) {
//        return "Login: " + login + ", senha: " + senha;
//    }

    @GetMapping("/login/{login}/senha/{senha}")
    public String get(@PathVariable("login") String login, @PathVariable("senha") String senha) {
        return "Login: " + login + ", senha: " + senha;
    }

    @GetMapping("/carros/{id}")
    public String getCarroById(@PathVariable("id") Long id) {
        return "Carro " + id;
    }

    @GetMapping("/carros/tipo/{tipo}")
    public String getCarroByTipo(@PathVariable("tipo") String tipo) {
        return "Lista de Carros " + tipo;
    }
}
