package com.travelsky.b2g.b2ginterface.interfaces;


import com.travelsky.b2g.b2gdomain.po.User;
import com.travelsky.b2g.b2ginterface.dto.UserDto;
import com.travelsky.b2g.b2ginterface.dto.UserPageDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    void createUser(UserDto userdto );
    UserDto retrieveUser(Long id );
    void updateUser(UserDto userdto );
    void deleteUser(UserDto userdto );
    List<User> listUser(UserDto userdto);
    Page<User> listPageUser( UserPageDto userPageDto);



    void updateUser1(UserDto userdto );
    void updateUser2(UserDto userdto );



}
