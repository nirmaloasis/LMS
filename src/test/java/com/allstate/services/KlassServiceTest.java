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
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 30/01/17.
 */
@SpringBootTest
@Sql(value ={"/sql/seed.sql"})
@RunWith(SpringRunner.class)
public class KlassServiceTest {
    @Autowired
    private KlassService klassService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create_CreatesAClassRecord() throws Exception {
        System.out.println(Calendar.getInstance().getTime());
        Klass klass = new Klass("Physics", Calendar.getInstance().getTime(), 1, Department.ENGINEERING,100.50);
        Klass result = this.klassService.create(klass);

        assertEquals(2,result.getId());

    }

    @Test
    @Transactional
    public void shouldFindOneKlassById() throws Exception {
        Klass klass = new Klass("Physics", Calendar.getInstance().getTime(), 1, Department.ENGINEERING,100.50);
        Klass result = this.klassService.create(klass);
        Klass klass1 = this.klassService.findById(1);
        assertEquals(1, klass1.getId());
    }

    @Test
    @Transactional
    public void shouldFindOneKlassByName() throws Exception {
        Klass klass = new Klass("English", Calendar.getInstance().getTime(), 1, Department.ENGINEERING,100.50);
        Klass result = this.klassService.create(klass);
        Klass klass1 = this.klassService.findByName("English");
        assertEquals(1, klass1.getId());
    }

}