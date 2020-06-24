package io.amitk;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

/*
Problem: Find corresponding closing parenthesis for a given string and position of open parenthesis.
 */
public class ParanthesisPositionSolution {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ParanthesisPositionSolution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

    private static int getClosingParen(String input, int position) {
        int openParanCount=0;
        for(int i =position+1; i<input.length(); i++){
            if(input.charAt(i)=='('){
                openParanCount++;
            }else if(input.charAt(i)==')'){
                if(openParanCount==0){
                    return i;
                }else{
                    openParanCount--;
                }
            }
        }
        throw new IllegalArgumentException("No corresponding closing paranthesis found!");
    }

    // tests

    @Test
    public void allOpenersThenClosersTest() {
        final int expected = 8;
        final int actual = getClosingParen("((((()))))", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void mixedOpenersAndClosersTest() {
        final int expected = 10;
        final int actual = getClosingParen("()()((()()))", 5);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void noMatchingCloserTest() {
        getClosingParen("()(()", 2);
    }

}
