import React, { useState, useEffect } from 'react';
import axios from 'axios';

const EmployeeList = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/admin/list-employees')
      .then(response => setEmployees(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div>
      <h2>Employee List</h2>
      <table border='1'>
        <thead>
          <tr>
            <th>Name</th>
            <th>Designation</th>
            <th>Email</th>
            <th>CTC</th>
          </tr>
        </thead>
        <tbody>
          {employees.map(employee => (
            <tr key={employee.email}>
              <td>{employee.name}</td>
              <td>{employee.designation}</td>
              <td>{employee.email}</td>
              <td>{employee.ctc}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default EmployeeList;
