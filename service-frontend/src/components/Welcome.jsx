import React, { Component } from 'react';
import { Container, Button } from 'react-bootstrap';

class WelcomePage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            user: null, // Информация о пользователе, если он вошел в систему
        };
    }

    render() {
        const { user } = this.state;

        const jumbotronStyle = {
            backgroundColor: '#7FFF00',
            textAlign: 'center',
            padding: '100px 0',
            color: '#FFFFFF',
        };

        return (
            <div
                style={{
                    background: '#4CAF50',
                    backgroundImage: 'url("https://example.com/pattern.jpg")',
                    backgroundSize: 'cover',
                    color: '#fff',
                    padding: '20px',
                    textAlign: 'center',
                    height: '100vh', // Высота на весь экран
                }}
            >
                <Container style={{ backgroundColor: 'rgba(255, 255, 255, 0.8)', borderRadius: '10px', boxShadow: '0 0 10px rgba(0, 0, 0, 0.3)' }}>
                    <h1>Welcome to DBlog</h1>
                    <p>Explore the latest articles, share your thoughts, and be part of the DBlog community.</p>
                    <Button variant="primary" href="/articles">
                        Explore Articles
                    </Button>
                </Container>
            </div>
        );
    }

    handleLogout = () => {
        this.setState({ user: null });
    };
}

export default WelcomePage;
