package com.ye.springcloud.controller;


import com.ye.springcloud.pojo.Dept;
import com.ye.springcloud.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "PmsBrandController", description = "商品品牌管理")
//提供restFul服务
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @ApiOperation("add接口说明")
    @PostMapping("/dept/add")
    public boolean addDept(@ApiParam("部门") Dept dept){
       return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryDeptByID(@PathVariable("id") Long id){
        return deptService.queryDeptByID(id);
    }

    @GetMapping("/dept/get")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    /**
     * 获取一些注册进来的微服务的信息~，
     *
     * @return
     */
    @GetMapping("/dept/discovery")
    public Object discovery() {
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);
        // 得到一个具体的微服务信息,通过具体的微服务id，applicaioinName；
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" + // 主机名称
                            instance.getPort() + "\t" + // 端口号
                            instance.getUri() + "\t" + // uri
                            instance.getServiceId() // 服务id
            );
        }
        return this.client;
    }
}
