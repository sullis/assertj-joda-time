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
package org.assertj.jodatime.api.localdatetime;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.jodatime.api.Assertions.assertThat;

import org.joda.time.LocalDateTime;
import org.junit.Test;

public class LocalDateTimeAssert_shouldHaveSecondOfMinuteEqualTo_Test extends LocalDateTimeAssertBaseTest {

  @Test
  public void should_pass_if_second_of_minute_are_equal() {
    LocalDateTime localDateTime = new LocalDateTime(2018, 4, 6, 10, 27, 33);
    assertThat(localDateTime).hasSecondOfMinute(33);
  }

  @Test
  public void test_should_fail_if_actual_is_null() {
    expectException(AssertionError.class, actualIsNull());
    LocalDateTime localDateTime = null;
    assertThat(localDateTime).hasSecondOfMinute(2);
  }

  @Test
  public void should_fail_when_second_of_minute_dont_match() {
    // GIVEN
    LocalDateTime localDateTime = new LocalDateTime(2018, 4, 6, 10, 27, 33, 1);
    // WHEN
    Throwable error = catchThrowable(() -> assertThat(localDateTime).hasSecondOfMinute(44));
    // THEN
    assertThat(error).hasMessage(format("%nExpecting:%n" +
                                        "  <2018-04-06T10:27:33.001>%n" +
                                        "second of minute to be:%n" +
                                        "  <44>%n" +
                                        "but was:%n" +
                                        "  <33>"));
  }

}
