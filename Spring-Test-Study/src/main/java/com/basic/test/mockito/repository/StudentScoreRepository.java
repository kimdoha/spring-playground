package com.basic.test.mockito.repository;

import com.basic.test.mockito.model.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentScoreRepository extends JpaRepository<StudentScore, Long> {

}
