import axios from "axios";

// 공통 API 호출 함수
const gfnTrx = (url, method, data, sync) => {
    
    const config = {
        method,
        url,
        data,
    };


    // axios로부터 반환되는 프로미스를 반환하도록 변경
    return axios(config)
        .then(response => {
            console.log('gfnTrx:', response.data);
            return response.data;
        })
        .catch(error => {
            // 여기에 오류 처리 로직을 추가할 수 있습니다.
            console.error('API Error:', error);
            throw new Error('API 요청 중 오류가 발생했습니다.');
        });
};

export default gfnTrx;