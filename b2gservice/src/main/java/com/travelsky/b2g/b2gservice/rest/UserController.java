package com.travelsky.b2g.b2gservice.rest;

import com.travelsky.b2g.b2gcommon.response.CommonResponse;
import com.travelsky.b2g.b2gdomain.dao.UserDao;
import com.travelsky.b2g.b2gdomain.po.User;
import com.travelsky.b2g.b2ginterface.dto.UserDto;
import com.travelsky.b2g.b2ginterface.dto.UserPageDto;
import com.travelsky.b2g.b2ginterface.interfaces.UserService;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public UserDao userdao;

    @ApiOperation(value = "添加用户", httpMethod = "POST", response = CommonResponse.class, notes = "add user")
    @RequestMapping(value = "/add",method = RequestMethod.POST, consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
    public CommonResponse save(@RequestBody(required=true) UserDto userdto ) {

        userService.createUser(userdto);
        return new CommonResponse("0","success");
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    //@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/delete", method = RequestMethod.POST )
    public CommonResponse delete(@RequestParam(required=true) Long id) {

        UserDto userdto = new UserDto();
        userdto.setId(String.valueOf(id));
        userService.deleteUser(userdto);
        return new CommonResponse("0","success");
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
    public CommonResponse update(@RequestBody UserDto userdto) {
        userService.updateUser2(userdto);
        return new CommonResponse("0","success");
    }

    @ApiOperation(value = "查询用户", notes = "查询用户")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public UserDto get(@RequestParam(value = "id", defaultValue = "9") String id) {
        return userService.retrieveUser(Long.parseLong(id));
    }



    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST, consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
    public List<User> list (@RequestBody(required=false) UserDto userdto) {
        return userService.listUser(userdto);
    }


    @ApiOperation(value = "获取用户列表分页", notes = "获取用户列表分页")
    @RequestMapping(value = "/page", method = RequestMethod.POST, consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
    public Page<User> greeting(@RequestBody(required=true) UserPageDto userPageDto) {
        Page<User> list = userService.listPageUser(userPageDto);
        return list;
    }


}



