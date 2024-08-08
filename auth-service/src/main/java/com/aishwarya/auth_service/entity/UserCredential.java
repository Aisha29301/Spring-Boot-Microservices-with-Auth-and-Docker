package com.aishwarya.auth_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;


@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredential {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
//    private Set<String> roles;
}
