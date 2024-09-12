import React, { useState, useContext } from 'react';
import { useGoogleLogin } from '@react-oauth/google';
import AppleLogin from 'react-apple-login';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from './AuthContext';
import { Button, Form, Container, Row, Col } from 'react-bootstrap';

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();
    const { login } = useContext(AuthContext);

    const handleGoogleLogin = useGoogleLogin({
        onSuccess: async (tokenResponse) => {
            try {
                const res = await axios.post('/api/auth/google', { access_token: tokenResponse.access_token });
                login(res.data.user, res.data.token);
                navigate('/');
            } catch (error) {
                console.error('Google login error', error);
                // Consider adding user-friendly error handling here
            }
        },
        onError: error => {
            console.error('Google login failed', error);
            // Consider adding user-friendly error handling here
        }
    });

    const handleAppleSuccess = async (response) => {
        try {
            const res = await axios.post('/api/auth/apple', { idToken: response.authorization.id_token });
            login(res.data.user, res.data.token);
            navigate('/');
        } catch (error) {
            console.error('Apple login error', error);
            // Consider adding user-friendly error handling here
        }
    };

    const handleEmailLogin = async (e) => {
        e.preventDefault();
        try {
            const res = await axios.post('/api/auth/login', { email, password });
            login(res.data.user, res.data.token);
            navigate('/');
        } catch (error) {
            console.error('Email login error', error);
            // Consider adding user-friendly error handling here
        }
    };

    return (
        <Container className="mt-5">
            <Row className="justify-content-md-center">
                <Col md={6}>
                    <h2 className="text-center mb-4">Login</h2>
                    <Button onClick={handleGoogleLogin} variant="outline-primary" className="w-100 mb-3">
                        Login with Google
                    </Button>
                    <AppleLogin
                        clientId="YOUR_APPLE_CLIENT_ID"
                        redirectURI="YOUR_REDIRECT_URI"
                        usePopup={true}
                        callback={handleAppleSuccess}
                        scope="email name"
                        responseMode="query"
                        render={renderProps => (
                            <Button onClick={renderProps.onClick} variant="outline-secondary" className="w-100 mb-3">
                                Login with Apple
                            </Button>
                        )}
                    />
                    <Form onSubmit={handleEmailLogin}>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Control
                                type="email"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                placeholder="Email"
                                required
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Control
                                type="password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                placeholder="Password"
                                required
                            />
                        </Form.Group>
                        <Button variant="primary" type="submit" className="w-100">
                            Login with Email
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    );
};

export default Login;