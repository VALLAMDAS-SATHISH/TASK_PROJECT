package com.project.testapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.project.testapp.dao.AdminDAO;
import com.project.testapp.inputDTO.EmployeeDTO;
import com.project.testapp.inputDTO.SentEmailDTO;
import com.project.testapp.inputDTO.VendorDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
//import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int add(EmployeeDTO employeeDTO) {
		String query = "INSERT INTO employees (name, designation, ctc, email) VALUES (?, ?, ?, ?)";
		Object[] params = { employeeDTO.getName(), employeeDTO.getDesignation(), employeeDTO.getCtc(),
				employeeDTO.getEmail() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.DOUBLE, Types.VARCHAR };

		try {
			return jdbcTemplate.update(query, params);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;

		}
	}

	@Override
	public int addvendor(VendorDTO vendorDTO) {
		String query = "INSERT INTO vendor (name,email,upi) VALUES (?, ?, ?)";

		Object[] params = { vendorDTO.getName(), vendorDTO.getEmail(), vendorDTO.getUpi() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		try {
			return jdbcTemplate.update(query, params);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;

		}

	}


	@Override
	public int saveSentEmail(SentEmailDTO sentEmailDTO) {
		String query = "INSERT INTO sent_emails (recipient_email, email_content) VALUES (?, ?)";
		Object[] params = {
				sentEmailDTO.getRecepientEmail(),
				sentEmailDTO.getEmailContent()
		};
		try {
			return jdbcTemplate.update(query, params);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;

		}
	}

	
	@Override
	public List<String> getAllEmailsSentToVendors() {
	    String sql = "SELECT email_content FROM sent_emails";
	    try {
	        return jdbcTemplate.query(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
	                return con.prepareStatement(sql);
	            }
	        }, new ResultSetExtractor<List<String>>() {
	            @Override
	            public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
	                List<String> emailContents = new ArrayList<>();
	                while (rs.next()) {
	                    emailContents.add(rs.getString("email_content"));
	                }
	                return emailContents;
	            }
	        });
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyList(); // Return an empty list in case of an exception
	    }
	}


	
	
	
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		try {
			return this.jdbcTemplate.query(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					return con.prepareStatement("SELECT * FROM employees");
				}
			}, new ResultSetExtractor<List<EmployeeDTO>>() {
				@Override
				public List<EmployeeDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<EmployeeDTO> employees = new ArrayList<>();
					while (rs.next()) {
						EmployeeDTO employee = new EmployeeDTO();

						employee.setName(rs.getString("name"));
						employee.setDesignation(rs.getString("designation"));
						employee.setCtc(rs.getDouble("ctc"));
						employee.setEmail(rs.getString("email"));
						employees.add(employee);
					}
					return employees;

				}

			});
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			// Handle exception
			return null;
		}

	}

	@Override
	public List<VendorDTO> getAllVendors() {
		try {
			return this.jdbcTemplate.query(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					return con.prepareStatement("SELECT * FROM vendor");
				}
			}, new ResultSetExtractor<List<VendorDTO>>() {
				@Override
				public List<VendorDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<VendorDTO> vendors = new ArrayList<>();
					while (rs.next()) {
						VendorDTO vendor = new VendorDTO();

						vendor.setName(rs.getString("name"));
						vendor.setEmail(rs.getString("email"));
						vendor.setUpi(rs.getString("upi"));
						vendors.add(vendor);
					}
					return vendors;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			// Handle exception
			return null;
		}

	}
}
