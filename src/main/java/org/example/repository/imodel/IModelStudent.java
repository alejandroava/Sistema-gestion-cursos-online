package org.example.repository.imodel;

import org.example.model.Student;
import org.example.repository.crud.*;

public interface IModelStudent extends
        CreateStudentDefaultActive<Student>,
        ReadStudentByEmail<Student>,
        ReadStudentByID<Student>,
        UpdateStudent<Student>,
        ReadAllStudentActive<Student> {
}
