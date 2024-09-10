import 'bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import './App.css';

import AppNavbar from './components/navigation/AppNavbar.js';
import RunClubs from './components/clubs/RunClub';
import BottomNav from './components/navigation/BottomNav.js';
import Home from './components/home/Home';

function App() {
  return (
    <Router>
      <div className="App">
        <AppNavbar />
        <div className="content-wrap">
          <Routes>
            <Route path="/" element={<Home />} />  {/* Home route */}
            <Route path="/clubs" element={<RunClubs />} />  {/* RunClubs route */}
          </Routes>
        </div>
        <BottomNav />
      </div>
    </Router>
  );
}

export default App;
