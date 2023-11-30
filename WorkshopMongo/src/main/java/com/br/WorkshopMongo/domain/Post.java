package com.br.WorkshopMongo.domain;

import com.br.WorkshopMongo.DTO.CommitDTO;
import com.br.WorkshopMongo.DTO.UserDTO;
import com.br.WorkshopMongo.DTO.UsersDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "post")
public class Post implements Serializable {
    @Id
    private String id;
    private LocalDate date;
    private String title;
    private String body;
    private UsersDTO author;

    private List<CommitDTO> commit = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

