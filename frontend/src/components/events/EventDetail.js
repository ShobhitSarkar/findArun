import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { Container, Card, Button, ListGroup } from 'react-bootstrap';
import { MapPin, Calendar, Clock, Users } from 'lucide-react';
import './EventDetail.css';

// Static data for events
const eventsData = [
  {
    id: 1,
    name: 'City Marathon',
    date: '2023-09-15',
    time: '7:00 AM',
    location: 'Downtown City Park',
    description: 'Annual city marathon covering a scenic route through downtown.',
    distance: '42.2 km',
    participantLimit: 1000,
    currentParticipants: 750,
    organizer: 'City Runners Association'
  },
  {
    id: 2,
    name: 'Sunset 5K Run',
    date: '2023-08-20',
    time: '6:30 PM',
    location: 'Beachfront Promenade',
    description: 'A beautiful evening run along the beach as the sun sets.',
    distance: '5 km',
    participantLimit: 200,
    currentParticipants: 150,
    organizer: 'Sunset Runners Club'
  },
  // Add more events as needed
];

const EventDetail = () => {
  const [event, setEvent] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    const fetchEvent = () => {
      setLoading(true);
      const foundEvent = eventsData.find(e => e.id === parseInt(id));
      
      if (foundEvent) {
        setEvent(foundEvent);
        setLoading(false);
      } else {
        setError('Event not found');
        setLoading(false);
      }
    };

    fetchEvent();
  }, [id]);

  const handleRSVP = () => {
    // In a real app, you would send an API request here
    alert("You have successfully RSVP'd for this event!");
    // Optionally, update the local state or navigate back to the events list
    navigate('/events');
  };

  if (loading) return <div>Loading...</div>;
  if (error) return <div>{error}</div>;
  if (!event) return <div>Event not found</div>;

  return (
    <Container className="event-detail mt-3">
      <Card className="mb-3">
        <Card.Body>
          <Card.Title>{event.name}</Card.Title>
          <ListGroup variant="flush">
            <ListGroup.Item>
              <Calendar size={18} className="me-2" />
              {event.date}
            </ListGroup.Item>
            <ListGroup.Item>
              <Clock size={18} className="me-2" />
              {event.time}
            </ListGroup.Item>
            <ListGroup.Item>
              <MapPin size={18} className="me-2" />
              {event.location}
            </ListGroup.Item>
            <ListGroup.Item>
              <Users size={18} className="me-2" />
              {event.currentParticipants} / {event.participantLimit} participants
            </ListGroup.Item>
          </ListGroup>
          <Card.Text className="mt-3">
            <strong>Distance:</strong> {event.distance}
          </Card.Text>
          <Card.Text>
            <strong>Description:</strong> {event.description}
          </Card.Text>
          <Card.Text>
            <strong>Organizer:</strong> {event.organizer}
          </Card.Text>
          <Button variant="primary" onClick={handleRSVP}>RSVP for Event</Button>
        </Card.Body>
      </Card>
    </Container>
  );
};

export default EventDetail;