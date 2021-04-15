/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Cliente;

/**
 *
 * @author daw-B
 */
public class IODatos {

//leer fichero binario
    public static ArrayList<Cliente> cargarClientes(){
        ArrayList<Cliente> vClientes = new ArrayList();
        String ruta = "Clientes.dat";
        File f = new File(ruta);
        
        
        //crear fichero si no existe
        if (!f.exists()) {
            
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        //leer fichero
        try (FileInputStream fi = new FileInputStream(f);
        ObjectInputStream leer = new ObjectInputStream(fi);){
            
            vClientes= (ArrayList<Cliente>) leer.readObject();
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error");
        }
        
      //devuelve el vector  
      return vClientes;
    }
    
    public static void escribirClientes(ArrayList<Cliente> vClientes){
        String ruta = "Clientes.dat";
        File f = new File(ruta);
        
        //crear fichero si no existe
        if (!f.exists()) {
            
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        try ( FileOutputStream fo = new FileOutputStream(f);
        ObjectOutputStream escribir = new ObjectOutputStream(fo);){
            
            escribir.writeObject(vClientes); 
            
        } catch (IOException ex) {
           System.out.println("Error");
        }
    }
    
}

    

