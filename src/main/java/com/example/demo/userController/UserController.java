package com.example.demo.userController;

import com.example.demo.userDomain.UserDTO;
import com.example.demo.userService.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/selectUser")
    @ResponseBody
    public String selectAllEmployee(Model model) {
        List<UserDTO> employeeList = userService.getUserList();
        log.info("******************* SELECT ALL USER *******************");
        employeeList.forEach(c -> log.info(c.toString()));
        return "모든 사원 조회";
    }
    @GetMapping("/selectDetailUser")
    @ResponseBody
    public String selectAllDetailEmployee(Model model) {
        List<UserDTO> employeeList = userService.getUserDetailList();
        log.info("******************* SELECT ALL Detail USER *******************");
        employeeList.forEach(c -> log.info(c.toString()));
        return "모든 사원 조회";
    }

    @GetMapping("/selectUser/{id}")
    @ResponseBody
    public String selectEmployee(@PathVariable Integer id) {
        UserDTO userDTO = userService.getUser(id);
        log.info("******************* SELECT USER *******************");
        log.info(userDTO.toString());
        return "사원 조회";
    }

    @GetMapping("/deleteUser/{id}")
    @ResponseBody
    public String deleteEmployee(@PathVariable Integer id) {
        userService.deleteUser(id);
        log.info("******************* DELETE USER *******************");
        return "사원 삭제";
    }

    @GetMapping("/insertUser")
    public String insertEmployeeForm(Model model) {
        log.info("******************* INSERT FORM USER *******************");
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "insert";
    }

    @PostMapping("/insertUser")
    @ResponseBody
    public String insertEmployee(@ModelAttribute UserDTO userDTO) {
        log.info("******************* INSERT USER *******************");
        log.info(userDTO.toString());
        userService.insertUser(userDTO);
        return "사원이 등록되었습니다";
    }

    @GetMapping("/updateUser/{id}")
    public String updateEmployeeForm(@PathVariable Integer id, Model model) {
        log.info("******************* UPDATE FORM USER *******************");
        UserDTO employee = userService.getUser(id);
        model.addAttribute("user", employee);
        return "update";
    }

    @PostMapping("/updateUser")
    @ResponseBody
    public String updateEmployee(@ModelAttribute UserDTO userDTO) {
        log.info("******************* UPDATE USER *******************");
        userService.updateUser(userDTO);
        return "사원 수정 완료";
    }

}
