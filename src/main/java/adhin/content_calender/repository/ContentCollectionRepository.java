package adhin.content_calender.repository;

import adhin.content_calender.model.Content;
import adhin.content_calender.model.Status;
import adhin.content_calender.model.Type;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList =new ArrayList<>();
    public ContentCollectionRepository(){

    }
    public List<Content> findAll(){
        return contentList;
    }
    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id) ).findFirst();
    }
    // create a new resource and a rest application we use post on the controller
    public void save(Content content){
        contentList.removeIf(c->c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    private void init(){
        Content content= new Content(  1,
                "my first blog post",
                "my first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );
        contentList.add(content);
    }

    public boolean existsById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id) ).count()==1;

    }
    public void delete(Integer id){
        contentList.removeIf(c->c.id().equals(id));

    }


}