package PR_Metodos_PlayList;

import org.json.JSONObject;

import PR_BancodeDados.ExecutaComandos;
import PR_TimeLifeApp.TimeLifeApp;

public class FavoritarMusica {
	public boolean FavoritarMusica(int idmusica, int idplaylist) throws Exception 
	{
		try {
			ExecutaComandos cmd = new ExecutaComandos(TimeLifeApp._FavoritarMusica);
			cmd.AdicionarParamentros("idMusica", idmusica);
			cmd.AdicionarParamentros("idplay", idplaylist);
			JSONObject obj = cmd.PesquisarRetornandoObjeto();
			if(obj.has("error")) {
				throw new Exception(obj.getString("error"));
			}
			
			return false;
		}catch(Exception e)
		{
			throw new Exception("Erro ao Favoritar Musica");
		}
	}
}
