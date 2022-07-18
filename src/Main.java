/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ApiRest api = new ApiRest();
        System.out.println(api.get());
        api.userList();
        
        // Prueba de POST desde JAVA
        
        
        if(api.delete(3) == 1){
            System.out.println("Eliminado!");
        }else{
            System.out.println("No se pudo eliminar!");
        }
        
        
    }
    
}
