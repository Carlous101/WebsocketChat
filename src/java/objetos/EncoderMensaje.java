package objetos;

import java.io.IOException;
import java.io.Writer;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
/**Encripta
 *Encoder=Codificador-Cifrador
 * @author CARLOS A.
 */
public class EncoderMensaje implements Encoder.TextStream<Mensaje>{
    
    @Override
    //En la clase encoder, recibimos el mensaje, una instancia de la clase mensaje
    public void encode(Mensaje object, Writer writer) throws EncodeException, IOException{
        //Se crea el objeto JSON y se le agrega una propiedad nombre y mensaje...
        JsonObject json=Json.createObjectBuilder()
                .add("nombre",object.getnombre())
                .add("mensaje",object.getMensaje()).build();
        //construimos el objeto JSON, el cual es el que se va a enviar al cliente...
        try(JsonWriter jsonWriter=Json.createWriter(writer)){
            jsonWriter.write(json);
        }
    }
    @Override
    public void init(EndpointConfig config){
        
    }
    @Override
    public void destroy(){
        
    }

}
