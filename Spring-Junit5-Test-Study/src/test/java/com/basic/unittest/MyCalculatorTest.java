package com.basic.unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyCalculatorTest {

  @Test
  @DisplayName("MyCalculator 덧셈 테스트")
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
  @DisplayName("MyCalculator 뺄셈 테스트")
  void minusTest() {
    MyCalculator myCalculator = new MyCalculator(10.0);

    myCalculator.minus(5.0);

    Assertions.assertEquals(5.0, myCalculator.getResult());
  }

  @Test
  @DisplayName("MyCalculator 곱셈 테스트")
  void multiplyTest() {
    MyCalculator myCalculator = new MyCalculator(2.0);

    myCalculator.multiply(2.0);

    Assertions.assertEquals(4.0, myCalculator.getResult());
  }

  @Test
  @DisplayName("MyCalculator 나눗셈 테스트")
  void divideTest() {
    MyCalculator myCalculator = new MyCalculator(10.0);

    myCalculator.divide(2.0);

    Assertions.assertEquals(5.0, myCalculator.getResult());
  }

  @Test
  @DisplayName("MyCalculator 사칙연산 테스트")
  void complicatedCalculateTest() {

    // given
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
  @DisplayName("0으로 나누었을 때는 ZeroDivisionException 발생시켜야함")
  void divideZeroTest() {
    // given
    MyCalculator myCalculator = new MyCalculator(10.0);

    // when & then
    Assertions.assertThrows(MyCalculator.ZeroDivisionException.class, () -> {
      myCalculator.divide(0.0);
    });
  }
}