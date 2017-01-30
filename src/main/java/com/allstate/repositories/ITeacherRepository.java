package com.allstate.repositories;


import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ITeacherRepository extends CrudRepository<Teacher,Integer>{

    public List<Teacher> findByGender(Gender gender);
    public List<Teacher> findByAgeGreaterThan(int age);

}
