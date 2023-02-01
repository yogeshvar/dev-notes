function memo(fn) {
    const cache = {}
    return function() {
        const args = JSON.stringify(arguments)
        console.log({ args })
        if (cache[args]) return cache[args]
        const evalVal = fn.call(this, arguments[0])
        cache[args] = evalVal
        console.log({ cache })
        return evalVal
    }
}
function factorial(n) {
    if (n === 0 || n === 1) return 1
    return factorial(n - 1) * n
}

const memoFact = memo(factorial)
x = memoFact(10)
console.log(x)