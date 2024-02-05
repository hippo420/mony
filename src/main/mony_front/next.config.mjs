

const rewrites = async () => {
    return [
        {
            source: "/:path*",
            destination: "http://api.url/:path*"
        },
    ];
};



export default rewrites;
