package org.example.repository.crud;

import java.util.List;

public interface ReadStudentByID <Entity>{
    public List<Entity> readStudentByID(int id);
}
