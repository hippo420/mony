//https://dhdl-it.tistory.com/60
// pages/calendar.js
'use client'

import { useEffect, useState } from 'react';
import Calendar from '@fullcalendar/react';
import dayGridPlugin from '@fullcalendar/daygrid';

const MyCalendar = () => {
  const [events, setEvents] = useState([]);

  useEffect(() => {
    // 예시로 사용할 이벤트 데이터를 가져오는 비동기 함수
    const fetchEvents = async () => {
      // 예시 데이터를 가져올 때 사용할 API 호출 등을 여기에 작성
      const data = [
        {
          title: '이벤트 1',
          start: '2024-02-14',
        },
        {
          title: '이벤트 2',
          start: '2024-02-15',
        },
        // 추가적인 이벤트 데이터를 가져올 수 있음
      ];
      setEvents(data);
    };

    fetchEvents();
  }, []);

  return (
    <div>
      <h1>캘린더</h1>
      <Calendar
        plugins={[dayGridPlugin]}
        initialView="dayGridMonth"
        events={events}
      />
    </div>
  );
};

export default MyCalendar;
