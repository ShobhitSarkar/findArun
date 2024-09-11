import React from 'react';
import { Container, Card, Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { Calendar, MapPin } from 'lucide-react';
import './Event.css';

const eventsData = [
  { id: 1, name: 'City Marathon', date: '2023-09-15', location: 'Downtown City Park' },
  { id: 2, name: 'Sunset 5K Run', date: '2023-08-20', location: 'Beachfront Promenade' },
  // Add more events as needed
];

const Event = () => {
  const navigate = useNavigate();

  const handleRSVPClick = (eventId) => {
    navigate(`/events/${eventId}`);
  };

  return (
    <Container className="events-list mt-3">
      <h1 className="mb-4">Events</h1>
      {eventsData.map(event => (
        <Card key={event.id} className="mb-3">
          <Card.Body>
            <Card.Title>{event.name}</Card.Title>
            <Card.Text>
              <Calendar size={18} className="me-2" />
              {event.date}
            </Card.Text>
            <Card.Text>
              <MapPin size={18} className="me-2" />
              {event.location}
            </Card.Text>
            <Button 
              variant="primary" 
              onClick={() => handleRSVPClick(event.id)}
            >
              View Event
            </Button>
          </Card.Body>
        </Card>
      ))}
    </Container>
  );
};

export default Event;