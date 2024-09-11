import 'bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import './App.css';

import AppNavbar from './components/navigation/AppNavbar.js';
import RunClubs from './components/clubs/RunClub';
import BottomNav from './components/navigation/BottomNav.js';
import Home from './components/home/Home';
import Events from './components/events/Event.js';
import Profile from './components/profile/Profile.js';
import RunClubDetail from './components/clubs/RunClubDetail.js';
import EventDetail from './components/events/EventDetail.js';

function App() {
  return (
    <Router>
      <div className="App">
        <AppNavbar />
        <div className="content-wrap">
          <Routes>
            <Route path="/" element={<Home />} />  {/* Home route */}
            <Route path="/clubs" element={<RunClubs />} />  {/* RunClubs route */}
            <Route path="/clubs/:id" element={<RunClubDetail />} />
            <Route path="/events" element={<Events/>} />
            <Route path="/events/:id" element={<EventDetail />} />
            <Route path="/profile" element={<Profile/>} />
          </Routes>
        </div>
        <BottomNav />
      </div>
    </Router>
  );
}

export default App;
