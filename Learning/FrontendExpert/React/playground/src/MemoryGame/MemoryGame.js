import React, { useState, useEffect } from "react";
import "./MemoryGame.css";

const TILE_COLORS = ["red", "green", "blue", "yellow"];

export default function Memory() {
  const [selected, setSelected] = useState([]);
  const [matched, setMatched] = useState([]);
  const [board, setBoard] = useState(() => [
    ...shuffle(TILE_COLORS),
    ...shuffle(TILE_COLORS),
  ]);

  useEffect(() => {
    if (selected.length < 2) return;

    if (board[selected[0]] === board[selected[1]]) {
      setMatched([...matched, ...selected]);
      setSelected([]);
    } else {
      const timeoutId = setTimeout(() => setSelected([]), 1000);
      return () => clearTimeout(timeoutId);
    }
  }, [board, matched, selected]);

  function tileClick(i) {
    if (selected.length >= 2 || selected.includes(i) || matched.includes(i))
      return;
    setSelected([...selected, i]);
  }

  function restart() {
    setBoard([...shuffle(TILE_COLORS), ...shuffle(TILE_COLORS)]);
    setSelected([]);
    setMatched([]);
  }

  const isWin = matched.length === board.length;

  return (
    <>
      <h1>{isWin ? `You Win!` : `Memory`}</h1>
      <div className="board">
        {board.map((tile, i) => {
          const isFlipped = selected.includes(i) || matched.includes(i);
          const classes = isFlipped ? `tile ${tile}` : "tile";
          return (
            <div className={classes} key={i} onClick={() => tileClick(i)} />
          );
        })}
      </div>
      {isWin && <button onClick={() => restart()}>Restart</button>}
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
