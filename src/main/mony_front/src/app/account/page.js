import CustomCalendar from '../components/CustomCalendar';
import MyCalendar from '../components/MyCalendar';
import EventDetail from '../components/EventDetail';

export default function Account() {
    
    return (
    <div>
        <td>
        <div>
            <h1>Mony Calendar</h1>
            <MyCalendar />
        </div>
        </td>
        <td>
        <div>
            <h1>Detail</h1>
            <EventDetail />
        </div>
        </td>
    </div>
    );
    
}
    