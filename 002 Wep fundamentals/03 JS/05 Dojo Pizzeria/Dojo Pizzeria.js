function pizzaOven(crustType, sauceType, cheese, toppings) {
    var pizza = {};
    pizza.crustType= crustType;
    pizza.sauceType = sauceType;
    pizza.cheese = cheese;
    pizza.toppings = toppings;
    return pizza;
}
    

console.log( pizzaOven("deep dish", "traditional", ["mozzarella"], ["pepperoni", "sausage"]));
console.log(pizzaOven("hand tossed", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]));
console.log( pizzaOven("thin", "meyo", "mozzarella","mushrooms"));

var crustType =[
    "deep dish",
    "hand tossed",
    "thin",
    "gluten free"
]
var sauceType =[
    "traditional",
    "marinara",
    "bbq",
    "meyo"
];
var cheese =[
    "mozzarella",
    "cheddar",
    "feta",
    "swiss cheese",
    "parmesan"
];
var toppings =[
    "pepperoni",
    "sausage",
    "corn",
    "bell peppers",
    "mushrooms"
];

function randomPizza() {
    var pizza = {};
    pizza.crustType = crustType [Math.floor(crustType.length * Math.random())];
    pizza.sauceType = sauceType [Math.floor(sauceType.length * Math.random())] ;
    pizza.cheeses = [];
    pizza.toppings = [];
    for(var i=0; i<3; i++) {
        pizza.cheeses.push(cheese [Math.floor(cheese.length * Math.random())]);
    }
    for(var i=0; i<3; i++) {
        pizza.toppings.push(toppings [Math.floor(toppings.length * Math.random())]);
    }
    return pizza;
}

console.log(randomPizza());