import React, { useState, useEffect } from "react";
import "./MemoryGame.css";

const TILE_COLORS = ["red", "green", "blue", "yellow"];

export default function Memory() {
  const [isWin, setIsWin] = useState(false);
  const [selected, setSelected] = useState([]);
  const [matched, setMatched] = useState([]);
  const [board, setBoard] = useState(() => [
    ...shuffle(TILE_COLORS),
    ...shuffle(TILE_COLORS),
  ]);

  function tileClick(i) {}

  return (
    <>
      <h1>{isWin ? `You Win!` : `Memory`}</h1>
      <div className="board">
        {board.map((tile, i) => {
          const classes = false ? `tile ${tile}` : "tile";
          return (
            <div className={classes} key={i} onClick={() => tileClick(i)} />
          );
        })}
      </div>
      {isWin && <button>Restart</button>}
    </>
  );
}

/**
 * Returns the array shuffled into a random order.
 * Do not edit this function.
 */
function shuffle(array) {
  for (let i = array.length - 1; i > 0; i--) {
    const randomIndex = Math.floor(Math.random() * (i + 1));

    // Swap the elements at i and randomIndex
    [array[i], array[randomIndex]] = [array[randomIndex], array[i]];
  }
  return array;
}
