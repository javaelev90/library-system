package se.libsystem.bookserver;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.*;
import java.util.List;

@Entity
@Document(indexName = "books")
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Field
    @Column(name = "title")
    private String title;

    @Field
    @Column(name = "description")
    private String description;

    @Field
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(
            name ="books_authors",
            joinColumns = @JoinColumn(
                    name =  "book_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "author_id",
                    referencedColumnName = "id")
    )
    private List<Author> authorList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}
