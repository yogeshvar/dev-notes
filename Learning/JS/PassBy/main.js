// 1
var obj = {
  price: 10,
  get_price: function () {
    return this.price;
  },
};

var customObj = Object.create(obj);
customObj.price = 20;
delete customObj.price;
console.log(customObj.get_price()); // 10

// 2
(function (a) {
  arguments[0] = 10;
  return a; // 10
})(5);

// 3
function Car(color) {
  this.color = color;
}
var lada = new Car("Black");
Car.prototype.currentGear = 1;
console.log(++lada.currentGear); // 2
console.log(Car.prototype.currentGear); // 1

// 4
var User = function () {};
User.prototype.attributes = {
  isAdmin: true,
};
var admin = new User("Yogi");
var guest = new User("Mags");
admin.attributes.isAdmin = false;
console.log({
  admin: admin.attributes.isAdmin, // false
  guest: guest.attributes.isAdmin, // false
});

// 5
var obj = {
  a: 1,
};
(function (obj) {
  obj = {
    a: 2,
  };
})(obj);
console.log(obj.a);

// 6
var foo = { n: 1 };
var bar = foo;
foo.x = foo = { n: 2 };
console.log(foo); // { n : 2 }

// 7
function Person(name) {
  if (name) this.options.name = name;
}
Person.prototype.options = {
  name: "Default",
};
var foo = new Person("Foo");
var bar = new Person("Bar");
console.log(foo.options.name); // Bar
console.log(bar.options.name); // Bar

// 7.1
function Person1(name) {
  this.options = {
    name: name || "Default",
  };
}

var foo = new Person1("Foo");
var bar = new Person1("Bar");
console.log(foo.options.name); // Foo
console.log(bar.options.name); // Bar

// 8
var a = {};
(function b(a) {
  console.log(a);
  a.a = 10;
  a = null;
})(a);
console.log(a); // { a: 10 }
