package com.example.demo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements ApplicationRunner{

  private final DepartmentRepository dr;
  private final EmployeeRepository er;

  @Override
  public void run(ApplicationArguments args) throws Exception{
    //setInitDepartment
    var sales = new Department();
    sales.setName("営業");
    dr.save(sales);

    var development = new Department();
    development.setName("開発");
    dr.save(development);

    var generalAffairs = new Department();
    generalAffairs.setName("総務");
    dr.save(generalAffairs);

    //setInitEmployee
    var satou = new Employee();
    satou.setName("佐藤");
    satou.setDepartment(sales);
    er.save(satou);
    
    var suzuki = new Employee();
    suzuki.setName("鈴木");
    suzuki.setDepartment(development);
    er.save(suzuki);

    var takahashi = new Employee();
    takahashi.setName("高橋");
    takahashi.setDepartment(generalAffairs);
    er.save(takahashi);
  }
}
