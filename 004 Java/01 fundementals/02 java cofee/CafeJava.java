public class CafeJava {
    public  static  void main( String [] args) {
        // APP VARIABLES 
       // Lines of text that will appear in the app 
        String greetGeneral =  "Welcome to Cafe Java, " ;
        String MensajePendiente =  ", your order will be ready shortly" ;
        String MessagingReady =  ", your order is ready" ;
        String MensajeMostrarTotal =  "Your total is $" ;
        String Wrong =  "what you owe is" ;

       // Menu variables (add yours below) 
        double MochaPrice =  3.5 ;
        double CoffeePrice =  4.5 ;
        double LattePrice =  7.5 ;
        double CappuccinoPrice =  1.5 ;

       // Client name variables (add yours below) 
        String client1 =  "Cindhuri" ;
        String client2 =  "Sam" ;
        String client3 =  "Jimmy" ;
        String client4 =  "Noah" ;

       // Order completions (add yours below) 
        boolean isOrderReady1 =  false ;
        boolean isOrderReady2 =  false ;
        boolean isOrderReady3 =  true ;
        boolean isOrderReady4 =  false;
       // SIMULATION OF APP INTERACTION(Add your code for the challenges below) 
       // Example: 
        // Displays "Welcome to Café Java, Cindhuri" 
       // ** Print statements about customer interactions will go here ** //
       if(isOrderReady1 ) {
        System .out.println(greetGeneral + client1 + MessagingReady);
        System .out.println(MensajeMostrarTotal + CoffeePrice);
    }
    else if (isOrderReady4 ){
        System .out.println(greetGeneral + client4 + MessagingReady);
        System .out.println(MensajeMostrarTotal+CappuccinoPrice);
    }
    else if (isOrderReady2){
        System .out.println(greetGeneral + client2 + MessagingReady);
        System .out.println(MensajeMostrarTotal+(LattePrice*LattePrice));
    }
    else if (isOrderReady3){
        System .out.println(greetGeneral + client3 + Wrong+ (LattePrice-CoffeePrice));
    }
    else {
        System.out.println(MensajePendiente);
    }
   }
}
