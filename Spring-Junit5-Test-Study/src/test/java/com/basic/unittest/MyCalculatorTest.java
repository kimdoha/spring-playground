package com.basic.unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyCalculatorTest {

  @Test
  void addTest() {
    // AAA 패턴

    // Arrange - 준비
    MyCalculator myCalculator = new MyCalculator();

    // Act - 행동
    myCalculator.add(10.0);

    // Assert - 단언/검증
    Assertions.assertEquals(10.0, myCalculator.getResult());
  }

  @Test
  void minusTest() {
    MyCalculator myCalculator = new MyCalculator(10.0);

    myCalculator.minus(5.0);

    Assertions.assertEquals(5.0, myCalculator.getResult());
  }

  @Test
  void multiplyTest() {
    MyCalculator myCalculator = new MyCalculator(2.0);

    myCalculator.multiply(2.0);

    Assertions.assertEquals(4.0, myCalculator.getResult());
  }

  @Test
  void divideTest() {
    MyCalculator myCalculator = new MyCalculator(10.0);

    myCalculator.divide(2.0);

    Assertions.assertEquals(5.0, myCalculator.getResult());
  }

  @Test
  void complicatedCalculateTest() {

    // givin
    MyCalculator myCalculator = new MyCalculator(0.0);

    // when
    Double result = myCalculator
        .add(10.0)
        .minus(4.0)
        .multiply(2.0)
        .divide(3.0)
        .getResult();

    // then
    Assertions.assertEquals(4.0, result);
  }


  @Test
  void divideZeroTest() {
    // given
    MyCalculator myCalculator = new MyCalculator(10.0);

    // when & then
    Assertions.assertThrows(MyCalculator.ZeroDivisionException.class, () -> {
      myCalculator.divide(0.0);
    });
  }
}