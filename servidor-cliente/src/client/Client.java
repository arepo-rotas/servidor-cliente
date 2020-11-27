package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private final String HOST = "localhost";
    private final int PUERTO = 9876;
    private Socket socket;
    Scanner sc = new Scanner(System.in);
    
    public Client() throws IOException {
        socket = new Socket("localhost", 9876);
    }

    public void iniciarCliente() throws IOException {
    	
    	
        DataInputStream entradaServidor = new DataInputStream(socket.getInputStream());
        System.out.println(entradaServidor.readUTF()); //Mostramos el mensaje por pantalla
        
        String mensaje = sc.nextLine();
        DataOutputStream salidaServidor = new DataOutputStream(socket.getOutputStream());
        salidaServidor.writeUTF(mensaje);
        
        System.out.println(entradaServidor.readUTF());
        String nTareas = sc.nextLine();
        salidaServidor.writeUTF(nTareas);
        
        int num = Integer.parseInt(nTareas);
        
        for (int i = 0; i < num; i++) {
        	System.out.println(entradaServidor.readUTF());
        	System.out.println(entradaServidor.readUTF());
        	mensaje = sc.nextLine();
        	salidaServidor.writeUTF(mensaje);
        	System.out.println(entradaServidor.readUTF());
        	mensaje = sc.nextLine();
        	salidaServidor.writeUTF(mensaje);
        	}
        System.out.println(entradaServidor.readUTF());
        for(int i = 0; i < num; i++) {
        	System.out.println(entradaServidor.readUTF());
        	for(int j = 0; j < 2; j++) {
        		System.out.println(entradaServidor.readUTF());
        	}
        }
        
        salidaServidor.close();
        entradaServidor.close();
        socket.close();
    }
}
