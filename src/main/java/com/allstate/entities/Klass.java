package com.allstate.entities;

import com.allstate.enums.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Data
@Table(name = "klasses")
public class Klass {

    private int id;
    private int version;
    private Teacher teacher;
    private String name;
    private Date semester;
    private int credits;
    private Department department;
    private double fee;
    private Date created;
    private Date modified;

    public Klass(Teacher teacher, String name, Date semester, int credits, Department department, double fee) {
        this.teacher = teacher;
        this.name = name;
        this.semester = semester;
        this.credits = credits;
        this.department = department;
        this.fee = fee;
    }

    public Klass() {
    }

    @Id
    @GeneratedValue public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @ManyToOne
    @JoinColumn(name="teacher_id")
    @JsonIgnore
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @NotNull
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public Date getSemester() {
        return semester;
    }
    public void setSemester(Date semester) {
        this.semester = semester;
    }

    @NotNull
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }

    @NotNull
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @NotNull
    public double getFee() {
        return fee;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }

}
