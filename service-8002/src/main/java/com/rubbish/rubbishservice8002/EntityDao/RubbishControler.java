package com.rubbish.rubbishservice8002.EntityDao;


import com.rubbish.rubbishservice8002.Entity.Rubbish;
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
    public Rubbish selectById(@PathVariable("id") int id){
        return service.queryByRuId(id);
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
