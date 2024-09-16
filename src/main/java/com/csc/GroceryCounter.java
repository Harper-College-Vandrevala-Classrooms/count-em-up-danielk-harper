package com.csc;

import java.lang.*;
import java.util.*;

public class GroceryCounter {
  private int[] digits = {0, 0, 0, 0};
  private int overflows = 0;
  
  private void inc_digit(int digit_index) {
    while (true) {
      // if we overflowed the largest digit
      if (digit_index < 0) {
        overflows++;
        return;
      }
      
      digits[digit_index]++;
      
      // if we overflowed
      if (digits[digit_index] > 9) {
        digits[digit_index] = 0;
        digit_index -= 1;
      } else {
        break;
      }
    }
  }
  
  public void hundreths() {
    inc_digit(3);
  }
  public void tenths() {
    inc_digit(2);
  }
  public void ones() {
    inc_digit(1);
  }
  public void tens() {
    inc_digit(0);
  }
  
  public String total() {
    return String.format("$%d.%d%d", digits[0] * 10 + digits[1], digits[2], digits[3]);
  }
  
  public int number_of_overflows() {
    return overflows;
  }
  
  public void clear() {
    for(int i = 0; i <= 3; i++) digits[i] = 0;
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
