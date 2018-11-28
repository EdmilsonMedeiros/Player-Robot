package PR_Metodos_PlayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import PR_BancodeDados.ExecutaComandos;
import PR_Metodos_Musica.PegarImage;
import PR_Musica.Musica;
import PR_Musica.PlayList;
import PR_Musica.PlayListTipo;
import PR_TimeLifeApp.TimeLifeApp;

public class PegarPlayListFavorito {
	
	public PlayList RetornarPlayListFavorito(int idUsuario) throws Exception 
	{
		try 
		{
			PlayList pl   = new PlayList();
			PegarImage        getImagem       = new PegarImage();
			Gson     gson = new Gson();
			ExecutaComandos cmd = new ExecutaComandos(TimeLifeApp._PlayListFavoritos);
			cmd.AdicionarParamentros("escolha", "get");
			cmd.AdicionarParamentros("id", idUsuario);
			
			JSONArray  resultado = cmd.PesquisarRetornandoArray();
			JSONObject descricao = resultado.getJSONObject(0).getJSONObject("descricao");
			JSONObject tipo      = resultado.getJSONObject(0).getJSONObject("tipo");
			JSONArray  musicas   = resultado.getJSONObject(0).getJSONArray("musicas");
			
			pl.setId(descricao.getInt("Id"));
			pl.setNome(descricao.getString("Nome"));
			pl.setDescricao(descricao.getString("Descricao"));
			pl.setUrlImagem(descricao.getString("UrlImagem"));
			pl.setImagem(getImagem.getImage(pl.getUrlImagem()));
			
			int idUsuarioFinal = Integer.parseInt(descricao.getString("Usuario"));
			if(idUsuarioFinal == TimeLifeApp._usuario.getId()) 
			{
				pl.setUsuario(TimeLifeApp._usuario);
			}else {
				pl.setUsuario(null);
			}
			
			PlayListTipo plt = new PlayListTipo();
			plt.setId(tipo.getInt("Id"));
			plt.setDescricao(tipo.getString("Descricao"));
			pl.setTipo(plt);
			
				for(int i = 0; i < musicas.length(); i++)
				{
					Musica ms = new Musica();
					java.lang.reflect.Type Musicatype = new TypeToken<Musica>() {}.getType();
					ms = gson.fromJson(musicas.getJSONObject(i).toString(), Musicatype);
					ms.setImagem(getImagem.getImage(ms.getUrlDaImagem()));
					pl.add(ms);
				}
			
			return pl;
		}catch(Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}
}
