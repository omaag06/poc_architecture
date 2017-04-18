package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ JUnitAssertsTest.class, JUnitMatcherAssertsTest.class })

public class TestSuite {

    //La clase permanece vacía, utilizada sólo como marcador para las anotaciones anteriores
}