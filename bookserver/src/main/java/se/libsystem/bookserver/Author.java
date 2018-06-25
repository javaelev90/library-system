package se.libsystem.bookserver;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
@JsonIgnoreProperties(value= {"bookList"})
public class Author {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Field
    @Column(name = "first_name")
    private String firstName;

    @Field
    @Column(name = "last_name")
    private String lastName;

    @Field
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL},mappedBy = "authorList")
    @JsonIgnore
    private List<Book> bookList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
