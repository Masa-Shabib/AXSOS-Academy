function pizzaOven(crustType, sauceType, cheese, toppings) {
    var pizza = {};
    pizza.crustType= crustType;
    pizza.sauceType = sauceType;
    pizza.cheese = cheese;
    pizza.toppings = toppings;
    return pizza;
}
    
var p1 = pizzaOven("deep dish", "traditional", ["mozzarella"], ["pepperoni", "sausage"]);
console.log(p1);
var p2 = pizzaOven("hand tossed", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]);
console.log(p2);
var p3 = pizzaOven("hand tossed", "marinara", "mozzarella","mushrooms");
console.log(p3);

var crustType ={
}
var sauceType ={
}
