import "./App.css";
import { Divider, Typography } from "antd";
import TipCalculator from "./TipCalculator/TipCalculator";
import Memory from "./MemoryGame/MemoryGame";
import CryptoPrices from "./CryptoPrices/Main";
import QuestionList from "./QuestionList/Main";

const { Title } = Typography;

function App() {
  return (
    <>
      <div className="App">
        <Title level={3}>Tip Calculator</Title>
        <TipCalculator />
        <Divider dashed />
        <Title level={3}>Memory Game</Title>
        <Memory />
        <Divider dashed />
        <Title level={3}>Question List</Title>
        <QuestionList />
        <Divider dashed />
        <Title level={3}>Crypto List</Title>
        <CryptoPrices />
      </div>
    </>
  );
}

export default App;
