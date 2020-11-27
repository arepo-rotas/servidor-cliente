package server;

import java.io.IOException;

import server.Server;

public class Main {

	public static void main(String[] args) throws IOException {
        
    	Server serv = new Server();
        System.out.println("Iniciando servidor . . .");
        
        serv.iniciarServer();
        
        serv.finalizarServer();
    }
}
