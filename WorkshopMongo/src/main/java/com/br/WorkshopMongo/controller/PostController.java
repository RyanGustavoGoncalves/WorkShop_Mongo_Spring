package com.br.WorkshopMongo.controller;

import com.br.WorkshopMongo.DTO.AutenticarDados;
import com.br.WorkshopMongo.DTO.DadosListagemUsers;
import com.br.WorkshopMongo.DTO.DadosUserNovo;
import com.br.WorkshopMongo.DTO.PostConsult;
import com.br.WorkshopMongo.domain.Post;
import com.br.WorkshopMongo.domain.PostRepository;
import com.br.WorkshopMongo.domain.User;
import com.br.WorkshopMongo.domain.UserRepository;
import com.br.WorkshopMongo.infra.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/post")
public class PostController {
    @Autowired
    private PostRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable String id) {
        Optional<Post> postOptional = repository.findById(id);

        if (postOptional.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado!");
        }

        Post post = postOptional.get(); // Obtendo o User do Optional

        return ResponseEntity.ok(post);
    }
}
