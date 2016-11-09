import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PinningTests {

    Monkey firstMonkey, secondMonkey, thirdMonkey;
    List<Monkey> ml;
    /**
     * Runs this setup before the actual tests
     *
     * @throws Exception
     */
    @Before
    public void setUp() {
        firstMonkey = new Monkey();
        firstMonkey.generateId(0);
        secondMonkey = new Monkey();
        secondMonkey.generateId(1);
        thirdMonkey = new Monkey();
        thirdMonkey.generateId(2);
        ml = new LinkedList<>();
        ml.add(firstMonkey);
        ml.add(secondMonkey);
        ml.add(thirdMonkey);
    }

    @Test
    public void getFirstMonkeyTestPasses() throws Exception {

        assertEquals(firstMonkey.getId(), firstMonkey.getMonkeyNum());
    }

    @Test
    public void getFirstMonkeyTestFails() throws Exception {
        assertNotEquals(firstMonkey.getId(), 20);
    }

    @Test
    public void getFirstMonkeyTestNotNull() {
        assertNotNull(MonkeySim.getFirstMonkey(ml));
    }

//    @Test
//    public void stringifyResultsMonkey0To1() {
//        String output = "//Round 1: Threw banana from Monkey (#0 / ID 0) to Monkey (#1 / ID 1)";
//        assertEquals(MonkeySim.stringifyResults(1, firstMonkey, secondMonkey), output);
//    }
//
//    @Test
//    public void stringifyResultsMonkey0To2() {
//        String output = "//Round 10: Threw banana from Monkey (#0 / ID 0) to Monkey (#2 / ID 2)";
//        assertEquals(MonkeySim.stringifyResults(10, firstMonkey, thirdMonkey), output);
//    }
//
//    @Test
//    public void stringifyResultsMonkey1To2() {
//        String output = "//Round 100: Threw banana from Monkey (#7 / ID 7) to Monkey (#8 / ID 8)";
//        assertEquals(MonkeySim.stringifyResults(100, secondMonkey, thirdMonkey), output);
//    }

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

    @Test
    public void generateId() {
        assertEquals(firstMonkey.generateId(0), 0);
    }
}
