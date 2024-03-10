package com.richcodes.librarian;

import java.util.Objects;
import java.util.UUID;

public class Librarian {

    private String name;
    private UUID id;
    private String password;

    public Librarian() {
        this.name = "riches ";
        this.password = "password1";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return Objects.equals(name, librarian.name) && Objects.equals(id, librarian.id) && Objects.equals(password, librarian.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, password);
    }
}
