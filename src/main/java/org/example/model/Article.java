package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    private LocalDateTime createdDate;
    @ManyToMany
    private Set<User> likes;
    @ManyToOne
    @JsonIgnore
    private User author;
}
