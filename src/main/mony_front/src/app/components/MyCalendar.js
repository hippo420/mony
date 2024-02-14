//https://dhdl-it.tistory.com/60
// pages/calendar.js
'use client'

import { useEffect, useState } from 'react';
import Calendar from '@fullcalendar/react';
import dayGridPlugin from '@fullcalendar/daygrid';

const MyCalendar = () => {
  const [events, setEvents] = useState([]);
  const [selectedEvent, setSelectedEvent] = useState(null);

  useEffect(() => {
    // 예시로 사용할 이벤트 데이터를 가져오는 비동기 함수
    const fetchEvents = async () => {
      // 예시 데이터를 가져올 때 사용할 API 호출 등을 여기에 작성
      const data = [
        {
          title: '이벤트 1',
          start: '2024-02-14',
          description: '이벤트 1의 설명',
        },
        {
          title: '이벤트 2',
          start: '2024-02-15',
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
    handleCloseModal(clickInfo.event);
  };

  //클릭시 모달 호출
  const handleCloseModal = (data) => {
    setSelectedEvent(data);
  };

  return (
    <div className="container">
      <h1>캘린더</h1>
      <div className={`modal ${selectedEvent ? 'show' : ''}`}>
        <div className="modal-content">
          <span className="close" onClick={handleCloseModal}>&times;</span>
          {selectedEvent && (
            <div>
              <h2>{selectedEvent.title}</h2>
              <p>{selectedEvent.extendedProps.description}</p>
            </div>
          )}
        </div>
      </div>
      <div className="calendar-container">
        <Calendar
          plugins={[dayGridPlugin]}
          initialView="dayGridMonth"
          events={events}
          eventClick={handleEventClick} // 클릭 이벤트 핸들러 등록
        />
      </div>
      <style jsx>{`
        .container {
          position: relative;
        }

        .modal {
          display: none;
          position: absolute;
          top: 50%;
          left: 50%;
          transform: translate(-50%, -50%);
          background-color: #fefefe;
          padding: 20px;
          border: 1px solid #888;
          border-radius: 8px;
          transition: opacity 0.5s, transform 0.5s;
          opacity: 0;
        }

        .modal.show {
          display: block;
          opacity: 1;
          transform: translate(-50%, -50%) scale(1);
        }

        .modal-content {
          width: 300px;
        }

        .close {
          position: absolute;
          top: 10px;
          right: 10px;
          cursor: pointer;
        }

        .calendar-container {
          margin-top: 20px;
        }
      `}</style>
    </div>
  );
};

export default MyCalendar;
