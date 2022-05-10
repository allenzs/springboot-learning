package com.allen.sb_00_demo.controller;

import com.allen.sb_00_demo.bean.User;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody User user) {
        return "save: " + user;
    }

    @RequestMapping(value = "/getById/{userId}",method = RequestMethod.POST)
    public String delete(@PathVariable Integer userId) {
        System.out.println("delete user:" + userId);
        return "delte user:" + userId;
    }

}
