package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "articles")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String header;
    private String body;
    @OneToMany
    private List<User> likes;
    @ManyToOne
    @JsonIgnore
    private User author;
}
