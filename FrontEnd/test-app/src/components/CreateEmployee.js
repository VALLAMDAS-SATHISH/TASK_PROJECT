import React, { useState } from 'react';
import axios from 'axios';

const CreateEmployee = () => {
    const [name, setName] = useState('');
    const [designation, setDesignation] = useState('');
    const [ctc, setCtc] = useState('');
    const [email, setEmail] = useState('');
    const [errorMessage, setErrorMessage] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/admin/employees', {
                name,
                designation,
                ctc,
                email
            });
            alert('Employee created successfully.');
            setName('');
            setDesignation('');
            setCtc('');
            setEmail('');
        } catch (error) {
            setErrorMessage('Error creating employee.');
            console.error('Error creating employee:', error);
        }
    };

    return (
        <div>
            <h2>Create Employee</h2>
            {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
            <form onSubmit={handleSubmit}>
                <table>
                    <tbody>
                        <tr>
                            <td><label>Name:</label></td>
                            <td><input type="text" value={name} onChange={(e) => setName(e.target.value)} required /></td>
                        </tr>
                        <tr>
                            <td><label>Email:</label></td>
                            <td><input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required /></td>
                        </tr>
                        <tr>
                            <td><label>Designation:</label></td>
                            <td><input type="text" value={designation} onChange={(e) => setDesignation(e.target.value)} required /></td>
                        </tr>
                        <tr>
                            <td><label>CTC:</label></td>
                            <td><input type="number" value={ctc} onChange={(e) => setCtc(e.target.value)} required /></td>
                        </tr>
                    </tbody>
                </table>
                <button type="submit">Create</button>
            </form>
        </div>
    );
};

export default CreateEmployee;
