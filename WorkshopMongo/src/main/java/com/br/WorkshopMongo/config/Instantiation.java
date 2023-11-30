package com.br.WorkshopMongo.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.br.WorkshopMongo.DTO.CommitDTO;
import com.br.WorkshopMongo.DTO.UsersDTO;
import com.br.WorkshopMongo.domain.Post;
import com.br.WorkshopMongo.domain.PostRepository;
import com.br.WorkshopMongo.domain.User;
import com.br.WorkshopMongo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {


        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new UsersDTO(maria), new ArrayList<>());
        Post post2 = new Post(null, LocalDate.now(), "Bom dia", "Acordei feliz hoje!", new UsersDTO(maria), new ArrayList<>());

        CommitDTO c1 = new CommitDTO("Boa viagem mano!", LocalDate.now(), new UsersDTO(alex));
        CommitDTO c2 = new CommitDTO("Aproveite", LocalDate.now(), new UsersDTO(bob));
        CommitDTO c3 = new CommitDTO("Tenha um ótimo dia!", LocalDate.now(), new UsersDTO(alex));

        post1.getCommit().addAll(Arrays.asList(c1, c2));
        post2.getCommit().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }

}