package org.fogbeam.example.opennlp.test;
import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.InputStream;

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
  public void ficheroVacio() throws Exception {
  //Comprobar si el fichero no está vacio
   String strOriginal=TokenizerMain.fileToString("test/texto_02.txt");
   boolean same=false;

   if(!strOriginal.isEmpty())
      same=true;

  assertTrue(same == true);
  }

  @Test
  public void sameString() throws Exception{
 
  //Comprobar que quincide contenido del fichero texto_01
  	String strOriginal=TokenizerMain.fileToString("test/texto_01.txt");
  	boolean same=false;

  	String byText="One can resist the invasion of an army but one cannot resist the invasion of ideas. Victor Hugo";

	if(strOriginal.equals(byText))
		same=true;

	assertTrue(same == true);
	}

  @Test
  public void differentString() throws Exception {
 
  //Comprobar que no quincide contenido del fichero texto_01
    String strOriginal=TokenizerMain.fileToString("test/texto_01.txt");
    boolean same=false;

    String byText="In a village of La Mancha, the name of which I have no desire to call to mind.";

    if(strOriginal.equals(byText))
      same=true;

    assertFalse(same == true);
  }
  

  @Test
  public void NotNullString() throws Exception {
 
  //Comprobar que no quincide contenido del fichero texto_01
    String strOriginal=TokenizerMain.fileToString("test/texto_01.txt");

    assertNotNull(strOriginal);
  }
  
  @Test
  public void NotNullString2() throws Exception {
 
  //Comprobar que no quincide contenido del fichero texto_01
    String strOriginal=TokenizerMain.fileToString("test/texto_02.txt");

    assertNotNull(strOriginal);
  }
  
  @Test
  public void assertEqualsStrings() throws Exception {
 
  //Comprobar que no quincide contenido del fichero texto_01
    String strOriginal=TokenizerMain.fileToString("test/texto_01.txt");
    String byText="One can resist the invasion of an army but one cannot resist the invasion of ideas. Victor Hugo";
    assertEquals(strOriginal, byText);
  }
  
  @Test
  public void assertNotEqualsStrings() throws Exception {
 
  //Comprobar que no quincide contenido del fichero texto_01
    String strOriginal=TokenizerMain.fileToString("test/texto_01.txt");
    String byText="In a village of La Mancha, the name of which I have no desire to call to mind.";
    assertNotEquals(strOriginal, byText);
  }
  
  @Test
  public void MakeToken() throws Exception {

  //Comprobar que no quincide contenido del fichero texto_01
    String[] strOriginal=TokenizerMain.MakeToken("test/texto_01.txt", new FileInputStream( "models/en-token.model" ));
    assertNotNull(strOriginal);
  }
  

}
