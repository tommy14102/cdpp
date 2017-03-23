package com.travelsky.b2g.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.travelsky.b2g.dao.UserDao;
import com.travelsky.b2g.dto.Person;
import com.travelsky.b2g.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    @Autowired
    public UserDao userdao ;

    @RequestMapping(value="/save")
    public String save(@RequestParam(value="name", defaultValue="World") String name) {


        User person = new User();
        person.setName(name+" nihao  a");
        userdao.save(person);

        return "sucess";
    }

    @RequestMapping(value="/hello")
    public Person greeting(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("hello");

        User s = userdao.findByName("World");
        Person p = new Person();
        p.setId(s.getId()+"");
        p.setName(s.getName());


        return p;
    }

}
