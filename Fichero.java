import java.io.FileInputStream;
import java.util.Scanner;

public class Fichero extends Principal{
	
	public void inicializar() {
		String linetxt = "";
        String nuevalinea = "";
        String nuevalinea2 = "";
        String[] partes;
        String[] aux;
        int tipo = 0; //1->Lugar, 2->Personaje, 3->Objeto

        try {
            FileInputStream fichero = new FileInputStream("C:\\Users\\Usuario\\Desktop\\Ingenieria_Software_2\\Programacion_Orientada_objetos\\Proyecto_IA\\src\\Prueba_lectura.txt");
            Scanner src = new Scanner(fichero);

            while(src.hasNextLine()) {              
                //System.out.println(linetxt);
            	linetxt = src.nextLine(); 
            	
            	if(linetxt.contains("<")) {
            		
            		if(linetxt.contains("<Localizaciones>")) {
            			tipo = 1;
            		}
            		else if(linetxt.contains("<Personajes>")) {
            			tipo = 2;
            		}
            		else {
            			tipo = 3;
            		}
            		
            	}
            	else {
            		if(tipo == 1) {
            			nuevalinea = linetxt.replace("(", "-").replace(")", "").replace(",","-").trim();
                        partes = nuevalinea.split("-");
                        nuevalinea2 = linetxt.replace(partes[0],"").replace("(", "").replace(")", "").replace(",","-").trim();
                       // System.out.println("\n\n NUEVA LINEA 2 :"+nuevalinea2);
                        aux = nuevalinea2.split("-");

                        Lugar lugar = new Lugar(partes[0],aux);
                        lugares.add(lugar);
            		}
            		else if(tipo == 2) {
            			
            			nuevalinea = linetxt.replace("(", "-").replace(")", "").replace(",","-").trim();
                        partes = nuevalinea.split("-");
                        nuevalinea2 = linetxt.replace(partes[0],"").replace("(", "").replace(")", "").replace(",","-").trim();
                        //System.out.println("\n\n NUEVA LINEA 2 :"+nuevalinea2);
                        aux = nuevalinea2.split("-");

                        Personaje personaje = new Personaje(partes[0],aux[0]);
                        personajes.add(personaje);
            		}
            		else {
            			nuevalinea = linetxt.replace("(", "-").replace(")", "").replace(",","-").trim();
                        
                        partes = nuevalinea.split("-");
                        
                        nuevalinea2 = linetxt.replace(partes[0],"").replace("(", "").replace(")", "").replace(",","-").trim();
                        
                        //System.out.println("\n\n NUEVA LINEA 2 :"+nuevalinea2);
                        aux = nuevalinea2.split("-");

                        Objeto objeto = new Objeto(partes[0],aux[0]);
                        objetos.add(objeto);
            		}
            	}
            }	
            

            src.close(); //Cerramos el scanner al fichero.
            fichero.close(); //Cerramos el fichero.
        } 
        
        catch (Exception e) { //Levanto una excepcion si no se ha podido leer el fichero
            e.printStackTrace();
        }
    }
	public void imprimir() {
		System.out.println("[     LUGARES     ]\n");
        
        for(Lugar nini:lugares) {
			System.out.print(nini.toString()+"\n");
			System.out.println("");
		}
        System.out.println("[     PERSONAJES     ]\n");
        for(Personaje lili:personajes) {
			System.out.print(lili.toString()+"\n");
			System.out.println("");
		}
        System.out.println("[     OBJETOS     ]\n");
        for(Objeto claudio:objetos) {
			System.out.print(claudio.toString()+"\n");
			System.out.println("");
		}
	}
	
	public void objetivos(){
		
		String linetxt = "";
        String nuevalinea = "";
        String[] partes;
		int tipo = 0;
		int tamanio=0;
		
		try {
			FileInputStream fichero = new FileInputStream("C:\\Users\\Usuario\\Desktop\\Ingenieria_Software_2\\Programacion_Orientada_objetos\\Proyecto_IA\\src\\Objetivos.txt");
            Scanner src = new Scanner(fichero);
            
            while(src.hasNextLine()) {
            	
            	linetxt = src.nextLine();
            	
            	if(linetxt.contains("<")){	
            		if(linetxt.contains("<Localizacion Personajes>")) {
            			//System.out.println("hola");
            			tipo = 1;
            		}
            		else if(linetxt.contains("<Posesion Objetos>")) {
            			tipo = 2;
            		}
            		
            	}
            	else{
            		nuevalinea = linetxt.replace("(", "-").replace(")", "").trim();
            		partes = nuevalinea.split("-");
            		tamanio = partes.length;
            		
            		System.out.println("Tamanio es: "+tamanio);
            		
            		if(tamanio < 2) {
            			
            		}
            		else {
            		if(tipo == 1){
                        for(Personaje huevos:personajes){
                        	if(huevos.getNombre().equals(partes[0])) {
                        		huevos.setObjetivoL(partes[1]);
                        	}
                		}
            		}
            		
            		else if(tipo == 2) {
                        for(Personaje patata:personajes){
                        	if(patata.getNombre().equals(partes[1])){
                        		patata.setObjetivoO(partes[0]);
                        		
                        	}
                		}
            		}
            	}
            }
        }
            src.close(); //Cerramos el scanner al fichero.
            fichero.close(); //Cerramos el fichero.
		}
        catch(Exception e){
			e.printStackTrace();
		}
	}
}
