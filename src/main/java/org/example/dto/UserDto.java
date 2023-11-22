package org.example.dto;

import lombok.*;
import org.example.model.Role;

import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private Boolean isActive;
    private Set<Long> articleIds;
    private List<Role> role;
}
