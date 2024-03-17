//https://dhdl-it.tistory.com/60
// pages/calendar.js
'use client'

import { useEffect, useState } from 'react';
import Calendar from '@fullcalendar/react';
import dayGridPlugin from '@fullcalendar/daygrid';
import style from './MyCalendar.module.css';
import styled from "@emotion/styled";

const SERVICE_NAME ='';


export const StyleWrapper = styled.div`
  .fc td {
    background: whtie;
  }
  .fc-event-title fc-sticky{
    background: red;
  }
  .fc .fc-daygrid-day.fc-day-today {
    background-color: #fff8bd;
    color: #356eff;
  }
  .fc-event {
    cursor: pointer;
    padding: 5px 8px;
    margin-bottom: 5px;
    border-radius: 4px;
    font-weight: 500;
    font-size: 10px;
  }
  .fc-h-event{
    background : white;
  }
  .fc-day-sat a{
    color: blue;
    text-decoration:none;
  }
  .fc-day-sun a{
    color: red;
    text-decoration:none;
  }
`

const MyCalendar = () => {
  const [events, setEvents] = useState([]);
  const [selectedEvent, setSelectedEvent] = useState(null);

  useEffect(() => {
    // 예시로 사용할 이벤트 데이터를 가져오는 비동기 함수
    const fetchEvents = async () => {
      // 예시 데이터를 가져올 때 사용할 API 호출 등을 여기에 작성
      const data = [
        {
          title: '100,000',
          textColor : 'blue',
          start: '2024-02-14',
          description: '이벤트 1의 설명',
        },
        {
          title: '1,000,000',
          textColor : 'blue',
          start: '2024-02-15',
          description: '이벤트 2의 설명',
        },{
          title: '-50,000',
          textColor : 'red',
          start: '2024-02-14',
          description: '이벤트 2의 설명',
        },
        // 추가적인 이벤트 데이터를 가져올 수 있음
      ];
      setEvents(data);
    };

    fetchEvents();
  }, []);
  
  //이벤트 클릭
  const handleEventClick = (clickInfo) => {
    //alert(`클릭된 이벤트: ${clickInfo.event.title}`);
    alert('달려컴포넌트 클릭');
    handleCloseModal(clickInfo.event);
  };

  //클릭시 모달 호출
  const handleCloseModal = (data) => {
    setSelectedEvent(data);
  };

  return (
    <div className={style.container}>
      <h1>캘린더</h1>
      <div className={`style.modal ${selectedEvent ? 'show' : ''}`}>
        <div className={style.modal_content}>
          <span className={style.close} onClick={handleCloseModal}>&times;</span>
          {selectedEvent && (
            <div>
              <h2>{selectedEvent.title}</h2>
              <p>{selectedEvent.extendedProps.description}</p>
            </div>
          )}
        </div>
      </div>
      <div className={style.calendar_container}>
        <StyleWrapper>
          <Calendar
            plugins={[dayGridPlugin]}
            initialView="dayGridMonth"
            events={events}
            eventClick={handleEventClick} // 클릭 이벤트 핸들러 등록
          />  
        </StyleWrapper>
      </div>
    </div>
  );
};

export default MyCalendar;
