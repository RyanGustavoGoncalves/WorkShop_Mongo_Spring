package com.br.WorkshopMongo.controller;

import com.br.WorkshopMongo.DTO.*;
import com.br.WorkshopMongo.domain.User;
import com.br.WorkshopMongo.domain.UserRepository;
import com.br.WorkshopMongo.infra.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable String id) {
        Optional<User> userOptional = repository.findById(id);

        if (userOptional.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado!");
        }

        User user = userOptional.get(); // Obtendo o User do Optional

        return ResponseEntity.ok(new DadosUserNovo(user));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsers>> listar(@PageableDefault(size = 10, sort = {"name"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemUsers::new);
        return ResponseEntity.ok(page);
    }
    @Transactional
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody AutenticarDados dados, UriComponentsBuilder uriComponentsBuilder) {
        // Verificar se o usuário já existe

        User newUser = new User(dados.name(), dados.email());
        repository.save(newUser);

        // Construir a URI para o novo usuário
        var uri = uriComponentsBuilder.path("/users/{id_User}").buildAndExpand(newUser.getId()).toUri();

        // Retornar uma resposta 201 Created com a URI e o corpo do novo usuário
        return ResponseEntity.created(uri).body(newUser);
    }
}
