package com.travelsky.b2g.dao;

import com.travelsky.b2g.po.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by tommy14101 on 2017/3/23.
 */
@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    public User findByName(String name);

}
