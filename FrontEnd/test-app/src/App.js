import React from 'react';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import EmployeeList from './components/EmployeeList';
import VendorList from './components/VendorList';
import CreateEmployee from './components/CreateEmployee';
import CreateVendor from './components/CreateVendor';
import SendEmail from './components/SendEmail';
import ViewEmails from './components/ViewEmails'; // Import the ViewEmails component

const App = () => {
  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li><Link to="/employees">Employees</Link></li>
            <li><Link to="/vendors">Vendors</Link></li>
            <li><Link to="/create-employee">Create Employee</Link></li>
            <li><Link to="/create-vendor">Create Vendor</Link></li>
            <li><Link to="/send-email">Send Email</Link></li>
            <li><Link to="/view-emails">View Emails</Link></li> {/* Add a link for View Emails */}
          </ul>
        </nav>
        <Routes>
          <Route path="/employees" element={<EmployeeList />} />
          <Route path="/vendors" element={<VendorList />} />
          <Route path="/create-employee" element={<CreateEmployee />} />
          <Route path="/create-vendor" element={<CreateVendor />} />
          <Route path="/send-email" element={<SendEmail />} />
          <Route path="/view-emails" element={<ViewEmails />} /> {/* Add a route for View Emails */}
        </Routes>
      </div>
    </Router>
  );
};

export default App;
