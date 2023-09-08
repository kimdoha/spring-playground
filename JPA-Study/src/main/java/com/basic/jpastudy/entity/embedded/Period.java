package com.basic.jpastudy.entity.embedded;

import jakarta.persistence.Embeddable;
import java.time.ZonedDateTime;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Period {
  private ZonedDateTime startDate;
  private ZonedDateTime endDate;
}
