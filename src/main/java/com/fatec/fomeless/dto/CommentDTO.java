package com.fatec.fomeless.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatec.fomeless.entities.Comment;
import com.fatec.fomeless.entities.Post;
import com.fatec.fomeless.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    @Size(min = 10, max = 250, message = "Description must be between 10 and 250 chars")
    private String description;
    private String date;
    private Post post;
    private User user;

    public CommentDTO(Comment entity) {
        id = entity.getId();
        description = entity.getDescription();
        date = entity.getDate();
    }
}
