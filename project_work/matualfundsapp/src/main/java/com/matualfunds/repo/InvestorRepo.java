package com.matualfunds.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matualfunds.entities.Investor;

@Repository
public interface InvestorRepo extends JpaRepository<Investor, Integer> {

	@Query(nativeQuery = true, value = "select * from invertor_table")
	public List<Investor> getAllInv();

	// HQL
	@Query("select i from Investor i where i.name=?1")
	public List<Investor> getInvestorsByNameByQuery(String name);

//	@Query("select i from Investor i where i.name=:name")
//	public List<Investor> getInvestorsByNameByQuery(@Param("name")  String name);
//	

//	@Query("select i from Investor i where i.mobileNo=:mobileNo or i.email=:email")
//	public List<Investor>
//	getInvestorsByPhoneOrEamil(@Param("mobileNo")  String mobileNo,@Param("email")  String email);
//	

	public List<Investor> findByName(String name);

	// findByLastnameIgnoreCase
	public List<Investor> findByNameIgnoreCase(String name);

	public List<Investor> findByNameContaining(String name);

}
