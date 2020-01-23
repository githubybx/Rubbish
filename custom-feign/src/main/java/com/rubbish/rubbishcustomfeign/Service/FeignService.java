package com.rubbish.rubbishcustomfeign.Service;

import com.rubbish.rubbishcustomfeign.FallBackFactoryTest.RubbishClientFallBack;
import com.rubbish.rubbishservice.Entity.Rubbish;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "Rubbish-Server",fallbackFactory = RubbishClientFallBack.class)
public interface FeignService {
    @RequestMapping("/get/all")
    public List<Rubbish> getAll();
    @RequestMapping("/get/{id}")
    public Rubbish getById(@PathVariable("id")int id);
    @RequestMapping("/delete/{id}")
    public void deleteById(@PathVariable("id")int id);
    @RequestMapping("/post/add")
    public Rubbish save(Rubbish rubbish);
    @RequestMapping("/put")
    public Rubbish updateById(Rubbish rubbish);
    @RequestMapping("/get/discovery")
    public Object getDiscovery();
}

