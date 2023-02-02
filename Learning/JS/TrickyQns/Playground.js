var x = 3
console.log(Number instanceof Number)

console.log(42..toString());
console.log(4.3.toString());
console.log(1 in [1,2]);
console.log(parseInt('i', 19));

const obj = {
    prop1: 1,
    nestedObj: {
        nestedProp1: 1,
        nestedProp2: 2
    }
}

const frozen = Object.freeze(obj)
const nestedFrozen = Object.freeze(obj.nestedObj)

frozen.prop1 = 4;
console.log(obj)

obj.nestedObj.nestedProp1 = 2
console.log({ obj })
