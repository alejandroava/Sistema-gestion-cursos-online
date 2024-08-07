package org.example.repository.imodel;

import org.example.model.Grade;
import org.example.repository.crud.CreateGrade;
import org.example.repository.crud.UpdateGrade;

public interface IModelGrade extends
        UpdateGrade<Grade>,
        CreateGrade<Grade>{
}
