
export default function Test() {
    const port = process.env.NEXT_PUBLIC_PORT;
    console.log('ENV: '+ port);
    
    return (
    <div>
        <h2>Test</h2>
    </div>
    );
    
}
    