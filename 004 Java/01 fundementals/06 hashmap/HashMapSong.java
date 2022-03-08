import java.util.Set;
import java.util.HashMap;

public class HashMapSong {
    public  static  void main( String [] args) {
        HashMap< String , String > trackList =  new  HashMap< String , String>();
        trackList .put( "Title1" , "cfsdssssssssssssssssssssssssss" );
        trackList .put( "Title2" , "cfsdssssssgjjjjjjjjsssss" );
        trackList .put( "Title3" , "cfshgfhgfhhhhhhhhsssssss" );
        trackList .put( "Title4" , "cfsdssddddddddddhjjjjjsssssssssss" );
        System .out.println(trackList.get("Title4"));  
        for( String key : trackList.keySet()) {
             System .out.println(key);
            System .out.println(trackList.get(key));    
        }
    }
}
