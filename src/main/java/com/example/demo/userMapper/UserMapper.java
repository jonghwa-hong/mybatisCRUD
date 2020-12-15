package com.example.demo.userMapper;

import com.example.demo.userDomain.DeptDTO;
import com.example.demo.userDomain.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<UserDTO> selectUserList();

    public List<UserDTO> selectDetailUsers();

    public UserDTO selectUser(Integer id);

    public void deleteUser(Integer id);

    public void insertUser(UserDTO userDTO);

    public void updateUser(UserDTO userDTO);

}

