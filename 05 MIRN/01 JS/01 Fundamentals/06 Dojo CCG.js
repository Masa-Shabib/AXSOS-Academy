class Card {
    constructor(name, cost) {
        this.name = name;
        this.cost = cost;
    }
}

class Unit extends Card{
    constructor(name, cost,power,res) {
        super(name,cost);
        this.power = power;
        this.res = res;
    }

    showStats(){
        console.log(this.name,",cost:",this.cost,",power:",this.power,",resilience:",this.res);
    }

    attack(target){
        if( target instanceof Unit ) {
            target.res-= this.power
        } else {
            throw new Error( "Target must be a unit!" );
        }
    }
}


class Effect extends Card{
    constructor(name, cost,text,stat,magn) {
        super(name,cost);
        this.text = text;
        this.stat = stat;
        this.magn = magn;
    }

    showStats(){
        console.log(this.name,",cost:",this.cost,",text:",this.text,",stat:",this.stat,",magn:",this.magn);
    }

    play( target ) {
        if( target instanceof Unit ) {
            if (this.stat ==="resilience"){
                target.res+= this.magn;
            }else{
                target.power+= this.magn;
            }
        } else {
            throw new Error( "Target must be a unit!" );
        }
    }
}

const card1 = new Unit("Red Belt Ninja",3,3,4);
card1.showStats();
const card2 = new Unit("Black Belt Ninja",4,5,4);
card2.showStats();
const effect1 = new Effect("Hard Algorithm",2,"	increase target's resilience by 3","resilience",+3);
effect1.showStats();
const effect2 = new Effect("Unhandled Promise Rejection",1,"reduce target's resilience by 2","resilience",-2);
effect2.showStats();
const effect3 = new Effect("Pair Programming",3,"increase target's power by 2","resilience",+2);


effect3.showStats();
effect1.play(card1);
effect2.play(card1);
effect3.play(card1);
card1.showStats();
card2.attack(card1);
card1.showStats();
