package com.t1908e.exam_wad.entity;

import com.t1908e.exam_wad.modelAnnotation.Column;
import com.t1908e.exam_wad.modelAnnotation.Entity;
import com.t1908e.exam_wad.modelAnnotation.Id;
import com.t1908e.exam_wad.util.SQLDataTypes;

import java.util.Date;

@Entity(tableName = "employees")
public class Employee {
    @Id(AutoIncrement = true)
    @Column(columnType = SQLDataTypes.INTEGER, columnName = "id")
    private int id;
    @Column(columnName = "fullName", columnType = SQLDataTypes.VARCHAR255)
    private String fullName;
    @Column(columnName = "birthday", columnType = SQLDataTypes.VARCHAR255)
    private String birthDay;
    @Column(columnName = "address", columnType = SQLDataTypes.VARCHAR255)
    private String address;
    @Column(columnName = "position", columnType = SQLDataTypes.VARCHAR255)
    private String position;
    @Column(columnName = "department", columnType = SQLDataTypes.VARCHAR255)
    private String department;

    public Employee() {
    }

    public Employee(String fullName, String birthDay, String address, String position, String department) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.address = address;
        this.position = position;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
