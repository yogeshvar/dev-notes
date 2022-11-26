const slowBtn = document.getElementById("slowBtn");
const helloBtn = document.getElementById("helloBtn");

slowBtn.addEventListener("click", slowClick);
helloBtn.addEventListener("click", helloClick);

function slowClick() {
  const worker = new Worker("/worker.js");
}

function helloClick() {
  console.log("Hello from the other side");
}
