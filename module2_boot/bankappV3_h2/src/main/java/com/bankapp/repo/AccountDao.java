package com.bankapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.Account;

//ie it u need not to define any method in dao layer ( also called repo layer)
//just need to declare it
@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {
	
}
