package com.rubbish.rubbishservicehystrix8001.Entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Rubbish")
@Data
public class Rubbish {
    @NotNull
    String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int ruid;
    @NotNull
    String source;
}
