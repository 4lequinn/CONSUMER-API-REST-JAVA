
import com.sun.jndi.toolkit.url.Uri;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public class ApiRest {
     public String get(){
        String salida = "";
        try {
            URL url = new URL("http://localhost:8000/usuario/usuario/");
            HttpURLConnection api = (HttpURLConnection) url.openConnection();
            api.setRequestMethod("GET");
            api.setRequestProperty("Accept", "application/json");
            if(api.getResponseCode() == 200){
                // Todo está OK
                InputStreamReader entrada = new InputStreamReader(api.getInputStream());
                BufferedReader lectura = new BufferedReader(entrada);
                salida = lectura.readLine();
            }else {
                salida = "";
                System.out.println("No se puede conectar a la API" + api.getResponseCode());
            }
            
            api.disconnect();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return salida;
    }
     
     
     public void userList(){

        JSONArray arreglo = new JSONArray(get());
        String datos[] = new String[13];
        for (int indice = 0;indice < arreglo.length();indice++){
        JSONObject atributo = arreglo.getJSONObject(indice);

            datos[0] = String.valueOf(atributo.getInt("id")) ;
            datos[1] = atributo.getString("password");
            //datos[2] = atributo.getString("last_login");
            //datos[3] = atributo.getString("is_staff");
            //datos[4] = atributo.getString("is_superuser");
            datos[5] = atributo.getString("username");
            datos[6] = atributo.getString("email");
            //datos[7] = atributo.getString("name");
            //datos[8] = atributo.getString("last_name");
            //datos[9] = atributo.getString("image");
            //datos[10] = atributo.getString("is_active");
            //datos[11] = atributo.getString("groups");
            //datos[12] = atributo.getString("user_permissions");
            
            System.out.println(datos[5]);
        }
        
    }
     
     
    public int post(){
        int salida = 0;
        try{
            URL url = new URL("http://localhost:8000/usuario/usuario/");
            HttpURLConnection c_api = (HttpURLConnection) url.openConnection();
            c_api.setRequestMethod("POST");
            c_api.setRequestProperty("Content-Type", "application/json; utf-8");
            c_api.setDoOutput(true); 
           
            String jsonS = "{\"username\":\"usuarioJAVA\",\n" +
                            "    \"password\":\"JAVITA\",\n" +
                            "    \"email\":\"test@gmail.com\"\n" +
                            "}";
            OutputStream os = c_api.getOutputStream();
            os.write(jsonS.getBytes());
            os.flush();
            if (c_api.getResponseCode() !=200){
                System.out.println("No se pudo acceder a la api" + c_api.getResponseCode()) ;
            }else{
            salida = 1;
            }
            c_api.disconnect();


            }catch(IOException ex){
            System.out.println("Error:"+ex.getMessage());
        }
        return salida;
    }  
    
    
    public int put(){
        int salida = 0;
        try{
            URL url = new URL("http://localhost:8000/usuario/usuario/3");
            HttpURLConnection c_api = (HttpURLConnection) url.openConnection();
            c_api.setRequestMethod("PUT");
            c_api.setRequestProperty("Content-Type", "application/json; utf-8");
            c_api.setDoOutput(true); 
            String jsonS = "{\"password\":\"TEAMO LISS\",\n" +
                             "    \"name\":\"Mai lob =) \",\n" +
                             "    \"username\":\"TEEEE AMOOOO \",\n" +
                            "    \"email\":\"test@gmail.com\"\n" +
                            "}";
            OutputStream os = c_api.getOutputStream();
            os.write(jsonS.getBytes());
            os.flush();
            if (c_api.getResponseCode() !=200){
                System.out.println("No se pudo acceder a la api" + c_api.getResponseCode()) ;
            }else{
            salida = 1;
            }
            c_api.disconnect();


            }catch(IOException ex){
            System.out.println("Error:"+ex.getMessage());
        }
        
        return salida;
    }
    
    
    public int delete(int id){
        int salida = 0;
        try {
            URL url = new URL("http://localhost:8000/usuario/usuario/" + id);
            HttpURLConnection api = (HttpURLConnection) url.openConnection();
            api.setRequestMethod("DELETE");
            api.setRequestProperty("Accept", "application/json");
            if(api.getResponseCode() != 200){
                System.out.println("No se puede conectar a la API" + api.getResponseCode());         
            }else {
                salida = 1;
                // Todo está OK
            }

            api.disconnect();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return salida;
    }
    
    
}
