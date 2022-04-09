class Ninja {
    constructor(name, health) {
        this.name = name;
        this.health = health;
        this.speed = 3;
        this.strength = 3;
    }
    sayName(){
        console.log(this.name);
    }
    showStats(){
        console.log(this.name,this.health,this.speed,this.strength);
    }
    drinkSake() {
        this.health += 10;
        console.log(`You drank Sake and  now your health is ${this.health}.`);
    }
}

class superSensei extends Ninja {
    constructor(name, health=200) {
        super(name,health);
        this.wisdom = 10;
        this.speed = 10;
        this.strength = 10;
    }

    speakWisdom(){
        console.log("What one programmer can do in one month, two programmers can do in two months.");
    }
}

const superNinja1 = new superSensei("Masa");
superNinja1.showStats();
superNinja1.drinkSake();
superNinja1.showStats();
superNinja1.speakWisdom();