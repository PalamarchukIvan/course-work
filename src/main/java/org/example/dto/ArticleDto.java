package org.example.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String header;
    private String body;
    private List<UserDto> likes;
    private UserDto author;
}
