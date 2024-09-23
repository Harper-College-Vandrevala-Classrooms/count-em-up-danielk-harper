package com.csc;

import java.lang.*;
import java.util.*;

public class GroceryCounter {
  private int counter = 0;
  private int overflow_value = 9999;
  private int overflows = 0;
  
  public GroceryCounter() {}
  
  public GroceryCounter(int starting_value, int max_value) throws IllegalArgumentException {
    if (starting_value > 9999 || starting_value < 0) throw new IllegalArgumentException("Starting value must be between 9999 and 0 inclusive.");
    counter = starting_value;
    overflow_value = max_value;
  }
  
  private void add_value(int value) {
    counter += value;
    if (counter > overflow_value) {
      counter = counter % (overflow_value + 1);
      overflows += 1;
    }
  }
  
  private void sub_value(int value) {
    if (value > counter) {
      value -= counter + 1;
      counter = overflow_value;
      counter -= value;
      
      overflows += 1;
    } else {
      counter -= value;
    }
  }
  
  public void increment(int value) {
    add_value(value);
  }
  
  public void hundreths() {
    add_value(1);
  }
  public void tenths() {
    add_value(10);
  }
  public void ones() {
    add_value(100);
  }
  public void tens() {
    add_value(1000);
  }
  
  public void decrementHundreths() {
    sub_value(1);
  }
  public void decrementTenths() {
    sub_value(10);
  }
  public void decrementOnes() {
    sub_value(100);
  }
  public void decrementTens() {
    sub_value(1000);
  }
  
  public String total() {
    String dollars;
    String cents;
    
    dollars = String.format("%d", counter / 100);
    
    if (counter % 100 < 10) {
      cents = String.format("0%d", counter % 100);
    } else {
      cents = String.format("%d", counter % 100);
    }
    
    return "$" + dollars + "." + cents;
  }
  
  public int number_of_overflows() {
    return overflows;
  }
  
  public void clear() {
    counter = 0;
    overflows = 0;
  }
  
  public static void main(String[] args) {
    GroceryCounter counter = new GroceryCounter();

    System.out.println(counter.total()); // This would print out $0.00

    counter.tens();
    counter.tens();
    counter.hundreths();

    System.out.println(counter.total()); // This would print out $20.01
    System.out.println(counter.number_of_overflows()); // This would print out 0

    for(int i = 0; i < 35; i++) {
      counter.ones();
    }

    System.out.println(counter.total()); // This would print out $55.01
    System.out.println(counter.number_of_overflows()); // This would print out 0

    for(int i = 0; i < 100; i++) {
      counter.ones();
    }

    System.out.println(counter.total()); // This would print out $55.01
    System.out.println(counter.number_of_overflows()); // This would print out 1

    counter.clear();

    System.out.println(counter.total()); // This would print out $0.00
    System.out.println(counter.number_of_overflows()); // This would print out 0

  }
}
