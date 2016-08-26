/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;


import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author User
 */
@Path("url2")
public class rsPrueba1 {
    public static List<Integer> ListaElementos=new ArrayList<>();;
    
    
    @GET
    @Produces ({ MediaType.APPLICATION_JSON  })
    public List<Integer> consultar(Integer parametro)
    {        
        for (int i = 0; i < parametro; i++) {
            ListaElementos.add(i++);         
        }
        return ListaElementos;
    }
    
    
}
