package com.project.testapp.dao;

import java.util.List;

import com.project.testapp.inputDTO.EmployeeDTO;
import com.project.testapp.inputDTO.SentEmailDTO;
import com.project.testapp.inputDTO.VendorDTO;

public interface AdminDAO {

	int add(EmployeeDTO employeeDTO);

	int addvendor(VendorDTO vendorDTO);
	
	List<EmployeeDTO> getAllEmployees();
    List<VendorDTO> getAllVendors();

    int saveSentEmail(SentEmailDTO sentEmailDTO);

	List<String> getAllEmailsSentToVendors();
}
