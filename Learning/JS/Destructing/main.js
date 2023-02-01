const obj = {
    a: 10, 
    b: {
        x: 20, 
        y: 30,
        z: 40
    }
}

const {b: {x, ...rest1}, ...rest2} = obj

console.log(rest1, rest2, x)