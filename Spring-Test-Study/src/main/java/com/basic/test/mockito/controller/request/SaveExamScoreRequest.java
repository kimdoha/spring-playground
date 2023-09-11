package com.basic.test.mockito.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveExamScoreRequest {
  private final String studentName;
  private final Integer korScore;
  private final Integer englishScore;
  private final Integer mathScore;
}
