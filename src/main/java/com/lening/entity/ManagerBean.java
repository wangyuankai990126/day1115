package com.lening.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="tb_manager")
public class ManagerBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

}
