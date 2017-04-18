package junit;

import org.hamcrest.Matcher;
import org.hamcrest.core.CombinableMatcher;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;

public class JUnitMatcherAssertsTest {

    JUnitMatcherAsserts jUnitMatcherAsserts;

    @Before
    public void setUp() throws Exception {
        System.out.println("Estoy en el @Before");
        jUnitMatcherAsserts = new JUnitMatcherAsserts();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Estoy en el @After");

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Estoy en el @BeforeClass");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("Estoy en el @AfterClass");

    }


    // JUnit Matchers assertThat
    @Test
    public void testContieneAmbosStrings() {
        assertThat("No contiene este String",jUnitMatcherAsserts.contieneAmbosStrings(), not(both(containsString("a")).and(containsString("b"))));
    }

    @Test
    public void testContieneEstosItems() {
        assertThat(Arrays.asList(jUnitMatcherAsserts.contieneEstosItems()), not(hasItems("uno", "tres")));
    }

    @Test
    public void testAssertThatEveryItemContainsString() {
        assertThat(Arrays.asList(jUnitMatcherAsserts.contieneCadaItemEsteString()), everyItem(containsString("n")));
    }

    // Core Hamcrest Matchers with assertThat
    @Test
    public void testAssertThatHamcrestCoreMatchers() {
        assertThat("bueno", allOf(equalTo("bueno"), startsWith("bu")));
        assertThat("bueno", not(allOf(equalTo("malo"), equalTo("bueno"))));
        assertThat("bueno", anyOf(equalTo("malo"), equalTo("bueno")));
        assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Object())));
    }

    @Test
    public void testAssertTrue() {
        assertTrue("failure - should be true", true);
    }
}