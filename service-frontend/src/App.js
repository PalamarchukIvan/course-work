import './App.css';
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Welcome from "./components/Welcome";
import DatePicker from "react-datepicker";
import React from "react";

function App() {
  return (
      <div>
          <Router>
              <div style={{ overflowY: 'auto', overflowX: 'auto', minHeight: '100vh', position: 'relative' }}>
                  <HeaderComponent />
                  <div className="container">
                      <Switch>
                          <Route path="/" exact component={Welcome}></Route>
                      </Switch>
                  </div>
                  <FooterComponent />
              </div>
          </Router>
      </div>
  );
}

export default App;
