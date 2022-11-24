package com.fatec.fomeless.dto;

import com.fatec.fomeless.entities.Comment;
import com.fatec.fomeless.entities.Post;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "Mandatory field: title")
    @Size(min = 10, max = 50, message = "Title must be between 10 and 50 chars")
    private String title;
    @Size(min = 10, max = 250, message = "Description must be between 10 and 250 chars")
    @NotBlank(message = "Mandatory field: description")
    private String description;
    private String date;
    private boolean threadOpen;
    private Integer numberOfComments;
    private List<CommentDTO> comments = new ArrayList<>();

    public PostDTO(Post entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        date = entity.getDate();
        threadOpen = entity.isThreadOpen();
    }
    public PostDTO(Post entity, List<Comment> comments) {
        this(entity);
        numberOfComments = comments.size();
        comments.forEach(comment -> this.comments.add(new CommentDTO(comment)));
    }
}
