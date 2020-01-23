package com.rubbish.rubbishservice.EntityDao;


import com.rubbish.rubbishservice.Entity.Rubbish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RubbishService {
    @Autowired
    RubbishDao rubbishDao;
    public List<Rubbish> selectAll(){
        return rubbishDao.findAll();
    }
    public Rubbish save(Rubbish rubbish){
        return rubbishDao.save(rubbish);
    }
    public Rubbish queryByRuId(int ruid){
       return rubbishDao.queryByRuid(ruid);
    }
    @Transactional
    public void deleteByRuid(int id){
        rubbishDao.deleteByRuid(id);
    }
}
