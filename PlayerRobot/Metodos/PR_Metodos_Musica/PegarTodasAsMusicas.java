package PR_Metodos_Musica;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import PR_Musica.Musica;
import PR_TimeLifeApp.TimeLifeApp;
import PR_BancodeDados.ExecutaComandos;

public class PegarTodasAsMusicas {
	
	public PegarTodasAsMusicas() {}
	public ArrayList<Musica> RetornarTodasAsMusicas() throws Exception
	{
		try 
		{
			PegarImage        getImagem       = new PegarImage();
			Gson 			  gson			  = new Gson();
			ArrayList<Musica> musicas 		  = new ArrayList<Musica>();
			ExecutaComandos   cmd	     	  = new ExecutaComandos(TimeLifeApp._ReceberTodasAsMusicas);
			JSONArray         arrayMusicas    = cmd.PesquisarRetornandoArray();
			
			for(int i = 0; i < arrayMusicas.length(); i++) {
				Musica ms = new Musica();
				JSONObject obj = arrayMusicas.getJSONObject(i);
				
				if(obj.has("error")) {
					throw new Exception(obj.getString("error"));
				}
				
				java.lang.reflect.Type Musicatype = new TypeToken<Musica>() {}.getType();
				ms = gson.fromJson(obj.toString(), Musicatype);
				ms.setImagem(getImagem.getImage(ms.getUrlDaImagem()));
				musicas.add(ms);
			}
			
			if(musicas.isEmpty())
				throw new Exception("Banco de Musicas Vazio");
			else
				return musicas;
		}catch(Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}
	
}
