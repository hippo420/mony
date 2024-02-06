
export default function Home() {
  const port = process.env.PORT;
  console.log('ENV: '+ port);

  return (
    <div>
      <h2>Home</h2>
    </div>
  );
}
