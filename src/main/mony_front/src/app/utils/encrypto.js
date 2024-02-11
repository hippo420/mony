import crypto from 'crypto';

// SHA-512 해시를 생성하는 함수\

const encPW = (data) => {
    // 데이터가 문자열이 아니라면 문자열로 변환
    if (typeof data !== 'string') {
        data = JSON.stringify(data);
    }
    
    // SHA-512 해시 생성
    const hash = crypto.createHash('sha512');
    hash.update(data);
    return hash.digest('hex');
};

export default {encPW};

