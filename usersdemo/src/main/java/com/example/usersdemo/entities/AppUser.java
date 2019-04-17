package com.example.usersdemo.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class AppUser {


   @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public  AppUser(Long id){
     this.id=id;
    }

    @Column(unique = true)
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String password;
    private  boolean actived;

    @OneToMany(mappedBy ="appUser")
    private Collection<Canal> canals;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>();


}