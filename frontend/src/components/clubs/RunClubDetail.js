import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { Container, Card, Button, ListGroup, Badge } from 'react-bootstrap';
import { MapPin, Users, Calendar, Clock } from 'lucide-react';
import axios from 'axios'; // Make sure to install axios: npm install axios
import './RunClubDetail.css';


const runClubsData = [
    {
      id: 1,
      name: 'City Striders',
      location: 'Downtown',
      memberCount: 42,
      description: 'A club for urban runners exploring the city streets.',
      meetingLocation: 'Central Square',
      runDays: [
        { day: 'Monday', time: '6:00 PM' },
        { day: 'Wednesday', time: '6:30 PM' },
        { day: 'Saturday', time: '8:00 AM' }
      ],
      members: [
        { name: 'John Doe', role: 'creator' },
        { name: 'Jane Smith', role: 'member' },
        { name: 'Mike Johnson', role: 'member' }
      ]
    },
    // Add more run clubs here...
  ];


const RunClubDetail = () => {
  const [runClub, setRunClub] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    const fetchRunClub = () => {
      setLoading(true);
      // Find the run club in our static data
      const club = runClubsData.find(club => club.id === parseInt(id));
      
      if (club) {
        setRunClub(club);
        setLoading(false);
      } else {
        setError('Run club not found');
        setLoading(false);
      }
    };

    fetchRunClub();
  }, [id]);

  const handleJoin = async () => {
    try {
      // Replace with your actual API endpoint
      await axios.post(`/api/runclubs/${id}/join`);
      // Optionally, update the local state or refetch the run club data
      alert('Successfully joined the run club!');
      // Redirect to the run clubs list or refresh the current page
      navigate('/clubs');
    } catch (err) {
      alert('Failed to join the run club. Please try again.');
    }
  };

  if (loading) return <div>Loading...</div>;
  if (error) return <div>{error}</div>;
  if (!runClub) return <div>Run club not found</div>;

  return (
    <Container className="run-club-detail mt-3">
      <Card className="mb-3">
        <Card.Body>
          <Card.Title>{runClub.name}</Card.Title>
          <Card.Text>
            <MapPin size={18} className="me-2" />
            {runClub.location}
          </Card.Text>
          <Card.Text>
            <Users size={18} className="me-2" />
            {runClub.memberCount} members
          </Card.Text>
          <ListGroup variant="flush">
            {runClub.runDays.map((day, index) => (
              <ListGroup.Item key={index} className="d-flex justify-content-between align-items-center">
                <span>
                  <Calendar size={18} className="me-2" />
                  {day.day}
                </span>
                <span>
                  <Clock size={18} className="me-2" />
                  {day.time}
                </span>
              </ListGroup.Item>
            ))}
          </ListGroup>
          <Card.Text className="mt-3">
            <strong>Meeting Location:</strong> {runClub.meetingLocation}
          </Card.Text>
          <Card.Text>
            <strong>Description:</strong> {runClub.description}
          </Card.Text>
          <Button variant="primary" onClick={handleJoin}>Join Run Club</Button>
        </Card.Body>
      </Card>
      
      <Card>
        <Card.Body>
          <Card.Title>Members</Card.Title>
          <ListGroup variant="flush">
            {runClub.members.map((member, index) => (
              <ListGroup.Item key={index}>
                {member.name}
                {member.role === 'creator' && <Badge bg="secondary" className="ms-2">Creator</Badge>}
              </ListGroup.Item>
            ))}
          </ListGroup>
        </Card.Body>
      </Card>
    </Container>
  );
};

export default RunClubDetail;