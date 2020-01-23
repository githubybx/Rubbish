package com.rubbish.rubbishcustomer.RubbishCustomController;

import com.rubbish.rubbishservice.Entity.Rubbish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RubbishControler {
    //String URL = "http://127.0.0.1:7001";
    String URL = "http://Rubbish-Server";
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/custom/get/all")
    public List<Rubbish> getAll(){
        List forObject = restTemplate.getForObject(URL + "/get/all", List.class);
        return forObject;
    }
    @RequestMapping("/custom/get/{id}")
    public Rubbish getById(@PathVariable("id")int id){
        return restTemplate.getForObject(URL + "/get/" + id, Rubbish.class);
    }
    @RequestMapping("/custom/delete/{id}")
    public void deleteById(@PathVariable("id")int id){
        restTemplate.getForObject(URL + "/delete/" + id, void.class);
    }
    @RequestMapping("/custom/post/add")
    public Rubbish save(Rubbish rubbish){
        System.out.println(rubbish.getName() + " " + rubbish.getSource());
        Rubbish rubbish1 = restTemplate.postForObject(URL + "/post/add", rubbish, Rubbish.class);
        return rubbish1;
    }
    @RequestMapping("/custom/put")
    public Rubbish updateById(Rubbish rubbish){
        System.out.println(rubbish.getName() + " " + rubbish.getSource());
        return restTemplate.postForObject(URL + "/put",rubbish, Rubbish.class);
    }
    @RequestMapping("/custom/get/discovery")
    public Object getDiscovery(){
        return restTemplate.getForObject(URL + "/get/discovery",Object.class);
    }
}
