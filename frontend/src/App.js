import 'bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import './App.css';

import AppNavbar from './components/navbar';
import RunClubs from './components/home/RunClub';

function App() {
  return (
    <Router>
      <div className = "App">
        <AppNavbar/>
        <Routes>
          <Route path="/clubs" elements={<RunClubs/>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
