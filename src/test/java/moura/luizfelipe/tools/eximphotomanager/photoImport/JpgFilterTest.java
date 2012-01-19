package moura.luizfelipe.tools.eximphotomanager.photoImport;

import java.io.File;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class JpgFilterTest {
    
    public JpgFilterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of accept method, of class JpgFilter.
     */
    @Test
    public void testAccept() {
        
        System.out.println("- Testing method JpgFilter.accept ...");
        
        JpgFilter instance = new JpgFilter();
        
        //null file
        File file = null;
        assertFalse("Null file", instance.accept(file));
        
        file = mock(File.class);
        
        //directorio sem leitura
        when(file.isDirectory()).thenReturn(Boolean.TRUE);
        when(file.isFile()).thenReturn(Boolean.FALSE);
        when(file.canRead()).thenReturn(Boolean.FALSE);
        when(file.getName()).thenReturn("diretorio");
        assertFalse("Diretorio sem leitura", instance.accept(file));
        
        //directorio com leitura
        when(file.isDirectory()).thenReturn(Boolean.TRUE);
        when(file.isFile()).thenReturn(Boolean.FALSE);
        when(file.canRead()).thenReturn(Boolean.TRUE);
        when(file.getName()).thenReturn("diretorio");
        assertTrue("Diretorio com leitura", instance.accept(file));
        
        //directorio comecando com ponto (.)
        when(file.isDirectory()).thenReturn(Boolean.TRUE);
        when(file.isFile()).thenReturn(Boolean.FALSE);
        when(file.canRead()).thenReturn(Boolean.TRUE);
        when(file.getName()).thenReturn(".diretorio");
        assertFalse("Diretorio comecando com ponto (.)", instance.accept(file));
        
        //arquivo sem leitura
        when(file.isDirectory()).thenReturn(Boolean.FALSE);
        when(file.isFile()).thenReturn(Boolean.TRUE);
        when(file.canRead()).thenReturn(Boolean.FALSE);
        when(file.getName()).thenReturn("arquivo.jpg");
        assertFalse("Arquivo sem leitura", instance.accept(file));
        
        //arquivo com leitura
        when(file.isDirectory()).thenReturn(Boolean.FALSE);
        when(file.isFile()).thenReturn(Boolean.TRUE);
        when(file.canRead()).thenReturn(Boolean.TRUE);
        when(file.getName()).thenReturn("arquivo.jpg");
        assertTrue("Arquivo com leitura", instance.accept(file));
        
        //arquivo sem extensao correta (.jpg)
        when(file.isDirectory()).thenReturn(Boolean.FALSE);
        when(file.isFile()).thenReturn(Boolean.TRUE);
        when(file.canRead()).thenReturn(Boolean.TRUE);
        when(file.getName()).thenReturn("arquivo.jpd");
        assertFalse("Arquivo sem extensao correta (.jpg)", instance.accept(file));
    }
}
