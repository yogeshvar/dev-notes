const array = [1, 2, 3];

Array.prototype.myMultiply = function(callback) {
    let array = [];
    for (let i = 0; i < this.length; i++) {
        array.push(this[i] ** 2)
    }
    return [...this, ...array]
}

Array.prototype.myMap = function (callback) {
  let array = [];
  for (let i = 0; i < this.length; i++) {
    array.push(callback(this[i], i, this));
  }
  return array;
};

Array.prototype.myReduce = function (callback, initValue) {
  let output = initValue;
  for (let i = 0; i < this.length; i++) {
    if (i == 0 && initValue === undefined) {
      output = this[i];
    } else {
      output = callback(output, this[i], i, this);
    }
  }
  return output;
};

Array.prototype.myFilter = function (callback) {
  let array = [];
  console.log(this);
  for (let i = 0; i < this.length; i++) {
    if (callback(this[i], i, this) === true) {
      array.push(this[i]);
    }
  }
  return array;
};

const mappedArray = array.myMap((value, i, arr) => {
  return value + i + arr[1];
});

console.log({ mappedArray });

const filteredArray = array.myFilter((value, i, arr) => {
  return value + i + arr[1] > 5;
});

console.log({ filteredArray });

const reducedValue = array.myReduce((acc, val, i, arr) => {
    return acc + val + i + arr[1]
}, 3)

console.log({ reducedValue })

const multiplyArray = array.myMultiply()

console.log({ multiplyArray })