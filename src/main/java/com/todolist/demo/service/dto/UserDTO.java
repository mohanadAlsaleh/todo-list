package com.todolist.demo.service.dto;
import com.todolist.demo.enums.Role;
import java.io.Serializable;
import java.util.Objects;


public class UserDTO implements Serializable {
    public UserDTO() {
    }

    private Long id;
    private String username;
    private String password;
    private String email;
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
// You can add other fields as necessary

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof UserDTO)) {
            return false;
        } else {
            UserDTO userDTO = (UserDTO)o;
            return this.id == null ? false : Objects.equals(this.id, userDTO.id);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }

    public String toString() {
        Long var10000 = this.getId();
        return "UserDTO{id=" + var10000 + ", name='" + this.getUsername() + "'}";
    }
}
