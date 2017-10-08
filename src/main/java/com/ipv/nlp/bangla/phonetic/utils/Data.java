
package com.ipv.nlp.bangla.phonetic.utils;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Pattern> patterns;
    private String vowel = "";
    private String consonant = "";
    private String casesensitive = "";

    public Data() {
        this.patterns = new ArrayList<Pattern>();
    }

    public List<Pattern> getPatterns() {
        return patterns;
    }

    public void addPattern(Pattern pattern) {
        this.patterns.add(pattern);
    }

    public String getVowel() {
        return vowel;
    }

    public void setVowel(String vowel) {
        this.vowel = vowel;
    }

    public String getConsonant() {
        return consonant;
    }

    public void setConsonant(String consonant) {
        this.consonant = consonant;
    }

    public String getCasesensitive() {
        return casesensitive;
    }

    public void setCasesensitive(String casesensitive) {
        this.casesensitive = casesensitive;
    }

}
