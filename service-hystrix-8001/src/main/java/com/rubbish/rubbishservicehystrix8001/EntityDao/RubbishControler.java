package com.rubbish.rubbishservicehystrix8001.EntityDao;



import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.rubbish.rubbishservicehystrix8001.Entity.Rubbish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RubbishControler {
    @Autowired
    RubbishService service;
    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/get/{id}")
    //一旦调用方法失败后爱抛出错误信息后会自动调用@HystrixCommand标注好的fallbackMethod对应的方法。
    @HystrixCommand(fallbackMethod = "processHystrix_GetByID")
    public Rubbish selectById(@PathVariable("id") int id){
        Rubbish rubbish = service.queryByRuId(id);
        if(rubbish == null){
            throw new RuntimeException("查询的ID是" + id + "没有对应的信息");
        }
        return rubbish;
    }
    public Rubbish processHystrix_GetByID(@PathVariable("id") int id){
        Rubbish rubbish = new Rubbish();
        rubbish.setName("查询的ID是" + id + "没有对应的信息" + "null-->@HystrixCommand");
        rubbish.setSource("查询的ID是" + id + "没有对应的名称");
        return rubbish;
    }
    @RequestMapping("/get/all")
    public List<Rubbish> selectAll(){
        return service.selectAll();
    }
    @RequestMapping(value = "/post/add",method = RequestMethod.POST)
    public Rubbish insert(@RequestBody Rubbish rubbish){
        System.out.println(rubbish.getName() + " " + rubbish.getName() + " service" );
         return service.save(rubbish);
    }
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        service.deleteByRuid(id);
    }
    @RequestMapping(value = "/put",method = RequestMethod.POST)
    public Rubbish update(@RequestBody Rubbish rubbish){
        return service.save(rubbish);
    }
    @RequestMapping("/get/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println("出现的服务的名称" + services);
        List<ServiceInstance> service = discoveryClient.getInstances("RUBBISH-SERVER");
        for(ServiceInstance serviceInstance : service){
            System.out.println(serviceInstance.getHost() + " " + serviceInstance.getInstanceId() + " " + serviceInstance.getPort() + " " + serviceInstance.getUri());
        }
        return discoveryClient;
    }
}
