package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Department;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@Sql(value={"/sql/seed.sql"})
@RunWith(SpringRunner.class)
public class TeacherServiceTest {

    @Autowired
    TeacherService teacherService;

    @Autowired
    KlassService klassService;
    
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create_createTeacherRecord() throws Exception {
        Teacher teacher = new Teacher("Divya",23, Gender.F);
        Teacher result = this.teacherService.create(teacher);
        assertEquals(1,result.getId());

    }

    @Test
    public void findById_returnsTeacherRecordById() throws Exception {
        Teacher teacher = new Teacher("Divya",23, Gender.F);
        this.teacherService.create(teacher);

        Teacher result = this.teacherService.findById(1);

        assertEquals(1,result.getId());

    }

    @Test
    public void findById_returnsAllTeacherBasedOnGender() throws Exception {
        Teacher teacher = new Teacher("Divya",23, Gender.F);
        this.teacherService.create(teacher);
        Teacher teacher2 = new Teacher("Leela",23, Gender.F);
        this.teacherService.create(teacher2);
        Teacher teacher3 = new Teacher("Geeta",23, Gender.F);
        this.teacherService.create(teacher3);
        Teacher teacher4 = new Teacher("Ravi",23, Gender.M);
        this.teacherService.create(teacher4);

        List<Teacher> result = this.teacherService.findByGender(Gender.F);

        assertEquals(3,result.size());

    }

    @Test
    public void findById_returnsAllTeacherOlderThanAge() throws Exception {
        Teacher teacher = new Teacher("Divya",23, Gender.F);
        this.teacherService.create(teacher);
        Teacher teacher2 = new Teacher("Leela",33, Gender.F);
        this.teacherService.create(teacher2);
        Teacher teacher3 = new Teacher("Geeta",43, Gender.F);
        this.teacherService.create(teacher3);
        Teacher teacher4 = new Teacher("Ravi",53, Gender.M);
        this.teacherService.create(teacher4);

        List<Teacher> result = this.teacherService.findOlderThanAge(30);

        assertEquals(3,result.size());

    }

    @Test
    @Transactional
    public void FindAllClassByTeacher_returnsAllClassById() throws Exception {
        Teacher teacher = new Teacher("Divya",23, Gender.F);
        Teacher newTeacher = this.teacherService.create(teacher);
        Klass klass = new Klass(newTeacher,"English", Calendar.getInstance().getTime(), 1, Department.ENGINEERING,100.50);
        Klass result = this.klassService.create(klass);
        Klass klass2 = new Klass(newTeacher,"Physics", Calendar.getInstance().getTime(), 1, Department.ENGINEERING,100.50);
        Klass result2 = this.klassService.create(klass2);


        assertEquals(1, klass1.getId());
    }
}