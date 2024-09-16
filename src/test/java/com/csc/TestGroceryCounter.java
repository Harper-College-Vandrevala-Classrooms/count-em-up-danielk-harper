package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

  GroceryCounter c;

  @BeforeEach
  void setUp() {
    c = new GroceryCounter();
  }
  
  @Test
  void testDigits() {
    c.hundreths();
    c.tenths();
    c.ones();
    c.tens();
    assertEquals("$11.11", c.total());
    assertEquals(0, c.number_of_overflows());
  }
  
  @Test
  void testOverflowHundreths() {
    assertEquals("$0.00", c.total());
    assertEquals(0, c.number_of_overflows());
    
    for (int i = 0; i < 11; i++) {
      c.hundreths();
    }
    
    assertEquals("$0.11", c.total());
    assertEquals(0, c.number_of_overflows());
  }
  
  @Test
  void testOverflowTenths() {
    assertEquals("$0.00", c.total());
    assertEquals(0, c.number_of_overflows());
    
    for (int i = 0; i < 11; i++) {
      c.tenths();
    }
    
    assertEquals("$1.10", c.total());
    assertEquals(0, c.number_of_overflows());
  }
  
  
  @Test
  void testOverflowOnes() {
    assertEquals("$0.00", c.total());
    assertEquals(0, c.number_of_overflows());
    
    for (int i = 0; i < 11; i++) {
      c.ones();
    }
    
    assertEquals("$11.00", c.total());
    assertEquals(0, c.number_of_overflows());
  }
  
  @Test
  void testOverflowTens() {
    assertEquals("$0.00", c.total());
    assertEquals(0, c.number_of_overflows());
    
    for (int i = 0; i < 11; i++) {
      c.tens();
    }
    
    assertEquals("$10.00", c.total());
    assertEquals(1, c.number_of_overflows());
  }
  
  
  @Test
  void testClear() {
    assertEquals("$0.00", c.total());
    assertEquals(0, c.number_of_overflows());
    
    for (int i = 0; i < 11; i++) {
      c.tens();
    }
    
    assertEquals("$10.00", c.total());
    assertEquals(1, c.number_of_overflows());
    
    c.clear();
    
    assertEquals("$0.00", c.total());
    assertEquals(0, c.number_of_overflows());
  }
  
  @Test
  void testInitialization() {
    assertEquals("$0.00", c.total());
    assertEquals(0, c.number_of_overflows());
  }
  
}
