import React, { useState } from 'react';
import axios from 'axios';

const CreateVendor = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [upi, setUpi] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const vendor = { name, email, upi };
    try {
      const response = await axios.post('http://localhost:8080/admin/vendor', vendor);
      console.log(response);
      alert('Vendor created successfully.');
      setName('');
      setEmail('');
      setUpi('');
      setErrorMessage('');
    } catch (error) {
      console.error('Error creating vendor:', error);
      setErrorMessage('Failed to create vendor. Please try again.');
    }
  };

  return (
    <div>
      <h2>Create Vendor</h2>
      {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
      <form onSubmit={handleSubmit}>
        <table>
          <tbody>
            <tr>
              <td><label>Name:</label></td>
              <td><input type="text" placeholder="Name" value={name} onChange={e => setName(e.target.value)} required /></td>
            </tr>
            <tr>
              <td><label>Email:</label></td>
              <td><input type="email" placeholder="Email" value={email} onChange={e => setEmail(e.target.value)} required /></td>
            </tr>
            <tr>
              <td><label>UPI:</label></td>
              <td><input type="text" placeholder="UPI" value={upi} onChange={e => setUpi(e.target.value)} required /></td>
            </tr>
          </tbody>
        </table>
        <button type="submit">Create</button>
      </form>
    </div>
  );
};

export default CreateVendor;
