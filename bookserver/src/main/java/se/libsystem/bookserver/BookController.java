package se.libsystem.bookserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController("/books")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class BookController {


    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Book> editBook(@RequestBody Book book){
        System.out.println("PUTTING IN BOOK");
        Book result = bookRepository.save(book);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/books")
//                .buildAndExpand(result.getId()).toUri();

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
