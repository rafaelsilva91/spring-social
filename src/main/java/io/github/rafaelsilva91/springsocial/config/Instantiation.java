package io.github.rafaelsilva91.springsocial.config;

import io.github.rafaelsilva91.springsocial.dto.AuthorDTO;
import io.github.rafaelsilva91.springsocial.entities.Comment;
import io.github.rafaelsilva91.springsocial.entities.Post;
import io.github.rafaelsilva91.springsocial.entities.User;
import io.github.rafaelsilva91.springsocial.repositories.CommentRepository;
import io.github.rafaelsilva91.springsocial.repositories.PostRepository;
import io.github.rafaelsilva91.springsocial.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
@Profile("test")
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        //Usuarios
        User u1 = new User(null, "José João", "jose@email.com");
        User u2 = new User(null, "Maria Siqueira", "maria@email.com");
        User u3 = new User(null, "Joana Arruda", "joana@email.com");
        User u4 = new User(null, "Bruna Silva", "bruna@email.com");
        User u5 = new User(null, "Rafael Rodrigues", "rafael.rodrigues@email.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", u1);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", u1);


        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));

        Post p1 = new Post(null, sdf.parse("28/10/2021"), "Descricao do Titulo do Post 1", " Textos Textos Textos", u1);
        Post p2 = new Post(null, sdf.parse("28/10/2021"), "Descricao do Titulo do Post 2", " Textos Textos Textos"
                + "Textos Textos Textos"
                + "Textos Textos Textos"
                + "Textos Textos Textos"
                + "Textos Textos Textos"
                + "Textos Textos Textos", u1);
        Post p3 = new Post(null, sdf.parse("28/10/2021"), "Descricao do Titulo do Post 3", " Textos Textos Textos", u2);
        Post p4 = new Post(null, sdf.parse("28/10/2021"), "Descricao do Titulo do Post 3", " Textos Textos Textos", u3);
        Post p5 = new Post(null, sdf.parse("28/10/2021"), "Descricao do Titulo do Post 3", " Textos Textos Textos", u3);

        postRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        postRepository.saveAll(Arrays.asList(post1, post2));

        u1.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(u1);

        postRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        Comment c1 = new Comment(null, " COMENTARIO 1", sdf.parse("28/10/2021"), u1);
        Comment c2 = new Comment(null, " COMENTARIO 2", sdf.parse("28/10/2021"), u1);
        Comment c3 = new Comment(null, " COMENTARIO 3", sdf.parse("28/10/2021"), u2);

        commentRepository.saveAll(Arrays.asList(c1, c2, c3));


        p1.getComments().addAll(Arrays.asList(c1, c2, c3));
        p2.getComments().addAll(Arrays.asList(c1, c2));
        p3.getComments().addAll(Arrays.asList(c3));


        commentRepository.saveAll(Arrays.asList(c1, c2, c3));
        postRepository.saveAll(Arrays.asList(p1, p2, p3));

    }
}
