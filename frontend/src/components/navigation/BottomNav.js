import React from 'react';
import { Nav } from 'react-bootstrap';
import { Link, useLocation } from 'react-router-dom';
import { Home, Search, Calendar, User } from 'lucide-react';
import './BottomNav.css';

const BottomNav = () => {
  const location = useLocation();

  return (
    <Nav className="bottom-nav">
      <Nav.Item>
        <Nav.Link as={Link} to="/" className={location.pathname === '/' ? 'active' : ''}>
          <Home />
          <span>Home</span>
        </Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link as={Link} to="/clubs" className={location.pathname === '/runclubs' ? 'active' : ''}>
          <Search />
          <span>Run Clubs</span>
        </Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link as={Link} to="/events" className={location.pathname === '/events' ? 'active' : ''}>
          <Calendar />
          <span>Events</span>
        </Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link as={Link} to="/profile" className={location.pathname === '/profile' ? 'active' : ''}>
          <User />
          <span>Profile</span>
        </Nav.Link>
      </Nav.Item>
    </Nav>
  );
};

export default BottomNav;