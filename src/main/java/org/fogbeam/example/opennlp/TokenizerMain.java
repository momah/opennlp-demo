package org.fogbeam.example.opennlp;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

/**
 * Tokenizer demo.
 */
public class TokenizerMain
{
	/**
 * Aquí se lee el fichero y se almacena en string
 * @param args The set of file names.
 * @throws Exception If some files are not found.
 */
	//
	public static String fileToString(String nombreArchivo) throws IOException{
		String cadena,aux;
        StringBuilder cadenaBuilder = new StringBuilder();
		FileReader f = new FileReader(nombreArchivo);
        BufferedReader buffer = new BufferedReader(f);
        while((aux = buffer.readLine())!=null) {
        	cadenaBuilder.append(aux);
        }
        cadena=cadenaBuilder.toString();


		return cadena;
	}

	public static String[] MakeToken(String cadena,InputStream modelIn) throws InvalidFormatException, IOException{

		//Aqu� se convierte en token
		TokenizerModel model = new TokenizerModel( modelIn );
		Tokenizer tokenizer = new TokenizerME(model);


    	String[] tokens = tokenizer.tokenize(  cadena );
		return tokens;
	}



	public static void main( String[] args ) throws Exception {

		// the provided model
		// InputStream modelIn = new FileInputStream( "models/en-token.bin" );

		// the model we trained
		InputStream modelIn = new FileInputStream( "models/en-token.model" );
		InputStream modelIn1 = new FileInputStream( "models/en-token.model" );

        //Leemos fichero y transformamos a cadena
        String cadena;
        cadena=fileToString("ficheroEN");

		try
		{
        	String[] tokens = hacerToken(cadena,modelIn);

		    for( String token : tokens )
			{
				System.out.println( token );
			}

		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		finally
		{
			if( modelIn != null )
			{
				try
				{
					modelIn.close();
				}
				catch( IOException e )
				{
				}
			}
		}
		System.out.println( "\n-----\ndone" );
	}


}
