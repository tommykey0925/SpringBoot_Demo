package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Department;

@Mapper
public interface DepartmentRepository{
  
  /*
   * 部門テーブル全検索
   * @return 部門データ 
   */
  List<Department> findAll();

  /*
   * 部門テーブル挿入
   * @param department 挿入用リクエストデータ
   * @return 部門データ
   */
  int save(Department department);
}
