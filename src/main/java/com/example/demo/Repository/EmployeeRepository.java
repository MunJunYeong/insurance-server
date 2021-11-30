package com.example.demo.Repository;

import com.example.demo.Domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {
    private final EntityManager em;


    public Optional<Employee> findByLoginId(String loginId){
        //findAll().stream() 루프를 돌면서 찾는다
        return findAll().stream().filter(
                        e -> e.getId().equals(loginId))
                .findFirst();
    }
    private List<Employee> findAll() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }
}
