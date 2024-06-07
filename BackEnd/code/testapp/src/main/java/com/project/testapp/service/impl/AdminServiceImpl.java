package com.project.testapp.service.impl;

import java.util.List;

import com.project.testapp.dao.AdminDAO;
import com.project.testapp.inputDTO.EmployeeDTO;
import com.project.testapp.inputDTO.SentEmailDTO;
import com.project.testapp.inputDTO.VendorDTO;
import com.project.testapp.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO admindao;

	@Override
	public int createEmployee(EmployeeDTO employeeDTO) {
		return admindao.add(employeeDTO);

	}

	@Override
	public int createVendor(VendorDTO vendorDTO) {

		return admindao.addvendor(vendorDTO);
	}

	@Override
	public int sendEmailToVendors(List<VendorDTO> vendors) {
		int successfulEmails = 0;
		for (VendorDTO vendor : vendors) {
			String emailContent = "Sending payments to vendor " + vendor.getName() + " at upi " + vendor.getUpi();
			// Mock email sending by printing email content
			System.out.println("Sending email: " + emailContent);

			// Save sent email to database
			int rowsAffected = admindao.saveSentEmail(new SentEmailDTO(vendor.getEmail(), emailContent));
			if (rowsAffected != -1) {
				successfulEmails++;
			}
		}
		return successfulEmails;
	}

	@Override
	public List<String> getAllEmailsSentToVendors() {
		return admindao.getAllEmailsSentToVendors();
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeDTO> employees = admindao.getAllEmployees();

		return employees;
	}

	@Override
	public List<VendorDTO> getAllVendors() {
		List<VendorDTO> vendors = admindao.getAllVendors();

		return vendors;
	}

}
