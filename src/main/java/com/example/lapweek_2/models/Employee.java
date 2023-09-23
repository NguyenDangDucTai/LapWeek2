package com.example.lapweek_2.models;

import com.example.lapweek_2.enums.EmployeeStatus;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table (name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e where e.status = ?1"),
        @NamedQuery(name = "Employee.findbyId", query = "select e from Employee e where e.emp_id =?1")
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long emp_id;
    @Column(name= "full_name", length = 150, nullable = false)
    private String fullName;
    @Column(name = "dob", nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private Date dob;
    @Column(name = "email", unique = true, length = 150)
    private String email;
    @Column(name = "address", length = 150, nullable = false)
    private String address;
    @Column(name = "phone", length = 10, nullable = false)
    private String phone;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus status;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Order> lstOrder;

    public Employee() {
    }

    public Employee(String fullName, Date dob, String email, String address, String phone, EmployeeStatus status) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public List<Order> getLstOrder() {
        return lstOrder;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", lstOrder=" + lstOrder +
                '}';
    }
}
