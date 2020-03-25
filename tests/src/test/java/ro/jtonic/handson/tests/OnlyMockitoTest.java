package ro.jtonic.handson.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OnlyMockitoTest {

  @Test
  public void should_mock_final_class() {

    final String boo = UUID.randomUUID().toString();

    FinalClass finalClass = Mockito.mock(FinalClass.class);

    doReturn(boo).when(finalClass).ask();

    final String ret = finalClass.ask();

    assertThat(ret)
        .as("Class is mocked")
        .isEqualTo(boo);
  }

  @Test
  public void should_mock_final_method() {
    final String boo = "boo";

    final FinalClass finalClass = Mockito.mock(FinalClass.class);

    doReturn(boo).when(finalClass).say();

    final String ret = finalClass.say();

    assertThat(ret)
        .isEqualTo(boo);
  }
}