package server;

public class Tareas {
	
		
	String[][] matrizTareas = new String[100][2];
	
	public void tareasEscritura(int i, int j, String mensaje) {
		matrizTareas[i][j] = mensaje;
				
		
		}
	public String tareasLectura(int i, int j) {
		String prueba = matrizTareas[i][j];
		return prueba;
	}

}
