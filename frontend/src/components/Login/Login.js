import React, { useState, useContext } from 'react'; 
import { useGoogleLogin } from '@react-oauth/google';
import AppleLogin from 'react-apple-login';
import axios from 'axios'; 
import { useNavigate } from 'react-router-dom';
import {Authcontext} from './AuthContext'
import { Button, Form } from 'react-bootstrap';

const Login = () => {
    const [email, setEmail] = useState(''); 
    const [password, setPassword] = useState(''); 
    const navigate = useNavigate(); 
    const { login } = useContext(Authcontext); 

    const handleGoogleLogin = useGoogleLogin({
        onSuccess: async (tokenResponse) => {
            try {
                const res = await axios.post('/api/auth/google', {access_token: tokenResponse.access_token}); 
                login(res.data.user, res.data.token); 
                navigate('/')
            } catch (error){
                console.error ('Google login error', error)
            }
        },
        onError: error => console.error('Google login failed', error)
    });

    const handleAppleSuccess = async (response) => {
        try {
            const res = await axios.post('api/auth/apple', {idToken: response.authorization.id_token});
            login(res.data.user, res.data.token)
            navigate('/')
        } catch (error){
            console.error('Apple login error', error);
        }
    }; 

    const handleEmailLogin = async (e) => {
        e.preventDefault(); 

        try {
            const res = await axios.post('/api/auth/login', {email, password}); 
            login(res.data.user, res.data.token); 
            navigate('/')
        } catch (error){
            console.error('Email login error', error);
        }
    };


    return (
        <div className="login-container">
            <h2> Login </h2>
            <Button onClick={handleGoogleLogin}>Login with Google</Button>
            <AppleLogin
                clientId="YOUR-APPLE-CLIENT-ID"
                redirectURI="YOUR_REDIRECT_URI"
                usePopup={true}
                callback={handleAppleSuccess}
                scope='email name'
                responseMode='query'
                render={renderProps => (
                    <Button onClick={renderProps.onClick}>Login with Appple</Button>
                )}
            />
            <Form
                onSubmit={handleEmailLogin}
            >
                <input
                    type="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    placeholder='Email'
                />
                <input
                    type="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    placeholder='Password'
                />
            </Form>
        </div>
    );

};

export default Login;


