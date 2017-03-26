package com.travelsky.b2g.b2gdomain.dao;

import com.travelsky.b2g.b2gdomain.po.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by tommy14101 on 2017/3/23.
 */
@Transactional
public interface UserDao extends JpaRepository<User, Long>,JpaSpecificationExecutor<User> {

    List<User> findByName(String name);
    //Page<User> findAll(Pageable pageable);
    List<User> findFirst3ByName(String name );

    //sql查询
    @Query("select u from User u where u.name = ?1")
    List<User> personNall(String name );

    //jpql
    @Query("select u from User u where u.name = :name ")
    User findByLastnameOrFirstname(@Param("name") String name);

    @Modifying
    @Query("update User u set u.name = ?1 where u.id = ?2")
    int updName(String name, Long id);


}
