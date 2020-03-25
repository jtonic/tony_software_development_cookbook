package ro.jtonic.handson.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TargetClass.class, StaticClass.class})
public class UsingPowerMockTest {

  @Test
  public void should_mock_static_method() {
    final String value = UUID.randomUUID().toString();

    mockStatic(StaticClass.class);
    when(StaticClass.speak()).thenReturn(value);

    assertThat(StaticClass.speak())
        .as("Static method is mocked")
        .isEqualTo(value);
  }

  @Test
  public void should_mock_constructor() throws Exception {

    CollaboratorClass collaboratorClass = PowerMockito.mock(CollaboratorClass.class);

    Mockito.doReturn("boo").when(collaboratorClass).foo();
    PowerMockito.whenNew(CollaboratorClass.class).withNoArguments()
        .thenReturn(collaboratorClass);

    final TargetClass sut = new TargetClass(mock(FinalMethodClass.class), mock(FinalClass.class),
        mock(PrivateMethodClass.class));
    sut.foo();

    PowerMockito.verifyNew(CollaboratorClass.class).withNoArguments();
    Mockito.verify(collaboratorClass).foo();
  }
}
