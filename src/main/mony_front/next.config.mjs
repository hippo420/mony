/** @type {import('next').NextConfig} */
const SERVICE_IP = process.env.NEXT_PUBLIC_IP;
const SERVICE_PORT =process.env.NEXT_PUBLIC_PORT;

console.log('SERVICE_IP: '+SERVICE_IP);
console.log('SERVICE_PORT: '+SERVICE_PORT);

//CORS 문제 해결: Proxy이용
const nextConfig = {
    async rewrites() {
        return [
            {
                source: '/:path*',
                destination: `http://${SERVICE_IP}:${SERVICE_PORT}/:path*`, //springboot의 API주소
            },
        
        ];
    },
};
export default nextConfig;