import './App.css';
import HeaderComponent from "./components/HeaderComponent";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import WelcomeComponent from "./components/WelcomeComponent";
import React from "react";

function App() {
  return (
      <div style={{backgroundColor: "#d59595"}}>
          <Router>
              <div style={{ overflowY: 'auto', overflowX: 'auto', minHeight: '100vh', position: 'relative' }}>
                  <HeaderComponent />
                  <div className="container">
                      <Switch>
                          <Route path="/" exact component={WelcomeComponent}></Route>
                      </Switch>
                  </div>
              </div>
          </Router>
      </div>
  );
}

export default App;
