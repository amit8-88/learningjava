package io.amitk;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;
/*
Given following three values, the task is to find the total number of maximum chocolates you can eat.

money : Money you have to buy chocolates
price : Price of a chocolate
wrap : Number of wrappers to be returned for getting one extra chocolate.
It may be assumed that all given values are positive integers and greater than 1.

 */
public class ChocolateCounterSolution {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ChocolateCounterSolution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

    private int getMaxChocolate(int money, int price, int wrap) {
        int chocolatesWithoutExchange= money/price;


        return chocolatesWithoutExchange+getExchange(chocolatesWithoutExchange , wrap);
    }

    private int getExchange(int chocolateCount, int wrap){
        if(chocolateCount<wrap){
        return 0;
        }
        int newChoc=chocolateCount/wrap;
        return newChoc+getExchange(newChoc+chocolateCount%wrap, wrap);
    }

    // tests
    @Test
    public void getMaxChocolateTest1() {
        final int expected = 15;
        int money = 16; //total money
        int price = 2; //unit price of a chocolate
        int wrap = 2; // number of wrappers needed for exchange with 1 chocolate
        final int actual = getMaxChocolate(money, price, wrap);
        assertEquals(expected, actual);
    }

    public void getMaxChocolateTest2() {
        final int expected = 22;
        int money = 15; //total money
        int price = 1; //unit price of a chocolate
        int wrap = 3; // number of wrappers needed for exchange with 1 chocolate
        final int actual = getMaxChocolate(money, price, wrap);
        assertEquals(expected, actual);
    }

    public void getMaxChocolateTest3() {
        final int expected = 7;
        int money = 20; //total money
        int price = 3; //unit price of a chocolate
        int wrap = 5; // number of wrappers needed for exchange with 1 chocolate
        final int actual = getMaxChocolate(money, price, wrap);
        assertEquals(expected, actual);
    }

}
