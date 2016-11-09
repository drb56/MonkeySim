import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class PinningTests {

    Monkey firstMonkey;
    /**
     * Runs this setup before the actual tests
     *
     * @throws Exception
     */
    @Before
    public void setUp() {
        firstMonkey = new Monkey();
    }

    @Test
    public void getFirstMonkeyTestPasses() throws Exception{
        assertEquals(firstMonkey.getId(), 0);
    }

    @Test
    public void getFirstMonkeyTestFails() throws Exception{
        assertNotEquals(firstMonkey.getId(), 20);
    }

    

}
