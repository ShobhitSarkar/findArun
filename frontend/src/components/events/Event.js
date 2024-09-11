import React from 'react'; 
import { Container, Card, Button} from 'react-bootstrap'; 
import './Event.css'

const eventsData = [
    { id: 1, name: 'Run with us !', location: 'Downtown' },
    { id: 2, name: 'Run with us !', location: 'Central Park' },
    { id: 3, name: 'Run with us !', location: 'West Side' },
    { id: 4, name: 'Run with us !', location: 'Eastville' },
    { id: 5, name: 'Run with us !', location: 'Forest Hills' },
];

const Events = () => {
    return (
      <Container className="pt-5 px-4" >
        <h1 className="events-heading">
          Find events !
        </h1>
        <div className="events-list" style={{ maxHeight: '70vh', overflowY: 'auto' }}>
          {eventsData.map(club => (
            <Card key={club.id} className="mb-3">
              <Card.Body>
                <Card.Title>{club.name}</Card.Title>
                <Card.Text>
                  <strong>Location:</strong> {club.location}<br />
                </Card.Text>
                <Button variant="primary">RSVP</Button>
              </Card.Body>
            </Card>
          ))}
        </div>
      </Container>
    );
  };
  
  export default Events;



