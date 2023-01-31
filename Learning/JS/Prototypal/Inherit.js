function ParentClass(foo) {
    this.foo = foo
}

ParentClass.prototype = {
    bar: function(_from) {
        console.log('Calling from '  + _from + ' Hello from ParentClass');
    }
}

function ChildClass() {}

ChildClass.prototype = new ParentClass()

ChildClass.prototype.constructor = ChildClass;

ChildClass.prototype.super = ParentClass.prototype

ChildClass.prototype.bar = function(_from) {
    this.super.bar.call(this, _from)
    console.log('Hello from ChildClass')
}

var p = new ParentClass()
var c = new ChildClass()

p.bar('parent class')
// console.log(p.bar())
c.bar('child class');