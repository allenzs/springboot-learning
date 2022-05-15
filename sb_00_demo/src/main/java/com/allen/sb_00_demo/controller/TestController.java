package com.allen.sb_00_demo.controller;

import com.allen.sb_00_demo.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("/rest")
@RestController
public class TestController {


    @GetMapping("/okhttp/get")
    public String okGet() {
        return "hello okhttp";
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody User user) {
        return "save: " + user;
    }

    @RequestMapping(value = "/getById/{userId}", method = RequestMethod.POST)
    public String delete(@PathVariable Integer userId) {
        System.out.println("delete user:" + userId);
        return "delte user:" + userId;
    }

    /**
     * http://localhost:8888/rest/param?name=allen&age=18&sex=male
     * 使用javaApi的post请求中的 Entity请求不到，需要用 @RequestBody
     *
     * 解决：使用 okHttp 的 post请求
     */
    @RequestMapping("/param")
    public String warn(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam(name = "sex", required = false) String sex
    ) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        map.put("sex", sex);
        JsonMapper jsonMapper = new JsonMapper();
        String jsonStr = jsonMapper.writeValueAsString(map);
        System.out.println(jsonStr);
        return jsonStr;
    }

    @PostMapping("/post")
    public String getParam(@RequestBody String body, @RequestHeader HttpHeaders header) {
        System.out.println(body);
        System.out.println(header);
        return body;
    }

    @PostMapping("/post/user")
    public String getUser(@RequestBody User user) {
        System.out.println(user);
        return user.toString();
    }

    @PostMapping("/post/paramobtain")
    public String getParams(HttpServletResponse response,
                            @RequestParam("name") String name,
                            @RequestParam("age") String age,
                            @RequestParam("sex") String sex) throws IOException {

//        response.setContentType("Content-Type:text/csv");
//        response.setHeader("Content-disposition", "attachment;filename=" + exportName);
//        response.setHeader("Cache-Control", "must-revalidate,post-check=0,pre-check=0");
//        response.setHeader("Expires", "0");
//        response.setHeader("Pragma", "public");

        response.setContentType("Content-Type:application/json");
        ServletOutputStream outputStream = response.getOutputStream();
        String s = outputStream.toString();
        System.out.println(s);

        System.out.println(name + "_" + age + "_" + sex);
        return name + "_" + age + "_" + sex;
    }
}
