package com.basic.test.mockito.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExamFailStudentResponse {
  private final String studentName;
  private final Double avgScore;
}
