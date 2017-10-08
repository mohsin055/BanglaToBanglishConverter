
package com.ipv.nlp.bangla.phoneticparser;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.ipv.nlp.bangla.phonetic.utils.NoPhoneticLoaderException;
import com.ipv.nlp.bangla.phonetic.utils.Pattern;
import com.ipv.nlp.bangla.phonetic.utils.Data;
import java.util.HashMap;

/**
 * 
 * @author Mohsin Uddin
 */
public class BanglaPhoneticParser {

    private static volatile BanglaPhoneticParser instance = null;
    private static PhoneticLoader loader = null;
    private static List<Pattern> patterns;
    private static HashMap<String, Pattern> patternMap;
    private static int maxPatternLength = 0;

    // Prevent initialization
    private BanglaPhoneticParser() throws Exception {
        patterns = new ArrayList<>();
        patternMap = new HashMap<>();
        BanglaPhoneticParser.loader = new PhoneticXmlLoader("","");
        if(loader == null) {
            throw new NoPhoneticLoaderException();
        }
        Data data = loader.getData();
        patterns = data.getPatterns();
        Collections.sort(patterns);
        for(Pattern pattern: patterns) {
            patternMap.put(pattern.getFind(), pattern);
        }
        maxPatternLength = patterns.get(0).getFind().length();
        //System.out.println("max pattern length "+maxPatternLength);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static BanglaPhoneticParser getInstance() throws Exception {
        BanglaPhoneticParser phoneticParser = BanglaPhoneticParser.instance;
        if(phoneticParser == null) {
            synchronized (BanglaPhoneticParser.class) {
                phoneticParser = BanglaPhoneticParser.instance;
                if(phoneticParser == null) {
                    BanglaPhoneticParser.instance = phoneticParser = new BanglaPhoneticParser();
                }
            }
        }
        return phoneticParser;
    }
    
    public String parse(String input) {
        String text = input;
        String output = "";
        for(int cur = 0; cur < text.length(); ++cur) {
            int start = cur, end;

            boolean matched = false;
            int len;
            for(len = maxPatternLength; len > 0; --len) {
                end = start + len;
                if(end <= text.length()) {
                    String chunk = text.substring(start, end);
                    //System.out.println("chunk "+chunk);
                    Pattern pattern = getMatchedPattern(chunk);
                    if(pattern == null ) {
                        //System.out.println("Pattern = NULL");
                    }
                    else {
                        output += pattern.getReplace();
                        cur = end - 1;
                        //System.out.println("Default...  Output=> "+output+" cur: "+cur+" pattern.getReplace "+pattern.getReplace());
                        matched = true;
                        break;
                    } 
                    if(matched == true) break;
                }
            }
            if(!matched) {
                output += text.charAt(cur);
                //System.out.println("Not matched (no change. same char will be appended) ..  output:  "+output);
            }
             
        }
        return output;
    }
    
    private Pattern getMatchedPattern (String chunk) {
       Pattern pattern = patternMap.get(chunk);
       return pattern;
    }
 

}