package moura.luizfelipe.tools.eximphotomanager;

import java.io.File;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Integration tests for PhotoProcessor
 * @author luizfelipe
 */
public class PhotoProcessorIT {
    
    private PhotoProcessor instance;
    
    public PhotoProcessorIT() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        
        instance = new PhotoProcessor();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of processPhoto method, of class PhotoProcessor.
     */
    @Test
    public void testProcessPhoto() {
        System.out.println("- Testing PhotoProcessor.processPhoto method ...");
        
        //process a null photo
        assertNull("Process a null photo", instance.processPhoto(null));
        
        //process a non-EXIM photo
        //assertNull("Process an invalid file", )
    }
}
