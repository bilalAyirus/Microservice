package com.crudapp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crudapp.springboot.model.UserMst;

@Repository
@Transactional
public interface UserMstRepository extends JpaRepository<UserMst, Long> {

	@Query("select u from UserMst u where u.id = :id")
	public UserMst getUserbyId(@Param("id") long id);
}
