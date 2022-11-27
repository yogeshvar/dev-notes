import "./App.css";
import { Divider, Typography } from "antd";
import TipCalculator from "./TipCalculator/TipCalculator";

const { Title } = Typography;

function App() {
  return (
    <>
      <div className="App">
        <Title level={3}>Tip Calculator</Title>
        <TipCalculator />
        <Divider dashed />
      </div>
    </>
  );
}

export default App;
