var result = []

let objectProp = Object.getOwnPropertyNames(Array)

console.log({objectProp})

for (let i in objectProp) {
    result.push(objectProp[i])
}

console.log(result);