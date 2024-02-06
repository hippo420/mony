'use client';
import Link from 'next/link';
import { useState } from 'react';
import styles from './Login.module.css';


const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        // 로그인 처리 로직 작성
    };

    return (
        <div className={styles.container}>
        <h1>Login</h1>
        <form onSubmit={handleSubmit} className={styles.form}>
            <div className={styles.inputGroup}>
            <label>Email:</label>
            <input
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
            />
            </div>
            <div className={styles.inputGroup}>
            <label>Password:</label>
            <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
            />
            </div>
            <button type="submit">Login</button>
        </form>
        <p>
            Don't have an account?{' '}
            <Link href="/signup">
          
            </Link>
        </p>
        </div>
    );
};

export default Login;
