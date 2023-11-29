package com.br.WorkshopMongo.DTO;

import com.br.WorkshopMongo.domain.User;


public record DadosUserNovo(String id, String name, String email) {

    public DadosUserNovo(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }

}
