/** @type {import('next').NextConfig} */
const SERVICE_IP = process.env.IP;
const SERVICE_PORT =process.env.PORT;

const nextConfig = {
    reactStrictMode: true,
    swcMinify: true,
    async rewrites(){
        return[
            {
                source: '/:path*',
                destination:'http://'+SERVICE_IP+':'+SERVICE_PORT+'/"path*'
            }
        ]
    }
}
module.exports = nextConfig;