package adhin.content_calender.controller;

import adhin.content_calender.model.Content;
import adhin.content_calender.repository.ContentCollectionRepository;
import adhin.content_calender.repository.ContentJdbcTemplateRepository;
import adhin.content_calender.repository.ContentRepository;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
    private final ContentRepository repository;

//    private final ContentJdbcTemplateRepository repository;

    // @Autowired is not required  is only one public class
    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }// dependency injunction
    // make a request and final all the piece of the content in the system
    @GetMapping( "")
    public List<Content> findAll(){
        return repository.findAll();



    }
    // Create a read Update Delete - filter | paging and sorting
    @GetMapping("/{id}")   // doubt
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"CONTENT NOT FOUND!"));


    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @ RequestBody Content content){
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content,@PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found");

        }
        repository.save(content);


    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);


    }






}