import React, { useState, useEffect } from 'react';
import axios from 'axios';

const VendorList = () => {
  const [vendors, setVendors] = useState([]);
  const [errorMessage, setErrorMessage] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8080/admin/list-vendors')
      .then(response => setVendors(response.data))
      .catch(error => {
        console.error('Error fetching vendors:', error);
        setErrorMessage('Failed to fetch vendors. Please try again.');
      });
  }, []);

  return (
    <div>
      <h2>Vendor List</h2>
      {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
      <table  border='1'>
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>UPI</th>
          </tr>
        </thead>
        <tbody>
          {vendors.map(vendor => (
            <tr key={vendor.email}>
              <td>{vendor.name}</td>
              <td>{vendor.email}</td>
              <td>{vendor.upi}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default VendorList;
