package com.ye.springcloud.dao;


import com.ye.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept queryDeptByID(Long id);

    public List<Dept> queryAll();

}
