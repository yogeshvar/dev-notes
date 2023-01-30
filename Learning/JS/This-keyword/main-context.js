function foo() { 
    console.log(this)
}


var obj = { bar: foo }
obj.bar()

function boo() {
    "use strict"
    console.log(this)
}

boo()
