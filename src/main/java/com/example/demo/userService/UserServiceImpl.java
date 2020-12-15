package com.example.demo.userService;

import com.example.demo.userDomain.DeptDTO;
import com.example.demo.userDomain.UserDTO;
import com.example.demo.userMapper.DeptMapper;
import com.example.demo.userMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final DeptMapper deptMapper;

    public UserServiceImpl(UserMapper userMapper, DeptMapper deptMapper) {
        this.userMapper = userMapper;
        this.deptMapper = deptMapper;
    }

    @Override
    public List<UserDTO> getUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public List<UserDTO> getUserDetailList() {
        return userMapper.selectDetailUsers();
    }

    @Override
    public UserDTO getUser(Integer id) {
        return userMapper.selectUser(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void insertUser(UserDTO userDTO) {
        userMapper.insertUser(userDTO);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        userMapper.updateUser(userDTO);
    }

    @Override
    public DeptDTO getUserByDept(Integer deptno) {
        return deptMapper.selectUserByDeptno(deptno);
    }

    @Override
    public List<DeptDTO> getDeptList() {
        return deptMapper.selectDeptList();
    }
}
