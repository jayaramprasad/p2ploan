/**
 * 
 */
package com.p2ploan.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.p2ploan.app.entites.PPLoan;

/**
 * @author jayaram
 *
 */
@Repository
public interface P2PLoanRepository extends CrudRepository<PPLoan, String>{

	PPLoan findAllByrequestId(String requestId);
	List<PPLoan> findAllByborrowerMobile(String borrowerMobile);
	List<PPLoan> findAllBylenderMobile(String lenderMobile);

}
