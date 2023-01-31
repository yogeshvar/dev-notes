function init() {
    var name = 'Yogi'
    function displayName() {
        console.log(name);
    }
    displayName()
}

var awFunc = function(first) {
    var someFunc = function(second) {
        return first + second
    }
    return someFunc
}

var someMoreFun = awFunc('awe')
console.log(someMoreFun('some'))

const arr = [10,12,15,21]

for (let i = 0; i < arr.length; i++) {
    setTimeout(() => {
        console.log(arr[i]);
    }, 1000)
}

for(var i = 0; i < arr.length; i++) {
    setTimeout(
        (function(i_local) {
            return function() {
                console.log(arr[i_local]);
            }
        })(i), 1000
    )
}


function outer() {
    var b = 10
    function inner() {
        var a = 20
        console.log(a + b)
    }
    return inner
}

var X = outer()
console.log(typeof X);
console.log(X())

var a = 0.1.toPrecision()
var b = 0.2.toPrecision()
var c = Number(a) + Number(b)
console.log(Number(a) + Number(b) === c)