package com.fatec.fomeless.dto;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    @Size(min = 10, max = 50, message = "Title must be between 10 and 50 chars")
    private String title;

    @NotBlank
    @Size(min = 10, max = 250, message = "Description must be between 10 and 250 chars")
    private String description;

    private String date;
    private boolean threadOpen;

    private List<CommentDTO> comments = new ArrayList<>();
    private User user;

    public PostDTO(Post entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        date = entity.getDate();
        threadOpen = entity.isThreadOpen();
    }

    public PostDTO(Post entity, Set<Comment> comments) {
        this(entity);
        comments.forEach(comment -> this.comments.add(new CommentDTO(comment)));

    }
}
