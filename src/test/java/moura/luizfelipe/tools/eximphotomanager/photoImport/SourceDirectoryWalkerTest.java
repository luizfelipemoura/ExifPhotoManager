package moura.luizfelipe.tools.eximphotomanager.photoImport;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SourceDirectoryWalkerTest {
    
    private SourceDirectoryWalker instance = null;
    private PhotoImporter photoImporter = mock(PhotoImporter.class);
    
    public SourceDirectoryWalkerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        
        instance = new SourceDirectoryWalker(photoImporter);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of handleFile method, of class SourceDirectoryWalker.
     */
    @Test
    public void testHandleFile() throws Exception {
        System.out.println("- Testing SourceDirectoryWalker.handleFile method");
        
        File file = mock(File.class);
        File processedFile = mock(File.class);
        File importedFile = mock(File.class);
        int depth = 0;
        List<PhotoImportRegisgry> importReport = new ArrayList<PhotoImportRegisgry>();
        
        
        //falha no processamento da foto
        when(photoImporter.processPhoto(file)).thenReturn(null);
        
        instance.handleFile(file, depth, importReport);
        PhotoImportRegisgry registro = importReport.get(0);
        
        verify(photoImporter, times(1)).copyToRepository(file, null);
        assertNotNull("Falha de processamento da foto - registro", registro);
        assertSame("Falha de processamento da foto - registro da origem", file, registro.getSourceFile());
        assertNull("Falha de processamento da foto - registro do destino", registro.getDestinationFile());
        
        //importacao da foto processada (sem modificacao)
        when(photoImporter.processPhoto(file)).thenReturn(processedFile);
        when(photoImporter.copyToRepository(file, processedFile)).thenReturn(processedFile);
        
        importReport.clear();
        instance.handleFile(file, depth, importReport);
        registro = importReport.get(0);
        
        assertNotNull("Importacao da foto processada (sem modificacao) - registro", registro);
        assertSame("Importacao da foto processada (sem modificacao) - registro da origem", file, registro.getSourceFile());
        assertSame("Importacao da foto processada (sem modificacao) - registro do destino", processedFile, registro.getDestinationFile());
        
        //importacao da foto processada (com modificacao)
        when(photoImporter.processPhoto(file)).thenReturn(processedFile);
        when(photoImporter.copyToRepository(file, processedFile)).thenReturn(importedFile);
        
        importReport.clear();
        instance.handleFile(file, depth, importReport);
        registro = importReport.get(0);
        
        assertNotNull("Importacao da foto processada (sem modificacao) - registro", registro);
        assertSame("Importacao da foto processada (sem modificacao) - registro da origem", file, registro.getSourceFile());
        assertSame("Importacao da foto processada (sem modificacao) - registro do destino", importedFile, registro.getDestinationFile());
    }
}
