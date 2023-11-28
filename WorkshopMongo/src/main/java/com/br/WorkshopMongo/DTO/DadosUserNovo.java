package com.br.WorkshopMongo.DTO;

import com.br.WorkshopMongo.domain.User;

import java.util.Optional;

public record DadosUserNovo(Optional<User> user) {
}
