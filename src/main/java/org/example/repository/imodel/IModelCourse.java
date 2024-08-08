package org.example.repository.imodel;

import org.example.model.Course;
import org.example.repository.crud.CreateCourse;
import org.example.repository.crud.DeleteCourseWihtoutStudent;
import org.example.repository.crud.HasEnrollment;
import org.example.repository.crud.ReadAllCourse;

public interface IModelCourse extends
        CreateCourse<Course>,
        ReadAllCourse<Course>,
        DeleteCourseWihtoutStudent<Course>,
        HasEnrollment<Course> {
}
