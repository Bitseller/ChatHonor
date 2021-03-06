package cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class CSend extends Thread implements IMensajes{

	private BufferedReader bufferConsola = new BufferedReader( new InputStreamReader(System.in) );
	private DataOutputStream salidaSocket;

	public CSend(String nombre,DataOutputStream salidaSocket ) {
		super(nombre);		
		this.salidaSocket = salidaSocket;
	}
	
	public void run(){
	   boolean run = true;
	   try 
	   {	
		   while(run)
		   {
				String mensaje = bufferConsola.readLine();	
				if(mensaje.equals(FINALIZAR))
				{	
					run = false;
					salidaSocket.writeUTF(FINALIZAR);
				}
				else
					salidaSocket.writeUTF(mensaje);
		   } 
	   }
	   catch (IOException e) {
			e.printStackTrace();
	   }
	   finally
	   {
		   /*
		  try{
				salidaSocket.close();
				bufferConsola.close();
		   }
		   catch (IOException e) {
				e.printStackTrace();
		   }*/
	   }
	}
}