package com.br.WorkshopMongo.controller;

import com.br.WorkshopMongo.DTO.DadosUserNovo;
import com.br.WorkshopMongo.DTO.UserDTO;
import com.br.WorkshopMongo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;
    @GetMapping
    public ResponseEntity findAll(UserDTO dados){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable String id) {
        var user = repository.findById(id);
        return ResponseEntity.ok(new DadosUserNovo(user));
    }
}
