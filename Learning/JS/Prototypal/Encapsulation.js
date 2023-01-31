function Person(name, age) {
    let _name = name
    let _age = age

    let getDetails_noAccess = function() {
        return `Name: ${_name} & Age: ${_age}`
    }

    this.getDetails_access = function() {
        return `Name: ${_name} & Age: ${_age}`       
    }
}

let person = new Person('Yogi', '24')

console.log({
    nameVariable: person._name,
    getDetails_noAccess: person.getDetails_noAccess,
    details: person.getDetails_access()
})