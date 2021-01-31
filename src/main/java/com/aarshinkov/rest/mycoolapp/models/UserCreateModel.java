package com.aarshinkov.rest.mycoolapp.models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreateModel implements Serializable {

    private String username;
    private String password;
    private String gender;
    private String firstName;
    private String lastName;
}
