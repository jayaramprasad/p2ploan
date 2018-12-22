/**
 * 
 */
package com.p2ploan.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.p2ploan.app.entites.PPLoan;
import com.p2ploan.app.model.P2PExceptionResponse;
import com.p2ploan.app.model.P2PRequest;
import com.p2ploan.app.model.P2PResponse;
import com.p2ploan.app.repository.P2PLoanRepository;

/**
 * @author jayaram
 *
 */
@RestController
@RequestMapping("/loan/v1/p2ploan")
public class P2PController {
	
	public static final Logger LOG=LogManager.getLogger(P2PController.class);
	
	@Autowired
	P2PLoanRepository repository;
	
	@RequestMapping(method=RequestMethod.OPTIONS)
	public ResponseEntity<?> optionsCall() {
		
		return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Origin", "POST,PUT,DELETE,GET").build();
		
	}

	@PostMapping
	public ResponseEntity<?> postLoanRequest(@RequestBody P2PRequest request) {
		
		LOG.info("Entered to POST method :" + request.toString());
		
		String uniqueRequestId=UUID.randomUUID().toString();
		
		if(null == request.getRequesterType() || null == request.getBorrowerMobile() || null == request.getLenderMobile()
				|| request.getRequestAmount() <= 0 || null == request.getRequesterType() || request.getRequestInterest()<=0){
		P2PExceptionResponse errorResponse = new P2PExceptionResponse();
		errorResponse.setErrorCode("200001");
		errorResponse.setErrorMessage("unable to process request");
		errorResponse.setErrorDescription("Mandatory field missing.");
		return ResponseEntity.badRequest().header("Access-Control-Allow-Origin", "*").body(errorResponse);
		}else if(request.getApprovedAmount() >0 || request.getApprovedInterest() >0  || request.getApprovedTenure() >0) {
			P2PExceptionResponse errorResponse = new P2PExceptionResponse();
			errorResponse.setErrorCode("200004");
			errorResponse.setErrorMessage("unable to process request");
			errorResponse.setErrorDescription("Approved amounts can not be processed");
			return ResponseEntity.badRequest().header("Access-Control-Allow-Origin", "*").body(errorResponse);
		}else if(request.getBorrowerMobile().equalsIgnoreCase(request.getLenderMobile())) {
			P2PExceptionResponse errorResponse = new P2PExceptionResponse();
			errorResponse.setErrorCode("200004");
			errorResponse.setErrorMessage("unable to process request");
			errorResponse.setErrorDescription("Borrower and Lender mobile numbers can not be same");
			return ResponseEntity.badRequest().header("Access-Control-Allow-Origin", "*").body(errorResponse);
		}
		
		
		PPLoan loan = new PPLoan();
		loan.setRequestId(uniqueRequestId);
		loan.setRequestAmount(request.getRequestAmount());
		loan.setRequesterType(request.getRequesterType());
		loan.setRequestInterest(request.getRequestInterest());
		loan.setRequestTenure(request.getRequestTenure());
		loan.setComment(request.getComment());
		if(null != request.getRequestStatus())
			loan.setRequestStatus(request.getRequestStatus());
		else
			loan.setRequestStatus("REQUESTED");
		loan.setCreatedBy("P2PLoan SYS");
		loan.setCreatedDate(new Date());
		loan.setBorrowerMobile(request.getBorrowerMobile());
		loan.setLenderMobile(request.getLenderMobile());
		
		repository.save(loan);
		
		
		P2PResponse response = new P2PResponse();
		response.setRequestId(uniqueRequestId);
		response.setStatus("REQUESTED");
		
		return ResponseEntity.status(HttpStatus.CREATED).header("Access-Control-Allow-Origin", "*").body(response);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getLoanRequest(@PathVariable("id") String requestId){
		
		PPLoan loan = repository.findAllByrequestId(requestId);
		return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(loan);
		
	}
	
	@GetMapping
	public ResponseEntity<?> getLoanRequestList(@RequestParam("type") String type,
			@RequestParam("mobile") String mobileNumber){
		List<PPLoan> loan = new ArrayList<PPLoan>();
		
		if("BORROWER".equalsIgnoreCase(type)) {
			loan = repository.findAllByborrowerMobile(mobileNumber); 
		}else if ("LENDER".equalsIgnoreCase(type)){
			loan = repository.findAllBylenderMobile(mobileNumber);
		}else {
			P2PExceptionResponse errorResponse = new P2PExceptionResponse();
			errorResponse.setErrorCode("200006");
			errorResponse.setErrorMessage("unable to process request");
			errorResponse.setErrorDescription("Invalid type value");
			return ResponseEntity.badRequest().header("Access-Control-Allow-Origin", "*").body(errorResponse);
		}
		if(loan.size()>0)
		return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(loan);
		else
		return ResponseEntity.noContent().header("Access-Control-Allow-Origin", "*").build();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> putLoanRequest(@RequestBody P2PRequest request, @PathVariable("id") String requestId) {
		
		boolean changeFlag =false;
		
		LOG.info("Entered to POST method :" + request.toString());
		
		if(null == request.getRequestId()) {
		PPLoan loan = repository.findAllByrequestId(requestId);
		
		if(null != request.getRequesterType() && !request.getRequesterType().equalsIgnoreCase(loan.getRequesterType())) {
			loan.setRequesterType(request.getRequesterType());
			changeFlag=true;
		}
		if(request.getRequestAmount() != loan.getRequestAmount()) {
			loan.setRequestAmount(request.getRequestAmount());
			changeFlag=true;
		}
		if(request.getRequestTenure() != loan.getRequestTenure()) {
			loan.setRequestTenure(request.getRequestTenure());
			changeFlag=true;
		}
		if(request.getRequestInterest() != loan.getRequestInterest()) {
			loan.setRequestInterest(request.getRequestInterest());
			changeFlag=true;
		}
		if(null != request.getRequestStatus() && !request.getRequestStatus() .equalsIgnoreCase( loan.getRequestStatus())) {
			loan.setRequestStatus(request.getRequestStatus());
			changeFlag=true;
		}
		if(request.getApprovedAmount() != loan.getApprovedAmount()) {
			loan.setApprovedAmount(request.getApprovedAmount());
			changeFlag=true;
		}
		if(request.getApprovedTenure() != loan.getApprovedTenure()) {
			loan.setApprovedTenure(request.getApprovedTenure());
			changeFlag=true;
		}
		if(request.getApprovedInterest() != loan.getApprovedInterest()) {
			loan.setApprovedInterest(request.getApprovedInterest());
			changeFlag=true;
		}
		if(null != request.getComment() && !request.getComment() .equalsIgnoreCase( loan.getComment())) {
			loan.setComment(request.getComment());
			changeFlag=true;
		}
		if((null!= request.getBorrowerMobile() && request.getBorrowerMobile() != loan.getBorrowerMobile()) ||
			( null != request.getLenderMobile() && request.getLenderMobile() != loan.getLenderMobile())) {
			P2PExceptionResponse errorResponse = new P2PExceptionResponse();
			errorResponse.setErrorCode("200002");
			errorResponse.setErrorMessage("unable to process request");
			errorResponse.setErrorDescription("Mobile Numbers can not be updated");
			return ResponseEntity.badRequest().header("Access-Control-Allow-Origin", "*").body(errorResponse);
		}
			
		if(changeFlag) {
		repository.save(loan);
		}else {
			P2PExceptionResponse errorResponse = new P2PExceptionResponse();
			errorResponse.setErrorCode("200005");
			errorResponse.setErrorMessage("unable to process request");
			errorResponse.setErrorDescription("No Updates found");
			return ResponseEntity.badRequest().header("Access-Control-Allow-Origin", "*").body(errorResponse);
		}
		
		return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").build();
		}else {
			
			P2PExceptionResponse errorResponse = new P2PExceptionResponse();
			errorResponse.setErrorCode("200003");
			errorResponse.setErrorMessage("unable to process request");
			errorResponse.setErrorDescription("Request ID can not be updated");
			return ResponseEntity.badRequest().header("Access-Control-Allow-Origin", "*").body(errorResponse);
		}
		
		
		
		
		
	}
	
}
