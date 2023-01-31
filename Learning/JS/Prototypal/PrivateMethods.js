function Person(n, y) {
    let _name = n
    let _year = y
    var thisObj = this 
    this.setName = (n) => _name = n
    this.getName = () => _name
    this.getYear = () => _year
    this.setYear = (y) => _year = y
    var born = () => {
        var nYear = new Date().getFullYear()
        return nYear - thisObj.getYear() // can't use this.getYear()
    }
    this.getBornYear = () => born()
}

var person = new Person('Yogi', 24)
console.log({
    getName: person.getName(),
    setNameAndgetName: person.setName('Maggi') && person.getName(),
    born: person.born,
    getBornYear: person.getBornYear()
})