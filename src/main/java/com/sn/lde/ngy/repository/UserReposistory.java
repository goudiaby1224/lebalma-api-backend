package com.sn.lde.ngy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sn.lde.ngy.model.User;

public interface UserReposistory extends JpaRepository<User, Long> {

	public abstract User getUserByLogin(String login);
}
