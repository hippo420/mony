import CustomCalendar from '../components/CustomCalendar';
import MyCalendar from '../components/MyCalendar';
import EventDetail from '../components/EventDetail';
import style from './page.module.css';

export default function Account() {
    
    return (
    <div>
         
        <div className={style.calendar}>
            <h1>Mony Calendar</h1>
            <MyCalendar />
        </div>
        
       
    </div>
    );
    
}
    