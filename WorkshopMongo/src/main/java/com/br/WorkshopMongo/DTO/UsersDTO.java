package com.br.WorkshopMongo.DTO;

import com.br.WorkshopMongo.domain.User;

public record UsersDTO(String id, String name) {

    public UsersDTO(User user) {
        this(user.getId(), user.getName());
    }
}
