package objetos;

/**
 *
 * @author CARLOS A.
 */
//Esta clase se tiene que codificar y convertirla en un JSON
/*y cuando recibimos el JSON del cliente tenemos que codificarla y 
pasarla de JSON a una Instancia. para ello la clase EncoderMensaje*/
public class Mensaje {
    //Atributos
    private String nombre, mensaje;
    //Constructor vacio
    public Mensaje(){
    
    }
    
    //Get and set
    public String getnombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getMensaje(){
        return mensaje;
    }
    public void setMensaje(String mensaje){
        this.mensaje=mensaje;
    }
}
