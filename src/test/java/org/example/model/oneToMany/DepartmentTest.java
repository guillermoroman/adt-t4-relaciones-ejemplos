package org.example.model.oneToMany;

import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentTest {

    @Test
    public void persistDepartment(){
        Department newDepartment = new Department();
        newDepartment.setName("Ventas");

        Employee employee1 = new Employee();
        employee1.setName("Celestino");

        Employee employee2 = new Employee();
        employee2.setName("Rigoberta");

        List<Employee> employees = new ArrayList();
        employees.add(employee1);
        employees.add(employee2);

        newDepartment.setEmployees(employees);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(newDepartment);

        session.getTransaction().commit();

        assertNotNull(newDepartment.getId());
        assertNotNull(employee2.getId());
        assertNotNull(employee1.getId());


    }
}
