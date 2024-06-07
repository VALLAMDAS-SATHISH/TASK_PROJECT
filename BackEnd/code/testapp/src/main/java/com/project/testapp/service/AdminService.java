package com.project.testapp.service;

import java.util.List;

import com.project.testapp.inputDTO.EmployeeDTO;
import com.project.testapp.inputDTO.VendorDTO;

public interface AdminService {

	int createEmployee(EmployeeDTO employeeDTO);

	int createVendor(VendorDTO vendorDTO);

	int sendEmailToVendors(List<VendorDTO> vendors);
	
	List<String> getAllEmailsSentToVendors();

	List<EmployeeDTO> getAllEmployees();

	List<VendorDTO> getAllVendors();

}
