package com.tangj.springboot.mapper;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.tangj.springboot.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

	User findByUserNameLike(String userName);

	User findByUserNameOrEmail(String userName, String email);

	Page<User> findByUserName(String userName, Pageable pageable);

	List<User> findByUserName(String userName, Sort sort);
	
	
	/**
	 * 1.自定义的SQL,在SQL的查询方法上面使用@Query注解
	 * 2.如涉及到删除和修改在需要加上@Modifying
	 * 3.timeout 查询超时
	 */
	@Transactional(timeout = 10)	
	@Modifying
	@Query("delete from User where id = ?1")
	void deleteByUserId(Long id);

}