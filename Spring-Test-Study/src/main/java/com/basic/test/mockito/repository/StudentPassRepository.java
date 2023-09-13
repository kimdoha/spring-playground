package com.basic.test.mockito.repository;

import com.basic.test.mockito.model.StudentPass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentPassRepository extends JpaRepository<StudentPass, Long> {

}
