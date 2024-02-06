
export default function Home() {
  const port = process.env.DEV_PORT;
  console.log('ENV: '+ port);

  return (
    <div>
      <h2>Home</h2>
    </div>
  );
}
