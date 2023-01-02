const timerContent = document.getElementById("timer");
const startBtn = document.getElementById("start-button");
const stopBtn = document.getElementById("stop-button");
const resetBtn = document.getElementById("reset-button");

startBtn.addEventListener("click", handleStart);
stopBtn.addEventListener("click", handleStop);
resetBtn.addEventListener("click", handleReset);

const requestAnimFrame = (function () {
  return (
    window.requestAnimationFrame ||
    window.webkitRequestAnimationFrame ||
    window.mozRequestAnimationFrame ||
    function (callback) {
      window.setTimeout(callback, 1000 / 60);
    }
  );
})();

let globalTimer;
let prevTime = 0;
let seconds = 0;

function handleStart() {
  stopBtn.disabled = false;
  startBtn.disabled = true;
  resetBtn.disabled = true;

  prevTime = Date.now();
  globalTimer = requestAnimFrame(updateTimer);
}

function updateTimer() {
  const ms = Date.now() - prevTime + seconds;
  const sec = ms / 1000;
  const mins = sec / 60;

  const msText = readableFormat(ms % 1000, 3);
  const secText = readableFormat(Math.floor(sec % 60), 2);
  const minsText = readableFormat(Math.floor(mins), 2);

  timerContent.textContent = `${minsText}:${secText}:${msText}`;

  globalTimer = requestAnimFrame(updateTimer);
}

function readableFormat(num, maxLength) {
  const stringNum = String(num);
  return stringNum.padStart(maxLength, "0");
}

function handleStop() {
  clearInterval(globalTimer);
  seconds += Date.now() - prevTime;

  stopBtn.disabled = true;
  startBtn.disabled = false;
  resetBtn.disabled = false;

  cancelAnimationFrame(globalTimer);
}

function handleReset() {
  resetBtn.disabled = true;
  timerContent.innerText = "00:00:000";
  prevTime = 0;
}
