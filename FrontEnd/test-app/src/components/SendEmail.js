import React, { useState, useEffect } from 'react';
import axios from 'axios';

const SendEmail = () => {
  const [vendors, setVendors] = useState([]);
  const [selectedVendors, setSelectedVendors] = useState([]);
  const [errorMessage, setErrorMessage] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8080/admin/list-vendors')
      .then(response => setVendors(response.data))
      .catch(error => {
        console.error('Error fetching vendors:', error);
        setErrorMessage('Failed to fetch vendors. Please try again.');
      });
  }, []);

  const handleCheckboxChange = (email) => {
    setSelectedVendors(prevSelected => {
      if (prevSelected.includes(email)) {
        return prevSelected.filter(v => v !== email);
      } else {
        return [...prevSelected, email];
      }
    });
  };

  const handleSubmit = () => {
    const selectedVendorObjects = vendors.filter(vendor => selectedVendors.includes(vendor.email));
    axios.post('http://localhost:8080/admin/send-email-to-vendors', selectedVendorObjects)
      .then(response => {
        console.log(response);
        setSelectedVendors([]);
      })
      .catch(error => console.error('Error sending emails:', error));
  };

  return (
    <div>
      <h2>Send Emails to Vendors</h2>
      {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
      <ul>
        {vendors.map(vendor => (
          <li key={vendor.email}>
            <input
              type="checkbox"
              checked={selectedVendors.includes(vendor.email)}
              onChange={() => handleCheckboxChange(vendor.email)}
            />
            {vendor.name} - {vendor.email}
          </li>
        ))}
      </ul>
      <button onClick={handleSubmit}>Send Emails</button>
    </div>
  );
};

export default SendEmail;
