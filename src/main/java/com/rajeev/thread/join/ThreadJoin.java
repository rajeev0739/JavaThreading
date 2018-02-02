package com.rajeev.thread.join;


import java.util.*;
public class ThreadJoin {
    protected static Thread mainThread = Thread.currentThread();;

    public static void main(String args[]) {
        System.out.println("Calculating primes: ");
        System.out.println("Main thread state: " + ThreadJoin.mainThread.getState());
        try {
            for (long x = 6223372036854775799L; x <= 6223372036854775999L; x+=2) {
                new MyCalculations(x).join();
                System.out.println("Inside Main Method For Loop, Main thread state = " + ThreadJoin.mainThread.getState());
                System.out.println("Active threads: " + Thread.activeCount());
                System.out.println("\n-------------------\n");
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Ending main method.");
    }
}

class MyCalculations extends Thread {
    private long numberToFactor = 0;

    MyCalculations(long numberToFactor){
        this.numberToFactor = numberToFactor;
        System.out.println("MyCalculations constructor, before start(), state = " + this.getState());
        start();
        System.out.println("MyCalculations constructor, after start(), state = " + this.getState());
    }

    @Override
    public void run() { // this is where the new thread starts
        isItPrime(numberToFactor);
        System.out.println("Inside MyCalculations run(), Main thread state = " + ThreadJoin.mainThread.getState());
    }

    void isItPrime(long numberToFactor) { 
        if (numberToFactor % 2 == 0) {
            System.out.println(numberToFactor + " is NOT Prime ... divisible by 2");
            return;
        }

        long squareRoot = (long) Math.sqrt(numberToFactor);
        for (long i = 3; i <= squareRoot; i+=2) {
            if (numberToFactor % i == 0) { // when the remainder is 0 the number is evenly divisible - hence not prime
                System.out.println(numberToFactor + " is NOT Prime ... first divisible by " + i);
                return;
            }
        }
        System.out.println(numberToFactor + " is Prime!!!");
    }
}