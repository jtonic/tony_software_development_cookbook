package ro.jtonic.handson.tests;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({TargetClass.class, StaticClass.class, PrivateMethodClass.class})
public class AllInOneTest {

  private TargetClass targetClass;
  private FinalClass finalClass;
  private FinalMethodClass finalMethodClass;
  private PrivateMethodClass privateMethodClass;

  @Before
  public void setUp() {
    this.finalClass = PowerMockito.mock(FinalClass.class);
    this.finalMethodClass = PowerMockito.mock(FinalMethodClass.class);
    this.privateMethodClass = PowerMockito.spy(new PrivateMethodClass());
    this.targetClass = new TargetClass(finalMethodClass, finalClass, privateMethodClass);
  }

  @Test
  public void testAllSpecialCases() throws Exception {

    //Given
    final String boo = "boo";
    final String fee = "fee";
    final String lee = "lee";
    final String zee = "zee";
    final String mee = "mee";

    CollaboratorClass mock = PowerMockito.mock(CollaboratorClass.class);
    PowerMockito.mockStatic(StaticClass.class);

    PowerMockito.when(mock.foo()).thenReturn(boo);
    PowerMockito.whenNew(CollaboratorClass.class).withNoArguments().thenReturn(mock);

    PowerMockito.when(this.finalClass.ask()).thenReturn(fee);
    PowerMockito.when(this.finalMethodClass.say()).thenReturn(lee);
    PowerMockito.when(StaticClass.speak()).thenReturn(zee);

    // Best practices: implementation details should not be tested
    PowerMockito.doReturn(mee).when(this.privateMethodClass, "doTell");

    //When
    final String booRet = this.targetClass.boo();

    //Then
    Assertions.assertThat(booRet)
        .isEqualTo(String.format("%s %s %s %s %s", boo, fee, lee, zee, mee));

    PowerMockito.verifyNew(CollaboratorClass.class).withNoArguments();
    Mockito.verify(this.finalClass).ask();
    Mockito.verify(this.finalMethodClass).say();
    PowerMockito.verifyPrivate(this.privateMethodClass).invoke("doTell");
  }
}
