package PR_Metodos_Usuario;

import PR_TimeLifeApp.TimeLifeApp;

public class MetodosUsuarioController {
	
	public boolean LogarUsuario(String usuario, String senha) throws Exception
	{
		try 
		{
			LogarNoSistema ln = new LogarNoSistema();
			return ln.AutenticaUsuario(usuario, senha);
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
}
