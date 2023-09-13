package com.basic.test.mockito.service;

import com.basic.test.junit.MyCalculator;
import com.basic.test.mockito.controller.response.ExamFailStudentResponse;
import com.basic.test.mockito.controller.response.ExamPassStudentResponse;
import com.basic.test.mockito.model.StudentFail;
import com.basic.test.mockito.model.StudentPass;
import com.basic.test.mockito.model.StudentScore;
import com.basic.test.mockito.repository.StudentFailRepository;
import com.basic.test.mockito.repository.StudentPassRepository;
import com.basic.test.mockito.repository.StudentScoreRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentScoreService {
  private final StudentScoreRepository studentScoreRepository;
  private final StudentPassRepository studentPassRepository;
  private final StudentFailRepository studentFailRepository;


  public void saveScore(
    String exam,
    String studentName,
    Integer korScore,
    Integer englishScore,
    Integer mathScore
  ) {
    StudentScore studentScore = StudentScore.builder()
        .exam(exam)
        .studentName(studentName)
        .korScore(korScore)
        .englishScore(englishScore)
        .mathScore(mathScore)
        .build();

    studentScoreRepository.save(studentScore);

    MyCalculator calculator = new MyCalculator(0.0);
    Double avgScore = calculator
        .add(korScore.doubleValue())
        .add(englishScore.doubleValue())
        .add(mathScore.doubleValue())
        .divide(3.0)
        .getResult();

    if(avgScore >= 60) {
      StudentPass studentPass = StudentPass.builder()
          .exam(exam)
          .studentName(studentName)
          .avgScore(avgScore)
          .build();

      studentPassRepository.save(studentPass);
    } else {
      StudentFail studentFail = StudentFail.builder()
          .exam(exam)
          .studentName(studentName)
          .avgScore(avgScore)
          .build();

      studentFailRepository.save(studentFail);
    }
  }

  public List<ExamPassStudentResponse> getPassStudentList(String exam) {
    List<StudentPass> studentPasses = studentPassRepository.findAll();

    return studentPasses.stream()
        .filter((pass) -> pass.getExam().equals(exam))
        .map((pass) -> new ExamPassStudentResponse(pass.getStudentName(), pass.getAvgScore()))
        .toList();
  }

  public List<ExamFailStudentResponse> getFailStudentList(String exam) {
    List<StudentFail> studentFails = studentFailRepository.findAll();

    return studentFails.stream()
        .filter((fail) -> fail.getExam().equals(exam))
        .map((fail) -> new ExamFailStudentResponse(fail.getStudentName(), fail.getAvgScore()))
        .toList();
  }
}
