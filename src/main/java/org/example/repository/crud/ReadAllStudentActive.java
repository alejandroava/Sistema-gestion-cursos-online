package org.example.repository.crud;

import java.util.List;

public interface ReadAllStudentActive <Entity>{
    public List<Entity> readAllStudentActive(boolean active);
}
