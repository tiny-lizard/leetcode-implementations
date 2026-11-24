package com.similarstrings;

import java.util.Collection;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String w1 = "aaabbbbccddeeeeefffff";
        String w2 = "aaaaabbcccdddeeeeffff";
        System.out.println(CompareStrings(w1,w2));
        System.out.println( "Run completed." );
    }

    public static Boolean CompareStrings(String word1, String word2)
    {
        char tokenizedWord1[], tokenizedWord2[];
        HashMap<Character, Integer> w1Frequency;
        HashMap<Character, Integer> w2Frequency;

        Collection<Integer> w1Values;
        Collection<Integer> w2Values;
        

        //Check if string lengths are equal
        if (word1.length() == word2.length())
        {
            tokenizedWord1= new char[word1.length()];

            //Tokenize word1 and word2 into a character array
            tokenizedWord1 = word1.toCharArray();
            tokenizedWord2 = word2.toCharArray();
            
            //Operation 1: Check if letters in word1 exist in word2. If a letter does not exist in word2, return false.
            for (char c : tokenizedWord1)
            {
                if (word2.indexOf(c) == -1)
                {
                    return false;
                }
            }

            //Operation 2: Check if the frequencies of letters in word1 match the frequencies of letters in word2.
            // If frequencies do not match, return false.
            w1Frequency = new HashMap<Character, Integer>();
            for (char c : tokenizedWord1)
            {
                if (w1Frequency.containsKey(c))
                {
                    w1Frequency.put(c,w1Frequency.get(c) + 1);
                }
                else
                    w1Frequency.put(c,1);
            }

            w2Frequency = new HashMap<Character, Integer>();
            for (char c: tokenizedWord2)
            {
                if (w2Frequency.containsKey(c))
                {
                    w2Frequency.put(c,w2Frequency.get(c) + 1);
                }
                else
                    w2Frequency.put(c,1);
            }

            //Check whether the frequencies in word 1 exist in word 2
            w1Values = w1Frequency.values();
            w2Values = w2Frequency.values();
            //Check whether the frequencies in word 2 exist in word 1
            for (Integer i : w1Values)
            {
                if(w2Values.contains(i))
                {
                    w2Values.remove(i);
                }
            }

            if(w2Values.size() > 0)
                return false;
            else
                return true;
        }
            return false;

    }
}