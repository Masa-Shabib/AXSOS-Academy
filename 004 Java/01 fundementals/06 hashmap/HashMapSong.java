import java.util.Set;
import java.util.HashMap;
public class HashMapSong {
    public  static  void main( String [] args) {
        HashMap< String , String > trackList =  new  HashMap< String , String>();
        trackList .put( "Title1" , "cfsdssssssssssssssssssssssssss" );
        trackList .put( "Title2" , "cfsdssssssgjjjjjjjjsssss" );
        trackList .put( "Title3" , "cfshgfhgfhhhhhhhhsssssss" );
        trackList .put( "Title4" , "cfsdssddddddddddhjjjjjsssssssssss" );

        Set < String > keys = trackList.keySet();
        for( String key : keys) {
             System .out.println(key);
            System .out.println(trackList.get(key));    
        }
    }
}
