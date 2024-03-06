package com.richcodes.user;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final String fullName;
    private final UUID id;
    private final String email;
    private final String username;

    public User(String fullName, UUID id,String email, String username) {
        this.fullName = fullName;
        this.id = id;
        this.email = email;
        this.username = username;

    }

    public String getFullName() {
        return fullName;
    }

    public UUID getId() {
        return id;
    }



    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", id=" + id +

                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(fullName, user.fullName) && Objects.equals(id, user.id) &&  Objects.equals(email, user.email) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, id, email, username);
    }
}



