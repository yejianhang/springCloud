package com.ye.springcloud.service;

import com.ye.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryDeptByID(Long id);

    public List<Dept> queryAll();
}
