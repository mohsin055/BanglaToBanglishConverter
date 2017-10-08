

import com.ipv.nlp.bangla.phoneticparser.BanglaPhoneticParser;
import static com.ipv.nlp.utils.Utils.getLineArray;
import static com.ipv.nlp.utils.Utils.storeData;

import java.util.ArrayList;


/**
 *
 * @author Mohsin Uddin
 */
public class Test {
    public static void main(String args[]) throws Exception {
    
        BanglaPhoneticParser banglaPhoneticParser = BanglaPhoneticParser.getInstance(); 
        storeData("ouput.txt", "", false);
        ArrayList<String> lines = getLineArray("test.txt");
        for(String line : lines) {
            if(line == null || line.isEmpty()) {
            }
            else {
                String english = banglaPhoneticParser.parse(line);
                storeData("ouput.txt", new StringBuilder().append(english.toLowerCase()).append("\n\n").toString(), true);
             
            }
        }
        
       
        
        
       
    }
    
}
