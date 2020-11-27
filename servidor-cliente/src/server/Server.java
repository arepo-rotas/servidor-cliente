package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	 private final int PUERTO = 9876; 
	    private ServerSocket serverSocket;
	    private Socket socket;
	    
	    
	    public Server() throws IOException {
	        serverSocket = new ServerSocket(PUERTO); 
	        socket = new Socket(); 
	    }
	    	
	    
	    
	    
	    public void iniciarServer() throws IOException {
	        
	    	
	    	while (true) {
	            System.out.println("Esperando la conexion del cliente");
	            socket = serverSocket.accept(); 
	                     
	            DataOutputStream mensajeCliente = new DataOutputStream(socket.getOutputStream());
	            
	            mensajeCliente.writeUTF("Nombre del Cliente?");
	            
	            DataInputStream entrada = new DataInputStream(socket.getInputStream());
	            String mensajeDeCliente;
	            mensajeDeCliente = entrada.readUTF();
	            System.out.println(mensajeDeCliente);
	            
	            mensajeCliente.writeUTF("Numero de tareas?");
	            mensajeDeCliente = entrada.readUTF();
	            int num = Integer.parseInt(mensajeDeCliente);
	            
	            
	            
	            Tareas tar = new Tareas();
	            
	            
	            for (int i = 0; i < num; i++) {
	            	int a = i+1;
	            	mensajeCliente.writeUTF("Tarea numero " + a);
	            	mensajeCliente.writeUTF("Descripcion de la tarea numero " + a);
	            	mensajeDeCliente = entrada.readUTF();
	            	System.out.println(mensajeDeCliente);
	            	tar.tareasEscritura(i, 0, mensajeDeCliente);
	            	mensajeCliente.writeUTF("Estado de la tarea numero " + a);
	            	mensajeDeCliente = entrada.readUTF();
	            	System.out.println(mensajeDeCliente);
	            	tar.tareasEscritura(i, 1, mensajeDeCliente);
	            }
	            mensajeCliente.writeUTF("Todas las tareas: Descripcion y Estado");
	            for(int i = 0; i < num; i++) {
	            	int a = i + 1;
	            	mensajeCliente.writeUTF("Tarea N " + a);
	            	for(int j = 0; j < 2; j++) {
	            		String valorMatriz = tar.tareasLectura(i, j);
	            		System.out.println(valorMatriz);
	            		mensajeCliente.writeUTF(valorMatriz);
	            	}
	            }
	            

	        }
	    }

	    public void finalizarServer() throws IOException {
	        serverSocket.close();

	    }
}
