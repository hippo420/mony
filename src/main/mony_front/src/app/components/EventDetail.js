// EventDetail.js
import style from './EventDetail.module.css';
const EventDetail = ({ event, onClose }) => {
    return (
      <div className={style.detail_content}>
        <span className={style.close} onClick={onClose}>&times;</span>
        <h2>상세내역</h2>
        
      </div>
    );
  };
  
  export default EventDetail;
  