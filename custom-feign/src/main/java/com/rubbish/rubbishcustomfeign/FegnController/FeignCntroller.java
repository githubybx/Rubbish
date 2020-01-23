package com.rubbish.rubbishcustomfeign.FegnController;

import com.rubbish.rubbishcustomfeign.Service.FeignService;
import com.rubbish.rubbishservice.Entity.Rubbish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class FeignCntroller {
    @Autowired
    FeignService service;
    @RequestMapping("/custom/get/all")
    public List<Rubbish> getAll(){
        return service.getAll();
    }
    @RequestMapping("/custom/get/{id}")
    public Rubbish getById(@PathVariable("id")int id){
        return service.getById(id);
    }
    @RequestMapping("/custom/delete/{id}")
    public void deleteById(@PathVariable("id")int id){
        service.deleteById(id);
    }
    @RequestMapping("/custom/post/add")
    public Rubbish save(Rubbish rubbish){
        return service.save(rubbish);
    }
    @RequestMapping("/custom/put")
    public Rubbish updateById(Rubbish rubbish){
        return service.updateById(rubbish);
    }
    @RequestMapping("/custom/get/discovery")
    public Object getDiscovery() {
        return service.getDiscovery();
    }
}
