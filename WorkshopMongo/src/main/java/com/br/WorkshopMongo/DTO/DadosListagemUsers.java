package com.br.WorkshopMongo.DTO;

import com.br.WorkshopMongo.domain.User;

public record DadosListagemUsers(String id,String name, String email) {
    public DadosListagemUsers(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
