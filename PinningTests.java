import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class PinningTests {

    Monkey firstMonkey, secondMonkey, thirdMonkey;
    /**
     * Runs this setup before the actual tests
     *
     * @throws Exception
     */
    @Before
    public void setUp() {
        firstMonkey = new Monkey();
        secondMonkey = new Monkey();
        thirdMonkey = new Monkey();
    }

    @Test
    public void getFirstMonkeyTestPasses() throws Exception {
        int id = firstMonkey.getId();
        assertEquals(firstMonkey.getId(), id);
    }

    @Test
    public void getFirstMonkeyTestFails() throws Exception {
        assertNotEquals(firstMonkey.getId(), 20);
    }

    @Test
    public void stringifyResultsMonkey1To2() throws NoIdException {
        int firstId = firstMonkey.getId();
        int secondId = secondMonkey.getId();
        String output = "//Round 1: Threw banana from Monkey (#" + firstId + " / ID "
                + firstId + ") to Monkey (#" + secondId + " / ID " + secondId + ")";
        assertEquals(MonkeySim.stringifyResults(1, firstMonkey, secondMonkey), output);
    }

    @Test
    public void stringifyResultsMonkey1To3() throws NoIdException {
        int firstId = firstMonkey.getId();
        int secondId = thirdMonkey.getId();
        String output = "//Round 1: Threw banana from Monkey (#" + firstId + " / ID "
                + firstId + ") to Monkey (#" + secondId + " / ID " + secondId + ")";
        assertEquals(MonkeySim.stringifyResults(1, firstMonkey, thirdMonkey), output);
    }

    @Test
    public void stringifyResultsMonkey2To3() throws NoIdException {
        int firstId = secondMonkey.getId();
        int secondId = thirdMonkey.getId();
        String output = "//Round 1: Threw banana from Monkey (#" + firstId + " / ID "
                + firstId + ") to Monkey (#" + secondId + " / ID " + secondId + ")";
        assertEquals(MonkeySim.stringifyResults(1, secondMonkey, thirdMonkey), output);
    }


}
