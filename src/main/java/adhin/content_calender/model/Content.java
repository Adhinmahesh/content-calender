package adhin.content_calender.model;

// this content is record not a class


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Content(
        @Id
        Integer id,
        @NotBlank
        String title,
        String desc,
        Status status,
        //donot import Type just manually type it
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,

        String url
){

}




