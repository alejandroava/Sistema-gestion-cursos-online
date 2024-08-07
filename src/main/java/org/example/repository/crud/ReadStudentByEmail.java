package org.example.repository.crud;

import java.util.List;

public interface ReadStudentByEmail <Entity>{
    public Entity readStudentByEmail(String email);
}
