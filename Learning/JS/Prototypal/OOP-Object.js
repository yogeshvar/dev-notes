// Ubiquitous Object Literal
var obj = {
    name: 'Yogi',
    city: 'Disneyland',
    loves: 'Loaded fries'
}

// Prototype Pattern
function myFunction() {
    myFunction.prototype.name = 'Yogi'
    myFunction.prototype.city = 'Disneyland'
}
var myFunction1 = new myFunction()
console.log(myFunction1.name)

// Constructor Pattern
function myFunc(name,city,loves) {
    this.name = name
    this.city = city
    this.loves = loves
}
var myFunc1 = new myFunc("Yogi", "Disneyland", "Loaded Fries")
console.log(myFunc1.name)

// Constructor Function
function Person(name) {
    this.name = name
    this.greet = function() {
        console.log('Hello, I\'m' + this.name);
    }
}

var person = new Person('Yogi')

function PersonObj() {
    var name = 'Yogi'
    var height = 183
    var weight = 76
    this.haircolor = 'Black'
    this.setHairColor = (newColor) => this.haircolor = newColor
    this.getHairColor = () => this.haircolor
    this.setHeight = (newHeight) => height = newHeight
    this.getHeight = () => height
    this.setWeight = (newWeight) => weight = newWeight
    this.getWeight = () => weight
    this.setName = (newName) => name = newName
    this.getName = () => name
}

var aPerson = new PersonObj()
console.log(aPerson.name) // not accessible if it's variable
console.log(aPerson.haircolor) // this is accessible with the object
console.log(aPerson.getName())
aPerson.setName('Maggie')
console.log(aPerson.getName())