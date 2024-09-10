import React from 'react'; 
import { Container, Card, Button} from 'react-bootstrap'; 
import './RunClub.css'

const runClubsData = [
    { id: 1, name: 'City Striders', location: 'Downtown', members: 42 },
    { id: 2, name: 'Park Pacers', location: 'Central Park', members: 28 },
    { id: 3, name: 'Sunset Runners', location: 'West Side', members: 35 },
    { id: 4, name: 'Marathon Maniacs', location: 'Eastville', members: 50 },
    { id: 5, name: 'Trail Trekkers', location: 'Forest Hills', members: 22 },
];

const RunClubs = () => {
    return (
      <Container className="mt-5 pt-5 px-4" style={{ paddingTop: '60px',  }}>
        <h1 className="run-clubs-heading">
          Find a Run Club !
        </h1>
        <div className="run-clubs-list" style={{ maxHeight: '70vh', overflowY: 'auto' }}>
          {runClubsData.map(club => (
            <Card key={club.id} className="mb-3">
              <Card.Body>
                <Card.Title>{club.name}</Card.Title>
                <Card.Text>
                  <strong>Location:</strong> {club.location}<br />
                  <strong>Members:</strong> {club.members}
                </Card.Text>
                <Button variant="primary">Join Club</Button>
              </Card.Body>
            </Card>
          ))}
        </div>
      </Container>
    );
  };
  
  export default RunClubs;



