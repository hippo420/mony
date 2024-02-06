/** @type {import('next').NextConfig} */
const SERVICE_IP = process.env.NEXT_PUBLIC_IP;
const SERVICE_PORT =process.env.NEXT_PUBLIC_PORT;

console.log('SERVICE_IP: '+SERVICE_IP);
console.log('SERVICE_PORT: '+SERVICE_PORT);

const nextConfig = {
    //reactStrictMode: true,
    // swcMinify: true,
    // async rewrites(){
    //     return[
    //         {
    //             source: '/:path*',
    //             destination:'http://'+SERVICE_IP+':'+SERVICE_PORT+'/"path*'
    //         }
    //     ]
    // }
}
module.exports = nextConfig;