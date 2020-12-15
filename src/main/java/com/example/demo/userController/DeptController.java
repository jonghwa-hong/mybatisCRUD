package com.example.demo.userController;

import com.example.demo.userDomain.DeptDTO;
import com.example.demo.userService.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class DeptController {

    private final UserService userService;

    public DeptController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/selectDept")
    @ResponseBody
    public String selectDept() {

        List<DeptDTO> deptDTOList = userService.getDeptList();
        deptDTOList.forEach(c -> log.info(c.toString()));

        return "부서 조회";
    }

    @GetMapping("/selectUserByDept/{deptno}")
    @ResponseBody
    public String selectUserByDept(@PathVariable Integer deptno) {

        DeptDTO userByDept = userService.getUserByDept(deptno);
        userByDept.getEmployees().forEach(c -> log.info(c.toString()));

        return "부서를 통한 직원 조회";
    }
}
