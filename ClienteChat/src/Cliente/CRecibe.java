package Cliente;

import java.io.DataInputStream;
import java.io.IOException;

public class CRecibe extends Thread implements IMensajes{
	private DataInputStream input;
	private boolean run=false;
	
	public CRecibe(String nombre,DataInputStream input ) {
		super(nombre);		
		this.input = input;
		
	}
	
	public void run(){	
		run = true;	
		String mensaje ="";
		while(run&&!mensaje.equals(FIN_CONEXION))
		{
			try 
			{
				mensaje = input.readUTF();
				System.out.println(	mensaje );
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}	
		}
		/*
		try 
		{
			input.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}*/
	}
	
	public void salir(){
		run = false;
		
	}
	
	
	

}