function Student() {
    this.name = "Maggie"
    this.gender = "M"
}

var studObj = new Student()

console.log({
    StudentPrototype: Student.prototype,
    studObjPrototype: studObj.prototype,
    studObjProto: studObj.__proto__,
    getPrototypeOf: Object.getPrototypeOf(studObj),
    typeOfStudentPrototype: typeof Student.prototype,
    typeOfStudObjPrototype: typeof studObj.__proto__,
    checkProto: Student.prototype == studObj.__proto__
});

class Animal {
    constructor(name, energy) {
        this.name = name
        this.energy = energy
    }
    eat(amount) {
        this.energy += amount
    }
    sleep() {
        this.energy += length
    }
    play() {
        this.energy -= length
    }
}

const shilpa = new Animal('shilpa', 10)

class Cat extends Animal {
    constructor(name, energy, breed) {
        super(name, energy)
        this.breed = breed
    }
    meow() {
        console.log('Meoww! Meoww!');
        this.energy -= .1
    }
}
