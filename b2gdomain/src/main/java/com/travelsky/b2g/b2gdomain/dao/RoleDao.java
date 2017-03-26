package com.travelsky.b2g.b2gdomain.dao;

import com.travelsky.b2g.b2gdomain.po.Role;
import com.travelsky.b2g.b2gdomain.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by tommy14101 on 2017/3/23.
 */
@Transactional
public interface RoleDao extends JpaRepository<Role, Long> {
    public Role findByName(String name);

}
