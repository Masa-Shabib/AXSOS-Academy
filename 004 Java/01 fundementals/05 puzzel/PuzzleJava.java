import java.util.ArrayList;
import java.util.Random;
public class PuzzleJava {

    public  ArrayList<Integer> getTenRolls(){
        Random randMachine =  new Random();
        ArrayList<Integer> random = new ArrayList<Integer>();
        for (int i=0 ;i < 10; i++){
            int x = randMachine.nextInt(20 - 1) + 1;
            random.add(x);
        }
    return random;
    }

    public  char getRandomLetter(){
        Random randMachine =  new Random();
        Character[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
         'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int x = randMachine.nextInt(25 - 1) + 1;
        char random = alphabet[x];
    return random;
    }

    public  String generatePassword(){
        Random randMachine =  new Random();
        Character[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
         'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
         String password ="" ;
         for (int i=0 ;i < 8; i++){
             int x = randMachine.nextInt(25 - 1) + 1;
             char random = alphabet[x];
             password += random;
        }
    return password;
    }

    public  ArrayList<String> getNewPasswordSet(int x){
        ArrayList <String> randomPasswords = new ArrayList <String>(); 
        for (int i=0 ;i < x; i++){
            randomPasswords.add(generatePassword());
        }
        return randomPasswords;
    }
}
