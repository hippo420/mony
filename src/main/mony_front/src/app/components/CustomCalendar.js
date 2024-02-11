// components/CustomCalendar.js
'use client'
import moment from "moment";
import { useState } from 'react';
import Calendar from 'react-calendar';
import styles from './CustomCalendar.module.css';

const CustomCalendar = () => {
  // 각 날짜의 입금 및 출금 금액을 저장하는 상태
    const [dateAmounts, setDateAmounts] = useState({
        '2024-02-01': { deposit: 100000, withdrawal: 50 },
        '2024-02-05': { deposit: 1500000, withdrawal: 0 },
        // 원하는 날짜와 해당 날짜의 입출금을 추가할 수 있습니다.
    });

    // 날짜에 따른 스타일을 정의하는 함수
    const tileClassName = ({ date }) => {
        const { deposit, withdrawal } = dateAmounts[formatDate(date)] || { deposit: 0, withdrawal: 0 };
        let classNames = '';
        if (deposit > 0) classNames += ' has-deposit';
        if (withdrawal > 0) classNames += ' has-withdrawal';
        return classNames;
    };
    
    const tileContent = ({ date }) => {
        const { deposit, withdrawal } = dateAmounts[formatDate(date)] || { deposit: 0, withdrawal: 0 };
        return (
            <div>
            {deposit > 0 && <p className="deposit">{deposit}</p>}
            {withdrawal > 0 && <p className="withdrawal">-{withdrawal}</p>}
            </div>
        );
    };

    // 날짜 클릭 핸들러 (나중에 선택한 날짜에 대한 처리를 추가할 수 있습니다.)
    const handleDateClick = (date) => {
        console.log('Selected date:', date);
    };

    // 날짜를 YYYY-MM-DD 형식의 문자열로 변환하는 함수
    const formatDate = (date) => {
        return `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(2, '0')}-${String(date.getDate()).padStart(2, '0')}`;
    };

    return (
        <div className={styles['calendar-container']}>
            <Calendar
                locale="ko-KR"
                calendarType="gregory"
                weekStartDay={0} // 0이면 일요일부터 시작
                tileClassName={tileClassName}
                tileContent={tileContent}
                formatDay={(locale, date) => moment(date).format("D")}
                onClickDay={handleDateClick}
                
            />
            
    </div>
    );
};

export default CustomCalendar;
