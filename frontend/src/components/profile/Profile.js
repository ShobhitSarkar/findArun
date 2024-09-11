import React, { useState } from 'react';
import { Container, Row, Col, Card, Form, Button } from 'react-bootstrap';
import { User, MapPin, Mail, Phone, Activity, Edit2, Check, X } from 'lucide-react';
import './Profile.css';

const Profile = () => {
  const initialUserData = {
    userId: 1,
    firstName: "Jane",
    lastName: "Runner",
    email: "jane@example.com",
    phoneNo: "123-456-7890",
    location: "New York, NY",
    sport: "Running",
    userType: "PARTICIPANT",
    userName: "janerunner",
  };

  const [userData, setUserData] = useState(initialUserData);
  const [editingField, setEditingField] = useState(null);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setUserData({ ...userData, [name]: value });
  };

  const handleEdit = (field) => {
    setEditingField(field);
  };

  const handleSave = (field) => {
    // Here you would typically send the updated data to your backend
    console.log(`Updated ${field}:`, userData[field]);
    setEditingField(null);
  };

  const handleCancel = () => {
    setUserData(initialUserData);
    setEditingField(null);
  };

  const renderEditableCard = (title, field, icon) => (
    <Card className="mb-3 attribute-card">
      <Card.Body>
        <div className="d-flex justify-content-between align-items-center">
          <div className="d-flex align-items-center">
            {icon}
            <h5 className="mb-0 ms-2">{title}</h5>
          </div>
          {editingField === field ? (
            <div>
              <Button variant="link" className="p-0 me-2" onClick={() => handleSave(field)}><Check size={20} /></Button>
              <Button variant="link" className="p-0" onClick={handleCancel}><X size={20} /></Button>
            </div>
          ) : (
            <Button variant="link" className="p-0" onClick={() => handleEdit(field)}><Edit2 size={20} /></Button>
          )}
        </div>
        {editingField === field ? (
          <Form.Control
            type="text"
            name={field}
            value={userData[field]}
            onChange={handleInputChange}
            className="mt-2"
          />
        ) : (
          <p className="mb-0 mt-2">{userData[field]}</p>
        )}
      </Card.Body>
    </Card>
  );

  return (
    <Container className="profile-container pt-5 px-4">
      <Row className="justify-content-center mb-4">
        <Col md={8}>
          <Card className="profile-card">
            <Card.Body className="text-center">
              <div className="profile-avatar">
                <User size={64} />
              </div>
              <h2>{userData.firstName} {userData.lastName}</h2>
              <p>{userData.userType === 'PARTICIPANT' ? 'Runner' : userData.userType}</p>
            </Card.Body>
          </Card>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md={8}>
          {renderEditableCard('Email', 'email', <Mail size={20} />)}
          {renderEditableCard('Phone', 'phoneNo', <Phone size={20} />)}
          {renderEditableCard('Location', 'location', <MapPin size={20} />)}
          {renderEditableCard('Sport', 'sport', <Activity size={20} />)}
          {renderEditableCard('Username', 'userName', <User size={20} />)}
        </Col>
      </Row>
    </Container>
  );
};

export default Profile;