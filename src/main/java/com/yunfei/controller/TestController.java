package com.yunfei.controller;

import com.yunfei.util.result.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/test")
public class TestController {
    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四"),
            @ApiImplicitParam(name = "email", value = "用户邮箱", defaultValue = "test@baomidou"),
            @ApiImplicitParam(name = "age", value = "用户年龄", defaultValue = "20", required = true)
    }
    )
    public RespBean addUser(String username, @RequestParam(required = true) String age) {
        return RespBean.success();
    }

    /*@GetMapping("/getUserById/{id}")
    @ApiOperation("根据id查询用户的接口")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "99", required = true)
    public User getUserById(@PathVariable Integer id) {
        User user = new User();
        user.setId(id);
        return user;
    }
    @PutMapping("/updateUserById")
    @ApiOperation("根据id更新用户的接口")
    public User updateUserById(@RequestBody User user) {
        return user;
    }*/
}
