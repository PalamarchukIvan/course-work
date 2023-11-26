import './App.css';
import HeaderComponent from "./components/HeaderComponent";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import WelcomeComponent from "./components/WelcomeComponent";
import React from "react";
import ProfileComponent from "./components/ProfileComponent";

function App() {
  return (
      <div style={{backgroundColor: "#5CDB95"}}>
          <Router>
              <div style={{ overflowY: 'auto', overflowX: 'auto', minHeight: '100vh', position: 'relative' }}>
                  <HeaderComponent />
                  <div className="container">
                      <Switch>
                          <Route path="/main" exact component={ProfileComponent}></Route>
                          <Route path="/" exact component={WelcomeComponent}></Route>
                      </Switch>
                  </div>
              </div>
          </Router>
      </div>
  );
}

export default App;
