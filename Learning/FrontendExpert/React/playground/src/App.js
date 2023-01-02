import "./App.css";
import { Divider, Typography } from "antd";
import TipCalculator from "./TipCalculator/TipCalculator";
import Memory from "./MemoryGame/MemoryGame";

const { Title } = Typography;

function App() {
  return (
    <>
      <div className="App">
        {/* <Title level={3}>Tip Calculator</Title>
        <TipCalculator />
        <Divider dashed /> */}
        {/* <Title level={3}>Memory Game</Title> */}
        <Memory />
      </div>
    </>
  );
}

export default App;
