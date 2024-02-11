'use client';
import Link from 'next/link';
import { useState } from 'react';
import gfnTrx from '../utils/fetch';
import styles from './Login.module.css';

export default function Login()
{
    //const login = useAuth();
    const [userId, setUserId] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();

        const apiUrl = '/login/prcLogin/';
        //const member = {userId,  password:encPW(password)};
        const member = {userId,  password};

        try {
            // fetchData 함수를 사용하여 데이터 가져오기
            const data = gfnTrx(apiUrl,'POST',member,true, (error, data) => {
                if (error) {
                    console.error('Error occurred:', error);
                } else {
                    
                    console.log('login: ', data);
                    return { props: { data } };
                }
            });
            //login(data);
            
            // 데이터를 페이지의 props로 전달
            
        } catch (error) {
            // 오류 발생 시 처리
            console.error('Error fetching data:', error);
            return { props: { data: null } };
        }
    };

    return (
        <div className={styles.container}>
        <h1>Login</h1>
        <form onSubmit={handleSubmit} className={styles.form}>
            <div className={styles.inputGroup}>
            <label>Email:</label>
            <input
                type="email"
                value={userId}
                onChange={(e) => setUserId(e.target.value)}
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
            <button className={styles.button} type="submit">Login</button>
        </form>
        
        <p>
            Don't have an account?{' '}
            <Link href="/signup"></Link>
        </p>

        </div>
    );
}