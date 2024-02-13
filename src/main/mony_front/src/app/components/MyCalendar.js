//https://dhdl-it.tistory.com/60
import dayGridPlugin from '@fullcalendar/daygrid';
import FullCalendar from '@fullcalendar/react';
import { Component } from 'react';

class MyCalendar extends Component {
    render() {
        return (
            <div className="App">
                <FullCalendar
                defaultView="dayGridMonth"
                plugins={[ dayGridPlugin ]}
                events={[
                    { title: 'event 1', date: '2022-09-01' },
                    { title: 'event 2', date: '2022-09-02' }
                ]}
                />
            </div>
        );
    }
}
export default MyCalendar;