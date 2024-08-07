package org.example.repository.imodel;

import org.example.model.Student;
import org.example.repository.crud.CreateStudentDefaultActive;
import org.example.repository.crud.ReadStudentByEmail;
import org.example.repository.crud.ReadStudentByID;
import org.example.repository.crud.UpdateStudent;

public interface IModelStudent extends
        CreateStudentDefaultActive<Student>,
        ReadStudentByEmail<Student>,
        ReadStudentByID<Student>,
        UpdateStudent<Student> {
}
