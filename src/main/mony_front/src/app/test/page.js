'use client'
import MyCalendar from '../components/MyCalendar';
import EventDetail from '../components/EventDetail';
import { useState } from 'react';

export default function Test() {
const [isCalendarExpanded, setCalendarExpanded] = useState(true);

  const toggleCalendarSize = () => {
    alert('달려클릭');
    setCalendarExpanded(!isCalendarExpanded);
  };

  return (
    <div style={{ display: 'flex', flexWrap: 'wrap' }}>
      <MyCalendar/>
      <EventDetail onClick={toggleCalendarSize} isVisible={!isCalendarExpanded} />
    </div>
  );
                       
};