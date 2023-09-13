package com.basic.test.mockito.controller;

import com.basic.test.mockito.controller.request.SaveExamScoreRequest;
import com.basic.test.mockito.controller.response.ExamFailStudentResponse;
import com.basic.test.mockito.controller.response.ExamPassStudentResponse;
import com.basic.test.mockito.service.StudentScoreService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ScoreApi {

  private final StudentScoreService studentScoreService;

  @PutMapping("/exam/{exam}/score")
  public void save(
      @PathVariable String exam,
      @RequestBody SaveExamScoreRequest request
  ) {
    studentScoreService.saveScore(
        exam,
        request.getStudentName(),
        request.getKorScore(),
        request.getEnglishScore(),
        request.getMathScore()
    );
  }


  @GetMapping("/exam/{exam}/pass")
  public List<ExamPassStudentResponse> pass(
      @PathVariable String exam
  ) {
    return studentScoreService.getPassStudentList(exam);
  }

  @GetMapping("/exam/{exam}/fail")
  public List<ExamFailStudentResponse> fail(
      @PathVariable String exam
  ) {
    return studentScoreService.getFailStudentList(exam);
  }
}
