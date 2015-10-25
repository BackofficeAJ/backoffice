package sn.askane.server.entities;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
/**
 * hubsocial janvier 2012
 */
public class Entity  implements Serializable{
	private static final long serialVersionUID = 8383358001127305021L;
	protected Long id ;
	public static Gson gson;
	
	static{
		GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

			@Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                String date = json.getAsJsonPrimitive().getAsString();
                    return new Date(new Long(date));
            }
        });
        
      gson = builder.create();
	}
	public Entity(){
		// TODO Auto-generated constructor stub	
	} 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString(){
		return Entity.gson.toJson(this);
	}
}