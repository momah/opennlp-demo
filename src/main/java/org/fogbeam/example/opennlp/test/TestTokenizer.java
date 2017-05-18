package org.fogbeam.example.opennlp.test;
import static org.junit.Assert.*;

import org.fogbeam.example.opennlp.TokenizerMain;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTokenizer {

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testExistingFiles() {
    try {
      TokenizerMain.main(new String[]{"test/texto_01.txt", "test/texto_02.txt"});
    } catch (Exception e) {
      fail("This should not throw an Exception");
    }
  }


  @Test
  public void ficheroVacio() throws Exception {
  //Comprobar si el fichero no está vacio
   String strOriginal=TokenizerMain.fichero_a_cadena("test/texto_02.txt");
   boolean same=false;

   if(!strOriginal.isEmpty())
      same=true;

  		assertTrue(same == true);
  }

  @Test
  public void mismaCadena() throws Exception{
  @
  //Comprobar que quincide contenido del fichero texto_01
  	String strOriginal=TokenizerMain.fichero_a_cadena("test/texto_01.txt");
  	boolean same=false;

  	String byText="One can resist the invasión of an army but one cannot resist the invasion of ideas. Victor Hugo";

		if(strOriginal.equals(byText))
  		same=true;

		assertTrue(same == true);
	}

  @Test
  public void mismaCadena() throws Exception {
    @
  //Comprobar que no quincide contenido del fichero texto_01
    String strOriginal=TokenizerMain.fichero_a_cadena("test/texto_01.txt");
    boolean same=false;

    String byText="In a village of La Mancha, the name of which I have no desire to call to mind.";

    if(strOriginal.equals(byText))
      same=true;

    assertFalse(same == true);
  }

}
