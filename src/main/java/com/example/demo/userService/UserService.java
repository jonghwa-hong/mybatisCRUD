package com.example.demo.userService;

import com.example.demo.userDomain.DeptDTO;
import com.example.demo.userDomain.UserDTO;

import java.util.List;

public interface UserService {

    public List<UserDTO> getUserList();

    public List<UserDTO> getUserDetailList();

    public UserDTO getUser(Integer id);

    public void deleteUser(Integer id);

    public void insertUser(UserDTO userDTO);

    public void updateUser(UserDTO userDTO);

    public List<DeptDTO> getDeptList();

    public DeptDTO getUserByDept(Integer deptno);
}
