

package com.ipv.nlp.bangla.phonetic.utils;

import java.util.List;
import java.util.ArrayList;

public class Pattern implements Comparable<Pattern> {

    private String find;
    private String replace;
    private List<Rule> rules;

    public Pattern() {
        rules = new ArrayList<Rule>();
    }

    public String getFind() {
        return find;
    }

    public void setFind(String find) {
        this.find = find;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    @Override
    public int compareTo(Pattern p) {
        if(this.find.length() < p.getFind().length()) {
            return 1;
        }
        else if(this.find.length() == p.getFind().length()) {
            return this.find.compareTo(p.getFind());
        } else {
            return -1;
        }
    }

}
