package com.project.testapp.controller;

import java.util.List;

import com.project.testapp.inputDTO.EmployeeDTO;
import com.project.testapp.inputDTO.VendorDTO;
import com.project.testapp.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin") 
public class AdminController {
 
	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/employees")
	public int createEmployee(@RequestBody  EmployeeDTO employeeDTO ) {
	return adminService.createEmployee(employeeDTO);
	
	
	}
	
	@PostMapping("/vendor")
	public int createVendor(@RequestBody VendorDTO vendorDTO) {
		return adminService.createVendor(vendorDTO);
		
	}
	@PostMapping("/send-email-to-vendors")
    public ResponseEntity<Integer> sendEmailToVendors(@RequestBody List<VendorDTO> vendors) {
        int successfulEmails = adminService.sendEmailToVendors(vendors);
        return ResponseEntity.ok(successfulEmails);
    }

	@GetMapping("/view-all-emails-sent-to-vendors")
	public ResponseEntity<List<String>> viewAllEmailsSentToVendors() {
	    List<String> sentEmailsToVendors = adminService.getAllEmailsSentToVendors();
	    return ResponseEntity.ok(sentEmailsToVendors);
	}

	@GetMapping("/list-employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = adminService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
	
	  @GetMapping("/list-vendors")
	    public ResponseEntity<List<VendorDTO>> getAllVendors() {
	        List<VendorDTO> vendors = adminService.getAllVendors();
	        return new ResponseEntity<>(vendors, HttpStatus.OK);
	    }
}
