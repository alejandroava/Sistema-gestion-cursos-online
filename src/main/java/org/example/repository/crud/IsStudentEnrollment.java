package org.example.repository.crud;

public interface IsStudentEnrollment <Entity>{
    public boolean isStudentEnrollment(int studentID, int courseID);
}
