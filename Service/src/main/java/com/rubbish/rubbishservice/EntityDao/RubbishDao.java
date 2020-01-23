package com.rubbish.rubbishservice.EntityDao;

import com.rubbish.rubbishservice.Entity.Rubbish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RubbishDao extends JpaRepository<Rubbish,Integer> {
    @Query(value = "select * from rubbish",nativeQuery = true)
    public List<Rubbish> findAll();
    public Rubbish queryByRuid(int ruid);
    public void deleteByRuid(int ruid);
}
