import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ViewEmails = () => {
  const [emails, setEmails] = useState([]);
  const [errorMessage, setErrorMessage] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8080/admin/view-all-emails-sent-to-vendors')
      .then(response => setEmails(response.data))
      .catch(error => {
        console.error('Error fetching emails:', error);
        setErrorMessage('Failed to fetch emails. Please try again.');
      });
  }, []);

  return (
    <div>
      <h2>View Emails Sent to Vendors</h2>
      {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
      <ul>
        {emails.map((email, index) => (
          <li key={index}>{email}</li>
        ))}
      </ul>
    </div>
  );
};

export default ViewEmails;
