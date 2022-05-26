package io.github.rafaelsilva91.springsocial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_comments")
public class Comment implements Serializable {

    private static final long serialVersionUID = -8526882394843332936L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Date date;


    @ManyToOne
    @JoinColumn(name = "author_Id")
    private User author;

    ////////////////////////////////////////////

    @JsonIgnore
    @ManyToMany(mappedBy = "comments")
    private List<Post> posts = new ArrayList<>();


    public Comment() {

    }

    public Comment(Long id, String text, Date date, User author) {
        super();
        this.id = id;
        this.text = text;
        this.date = date;
        this.author = author;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public User getAuthor() {
        return author;
    }


    public void setAuthor(User author) {
        this.author = author;
    }

    //////////////////////////////////////////////////////
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Comment other = (Comment) obj;
        return Objects.equals(id, other.id);
    }

}
