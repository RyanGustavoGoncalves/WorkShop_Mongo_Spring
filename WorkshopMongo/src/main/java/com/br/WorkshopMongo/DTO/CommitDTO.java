package com.br.WorkshopMongo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

public record CommitDTO(String text, LocalDate date, UsersDTO author) implements Serializable {

    public CommitDTO(String text, LocalDate date, UsersDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }
}
