package com.travelsky.b2g.b2gservice.service;


import com.travelsky.b2g.b2gcommon.response.CommonResponse;
import com.travelsky.b2g.b2gdomain.dao.UserDao;
import com.travelsky.b2g.b2gdomain.po.User;
import com.travelsky.b2g.b2ginterface.dto.UserDto;
import com.travelsky.b2g.b2ginterface.dto.UserPageDto;
import com.travelsky.b2g.b2ginterface.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("userService")
public class UserServiceImpl implements UserService {
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	public UserDao userdao;

	@Override
	public void createUser(UserDto userdto) {

		User user = new User();
		user.setName(userdto.getName());
		user.setUserState(userdto.getState().equals("1")? User.StateEnum.NORMAL : User.StateEnum.DELETE);
		userdao.save(user);

	}

	@Override
	public UserDto retrieveUser(Long id ) {
		User user =  userdao.findOne(id);
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(user,dto);
		dto.setId(String.valueOf(user.getId()));
		dto.setState(user.getUserState().equals(User.StateEnum.DELETE)? "0":"1");
		return dto;
	}

	@Transactional
	@Override
	public void updateUser(UserDto userdto) {
		User u  = userdao.findOne(Long.parseLong(userdto.getId()));
		u.setName(userdto.getName());
	}

	@Transactional
	@Override
	public void updateUser1(UserDto userdto) {
		userdao.updName(userdto.getName(),Long.parseLong(userdto.getId()));
	}

	@Transactional
	@Override
	public void updateUser2(UserDto userdto) {
		User user = new User();
		user.setId(Long.parseLong(userdto.getId()));
		user.setName(userdto.getName());
		user.setUserState(userdto.getState().equals("1")? User.StateEnum.NORMAL : User.StateEnum.DELETE);
		userdao.save(user);
	}



	@Override
	public void deleteUser(UserDto userdto) {
		userdao.delete(Long.parseLong(userdto.getId()));
	}

	@Override
	public List<User> listUser(final UserDto userdto) {

		return userdao.findFirst3ByName(userdto.getName());

		/**
		Specification<User> spec = new Specification<User>() {

			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> list = new ArrayList<Predicate>();
				if( userdto!=null ) {
					if (userdto.getName() != null && userdto.getName().trim().length() > 0) {
						list.add(cb.equal(root.get("name").as(String.class), userdto.getName()));
					}
					if (userdto.getState() != null) {
						list.add(cb.equal(root.get("userState").as(String.class), userdto.getState()));
					}
				}
				Predicate[] p = new Predicate[list.size()];
				return query.where(list.toArray(p)).getRestriction();
			}
		};


		return userdao.findAll(spec);
		 */
	}

	@Override
	public Page<User> listPageUser(final UserPageDto userPageDto) {

		Pageable pageable = new PageRequest(userPageDto.getPage(), userPageDto.getSize());
		if( userPageDto.getProperties()!= null){
			pageable = new PageRequest(userPageDto.getPage(), userPageDto.getSize(), new Sort(Sort.Direction.fromStringOrNull(userPageDto.getDirection()),userPageDto.getProperties()));
		}

		Specification<User> spec = new Specification<User>() {

			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> list = new ArrayList<Predicate>();
				if( userPageDto!=null ) {
					if (userPageDto.getName() != null && userPageDto.getName().trim().length() > 0) {
						list.add(cb.equal(root.get("name").as(String.class), userPageDto.getName()));
					}
					if (userPageDto.getState() != null) {
						list.add(cb.equal(root.get("userState").as(String.class), userPageDto.getState()));
					}
				}
				Predicate[] p = new Predicate[list.size()];
				return query.where(list.toArray(p)).getRestriction();
			}
		};

		return userdao.findAll(spec, pageable);


	}

}
