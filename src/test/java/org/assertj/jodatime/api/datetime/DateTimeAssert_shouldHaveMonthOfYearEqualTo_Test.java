/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2018 the original author or authors.
 */
package org.assertj.jodatime.api.datetime;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.jodatime.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class DateTimeAssert_shouldHaveMonthOfYearEqualTo_Test extends DateTimeAssertBaseTest {

  @Test
  public void should_pass_if_month_of_year_are_equal() {
    DateTime dateTime = new DateTime(2018, 4, 6, 10, 27, 33, DateTimeZone.UTC);
    assertThat(dateTime).hasMonthOfYear(4);
  }

  @Test
  public void test_should_fail_if_actual_is_null() {
    expectException(AssertionError.class, actualIsNull());
    DateTime dateTime = null;
    assertThat(dateTime).hasMonthOfYear(2);
  }

  @Test
  public void should_fail_when_minute_of_hours_dont_match() {
    // GIVEN
    DateTime dateTime = new DateTime(2018, 4, 6, 10, 27, 33, DateTimeZone.UTC);
    // WHEN
    Throwable error = catchThrowable(() -> assertThat(dateTime).hasMonthOfYear(12));
    // THEN
    assertThat(error).hasMessage(format("%nExpecting:%n" +
                                        "  <2018-04-06T10:27:33.000Z>%n" +
                                        "month of year to be:%n" +
                                        "  <12>%n" +
                                        "but was:%n" +
                                        "  <4>"));
  }

}
