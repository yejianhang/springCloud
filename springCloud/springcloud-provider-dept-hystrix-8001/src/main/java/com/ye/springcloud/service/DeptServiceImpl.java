package com.ye.springcloud.service;

import com.ye.springcloud.dao.DeptDao;
import com.ye.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements  DeptService {
    @Autowired
    private DeptDao  deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryDeptByID(Long id) {
        return deptDao.queryDeptByID(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
