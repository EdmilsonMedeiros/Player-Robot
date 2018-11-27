package PR_Metodos_Musica;


import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;

import PR_BancodeDados.ExecutaComandos;
import PR_TimeLifeApp.TimeLifeApp;

public class PegarMP3Servidor {
	public PegarMP3Servidor() {}
	public File getMP3DoServidor(String codigoMusica) throws Exception 
	{
		try 
		{
			ExecutaComandos cmd  = new ExecutaComandos(TimeLifeApp._ReceberMusicas);
			cmd.AdicionarParamentros("musica", codigoMusica);			
			JSONArray resultado = cmd.PesquisarRetornandoArray();
			
			File ms = new File("musicatemp");
			if(resultado != null) 
			{
				for(int i = 0; i < resultado.length(); i++) {
					JSONObject jo = resultado.getJSONObject(i);
					
					if(jo.has("error")) {
						throw new Exception(jo.getString("error"));
					}
					
					ms = this.decode(jo);
				}
				return ms;
			}else {
				throw new Exception("Erro ao executar stream da musica");
			}
			
			//JSONObject resultado = cmd.PesquisarRetornandoObjeto(); 
			//if(resultado != null) {
				//if(resultado.has("error"))
					//throw new Exception(resultado.getString("error"));
				//else
					//musica = this.decode(resultado);
					//return musica;
	//		}else {throw new Exception("Erro ao executar stream da musica ");}
		}catch(Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}
	
	private File decode(JSONObject musica) throws Exception {
		try {
			byte[] decoded = Base64.getDecoder().decode(musica.getString("musica"));
			File _tmp = new File(musica.getString("nome"));
			FileOutputStream os = new FileOutputStream(_tmp, true);
	        os.write(decoded);
	        os.close();
			return _tmp;
	        
		}catch(Exception e) {
			throw new Exception("Erro ao pegar musicas do servidor");
		}
	}

}
