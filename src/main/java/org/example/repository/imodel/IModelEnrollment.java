package org.example.repository.imodel;

import org.example.model.Enrollment;
import org.example.repository.crud.*;

public interface IModelEnrollment extends
        CreateEnrollment<Enrollment>,
        EnrollmentCourseExist<Enrollment>,
        EnrollmentStudentExist<Enrollment>,
        DeleteEnrollment<Enrollment>,
        IsStudentEnrollment<Enrollment>,
        CountEnrollment<Enrollment>{
}
