/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package readergaspass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author usuario
 */
public class Readergaspass {

    public static void main( String[] args )
    {
        
    	int i = 0;
    	int dato, datoTotal=0;
    	
    	try {
                //calling GassPass process
                
                String command = "java -jar gaspass.jar";
                String pws ="powershell";
                  
    		var process = new ProcessBuilder(pws, command).start(); //Process GasPass executed

                waitingFiveSeconds();

		} catch (IOException e2) {

			e2.printStackTrace();

                        System.out.println("Process GasPass not found opened.");
		} 
    	
    	while(true) {
    		
    		i++;
    		FileReader flujo;
			try {
				
				File file = new File("GasPassInfo"+i+".dat");
				flujo = new FileReader(file);
				Scanner lector = new Scanner(flujo);
				dato = Integer.parseInt(lector.nextLine());
                                
				try {
					flujo.close();
					lector.close();
					file.delete();
				} catch (IOException e1) {

                                        e1.printStackTrace();
                                        System.out.println("An error occurred reading the archive GasPassInfo"+i+".dat.");
				}
	            
	            datoTotal = datoTotal+dato;
	    		
	    		System.out.println(datoTotal+" es la cantidad en m³");
	    		
	    		waitingFiveSeconds();      //waiting 5 seconds
	    		
			} catch (FileNotFoundException e) {

                                e.printStackTrace();
                                System.out.println("Archive GasPassInfo"+i+".dat not found.");

			}
			}

    }
    
    public static void waitingFiveSeconds(){
        
        try{
        Thread.sleep(5000);
	} catch (InterruptedException e) {

            e.printStackTrace();
	}

    }
   
}



