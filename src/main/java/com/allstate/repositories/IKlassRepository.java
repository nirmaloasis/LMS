package com.allstate.repositories;

import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by localadmin on 30/01/17.
 */
public interface IKlassRepository extends CrudRepository<Klass, Integer> {

    public Klass findByName(String name);
}
