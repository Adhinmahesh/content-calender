package adhin.content_calender;

import adhin.content_calender.model.Content;
import adhin.content_calender.model.Status;
import adhin.content_calender.model.Type;
import adhin.content_calender.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ContentCalenderApplication {

	public static void main(String[] args) {

        SpringApplication.run(ContentCalenderApplication.class, args);
	}

    @Bean

    CommandLineRunner commandLineRunner(ContentRepository repository){
        return args ->{
            Content content= new Content(  null,
                    "hello world ",
                    "all about me ",
                    Status.IDEA,
                    Type.VIDEO,
                    LocalDateTime.now(),
                    null,
                    ""
            );
            repository.save(content);

            // we can insert some data in to the data base

        };
    }

}
