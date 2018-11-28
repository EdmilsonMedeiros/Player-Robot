package PR_Metodos_Usuario;

import PR_Metodos_PlayList.PegarPlayListFavorito;
import PR_Musica.PlayList;
import PR_TimeLifeApp.TimeLifeApp;
import PR_Metodos_PlayList.FavoritarMusica;
public class MetodosUsuarioController {
	
	public boolean LogarUsuario(String usuario, String senha) throws Exception
	{
		try 
		{
			LogarNoSistema ln = new LogarNoSistema();
			ln.AutenticaUsuario(usuario, senha);
			this.PegarPlayListFavoritos(TimeLifeApp._usuario.getId());
			return true;
		}catch(Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}
	public void AtualizarSeguidores(int id) throws Exception
	{
		try 
		{
			AtualizarSeguidores as = new AtualizarSeguidores(id);
			TimeLifeApp._usuario.setQtdSeguindo(as.getSeguindo());
			TimeLifeApp._usuario.setQtdSeguidores(as.getSeguidores());
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	public void PegarPlayListFavoritos(int id) throws Exception 
	{
		try 
		{
			PegarPlayListFavorito pplf = new PegarPlayListFavorito();
			TimeLifeApp._usuario.setFavorito(pplf.RetornarPlayListFavorito(id));
						
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	public void FavoritarMusica(int id, int playlistId) throws Exception
	{
		try 
		{
			FavoritarMusica fm = new FavoritarMusica();
			fm.FavoritarMusica(id,playlistId);
		}catch(Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}
}
