import React from 'react';
import { Navbar, Nav, Container } from 'react-bootstrap';
import { Bell, MessageCircle } from 'lucide-react';
import { Link } from 'react-router-dom';
import './AppNavbar.css';

const AppNavbar = () => {
  return (
    <Navbar className="app-navbar">
      <Container>
        <Navbar.Brand href="/">FindARun</Navbar.Brand>
        <div className="navbar-icons">
          <Bell className="navbar-icon" />
          <MessageCircle className="navbar-icon" />
        </div>
      </Container>
    </Navbar>
  );
};

export default AppNavbar;