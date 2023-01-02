import React, { useState, useEffect } from "react";
import "./TipCalculator.css";

export default function TipCalculator() {
  const [bill, setBill] = useState(50);
  const [tip, setTip] = useState(18);
  const [nop, setNop] = useState(1);
  const [totalTip, setTotalTip] = useState(0);
  const [tipPerPerson, setTipPerPerson] = useState(0);

  useEffect(() => {
    setTotalTip((bill * tip * 0.01).toFixed(2));
    setTipPerPerson((totalTip / nop).toFixed(2));
  }, [bill, tip, nop, totalTip]);

  return (
    <div className="tipCalc">
      <label>
        Bill
        <input
          type="number"
          value={bill}
          onChange={(e) => setBill(e.target.value)}
        />
      </label>

      <label>
        Tip Percentage
        <input
          type="number"
          value={tip}
          onChange={(e) => setTip(e.target.value)}
        />
      </label>

      <label>
        Number of People
        <input
          type="number"
          value={nop}
          onChange={(e) => setNop(e.target.value)}
        />
      </label>

      <p>Total Tip: {totalTip == 0 ? "-" : `$${totalTip}`}</p>
      <p>Tip Per Person: {tipPerPerson == 0 ? "-" : `$${tipPerPerson}`}</p>
    </div>
  );
}
