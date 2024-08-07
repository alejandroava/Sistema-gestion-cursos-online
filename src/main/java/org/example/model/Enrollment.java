package org.example.model;

public class Enrollment {
    private int id;
    private int studentID;
    private int courseID;

    public Enrollment() {
    }

    public Enrollment(int id, int studentID, int courseID) {
        this.id = id;
        this.studentID = studentID;
        this.courseID = courseID;
    }

    public int getId() {
        return id;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", studentID=" + studentID +
                ", courseID=" + courseID +
                '}';
    }
}
