package moura.luizfelipe.tools.eximphotomanager.photoImport;

import java.io.File;
import java.util.List;
import moura.luizfelipe.tools.eximphotomanager.PhotoRepository;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Integration testes for class PhotoImporter
 *
 * @author luizfelipe
 */
public class PhotoImporterIT {
    
    private PhotoImporter instance;

    public PhotoImporterIT() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        
        instance = new PhotoImporter(new PhotoRepository());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of importPhotos method, of class PhotoImporter.
     */
    @Test
    public void testImportPhotos() {
        System.out.println("importPhotos");
        // TODO review the generated test code and remove the default call to fail.

        String fileName = getClass().getClassLoader().getResource("emptyFolder1").getFile();


        File file = new File(fileName);
        assertTrue("Existe", file.exists());
        assertTrue("Diretorio", file.isDirectory());
        
        fail("ainda nao foi implementado");
    }
}
