package com.example.lapweek_2.services;

import com.example.lapweek_2.enums.EmployeeStatus;
import com.example.lapweek_2.models.Employee;
import com.example.lapweek_2.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepository repository;

    public EmployeeService() {
        this.repository = new EmployeeRepository();
    }
    public void inssertEmp(Employee employee){
        repository.insertEmp(employee);
    }
    public void update(Employee employee){repository.update(employee);}
    public Optional<Employee> findbyId(long id){
        return repository.findbyId(id);
    }
    public boolean delete(long id){
        Optional<Employee> op = findbyId(id);
        if(op.isPresent()){
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.TERMINATED);
            return true;
        }
        return false;
    }
    public boolean activeEmp(long id) {
        Optional<Employee> op = findbyId(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public List<Employee> getAll(){
        return repository.getAllEmp();
    }

}
