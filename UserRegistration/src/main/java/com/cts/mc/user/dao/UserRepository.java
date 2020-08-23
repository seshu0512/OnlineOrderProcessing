package com.cts.mc.user.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.mc.user.model.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long>{

}
