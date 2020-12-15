package com.example.demo.userDomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class DeptDTO {

    private int deptno;
    private String dname;
    private String loc;
    private List<UserDTO> employees;
}
