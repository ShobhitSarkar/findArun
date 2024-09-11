import React, { useState, useEffect } from 'react';
import { Container, Card, Button, Badge } from 'react-bootstrap';
import { Calendar, Users, MessageCircle } from 'lucide-react';
import './Home.css';

const Home = () => {
  const [feedItems, setFeedItems] = useState([]);

  useEffect(() => {
    const dummyFeedItems = [
      { type: 'event', id: 1, title: 'Weekend Marathon', date: '2023-06-15', location: 'Central Park' },
      { type: 'runClub', id: 1, name: 'City Striders', members: 42, location: 'Downtown' },
      { type: 'message', id: 1, from: 'Run Club Admin', content: 'New running challenge this month!' },
      { type: 'event', id: 2, title: 'Charity Fun Run', date: '2023-06-20', location: 'Riverside' },
      { type: 'runClub', id: 2, name: 'Trail Blazers', members: 28, location: 'Forest Hills' },
      { type: 'message', id: 2, from: 'Event Organizer', content: 'Don\'t forget to register for the upcoming race!' },
    ];
    setFeedItems(dummyFeedItems);
  }, []);

  const renderFeedItem = (item) => {
    switch (item.type) {
      case 'event':
        return (
          <Card key={`event-${item.id}`} className="mb-3 feed-card">
            <Card.Body>
              <Card.Title>{item.title}</Card.Title>
              <Card.Text>
                <Calendar className="me-2" size={18} />
                {item.date} at {item.location}
              </Card.Text>
              <Button variant="primary">View Event</Button>
            </Card.Body>
          </Card>
        );
      case 'runClub':
        return (
          <Card key={`runClub-${item.id}`} className="mb-3 feed-card">
            <Card.Body>
              <Card.Title>{item.name}</Card.Title>
              <Card.Text>
                <Users className="me-2" size={18} />
                {item.members} members
              </Card.Text>
              <Card.Text>
                <Badge bg="secondary">{item.location}</Badge>
              </Card.Text>
              <Button variant="primary">Join Club</Button>
            </Card.Body>
          </Card>
        );
      case 'message':
        return (
          <Card key={`message-${item.id}`} className="mb-3 feed-card">
            <Card.Body>
              <Card.Title>
                <MessageCircle className="me-2" size={18} />
                Message from {item.from}
              </Card.Title>
              <Card.Text>{item.content}</Card.Text>
            </Card.Body>
          </Card>
        );
      default:
        return null;
    }
  };

  return (
    <Container className="home-view mt-3">
      <h1 className="mb-4">AROUND YOU</h1>
      {feedItems.map(renderFeedItem)}
    </Container>
  );
};

export default Home;