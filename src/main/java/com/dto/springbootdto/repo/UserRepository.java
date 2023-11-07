package com.dto.springbootdto.repo;

import com.dto.springbootdto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{

}
