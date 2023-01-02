const getValBtn = document.getElementById("getVal");
const addValBtn = document.getElementById("addVal");

getValBtn.addEventListener("click", getValues);
addValBtn.addEventListener("click", addValues);

function getValues() {
  const indexDB = indexedDB.open("testDB", 1);
  indexDB.addEventListener("success", (event) => {
    const db = event.target.result;
    const users = db
      .transaction(["testUsers"], "readonly")
      .objectStore("testUsers")
      .getAll();
    users.addEventListener("success", (event) => {
      console.log(event.target.result);
    });
  });
}

function addValues() {
  const indexDB = indexedDB.open("testDB", 1);
  indexDB.addEventListener("upgradeneeded", (event) => {
    const db = event.target.result;
    const store = db.createObjectStore("testUsers", { keyPath: "id" });
    store.createIndex("name", "name");
    store.add({
      id: 0,
      name: "Yogi",
    });
    store.add({
      id: 1,
      name: "Bogi",
    });
  });
}
