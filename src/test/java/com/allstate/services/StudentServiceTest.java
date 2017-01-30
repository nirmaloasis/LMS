package com.allstate.services;

import com.allstate.entities.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value={"/sql/seed.sql"})
public class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create_createsStudentRecord() throws Exception{
        Student lmsEntity = new Student("ddd@gmail.com");

        Student result = this.service.create(lmsEntity);

        assertEquals(3,result.getId());
    }

    @Test
    public void findById_returnsStudentRecordByFindingId() throws Exception {
        Student result = this.service.findById(1);
        assertEquals("abc@gmail.com",result.getEmail());

    }

    @Test
    public void findById_noRecordFoundThrowsException() throws Exception {
        Student result = this.service.findById(4);
        assertNull(result);

    }

    @Test
    public void findByEmail_returnsStudentRecordByEmail() throws Exception {
        Student result = this.service.findByEmail("abc@gmail.com");
        assertEquals(1,result.getId());

    }

    @Test
    public void findByEmail_noRecordFoundByEmail() throws Exception {
        Student result = this.service.findByEmail("ijnjc@gmail.com");
        assertNull(result);

    }
}