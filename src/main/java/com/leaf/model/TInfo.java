package com.leaf.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * t_info
 * @author 
 */
@Data
//@NoArgsConstructor
public class TInfo implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String sex;

    private String tel;

}