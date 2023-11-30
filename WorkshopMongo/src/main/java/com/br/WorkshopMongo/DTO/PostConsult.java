package com.br.WorkshopMongo.DTO;


import com.br.WorkshopMongo.domain.Post;

public record PostConsult(String id, String name, String email) {

    public PostConsult(Post post) {
        this(post.getId(), post.getTitle(), post.getBody());
    }

}
