package com.example.demo.userService;

import com.example.demo.userDomain.UserDTO;

import java.util.List;

public interface UserService {

    public List<UserDTO> getUserList();

    public UserDTO getUser(Integer id);

    public void deleteUser(Integer id);

    public void insertUser(UserDTO userDTO);

    public void updateUser(UserDTO userDTO);
}
