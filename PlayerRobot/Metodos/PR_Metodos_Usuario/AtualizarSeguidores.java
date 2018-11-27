package PR_Metodos_Usuario;

import org.json.JSONObject;
import PR_BancodeDados.ExecutaComandos;
import PR_TimeLifeApp.TimeLifeApp;

class AtualizarSeguidores{
	private String _getSeguidores;
	private String _getSeguindo;
	
	public AtualizarSeguidores(int idUsuario) throws Exception
	{
		try 
		{
			ExecutaComandos cmd = new ExecutaComandos(TimeLifeApp._Seguidores);
			cmd.AdicionarParamentros("id", idUsuario);
			JSONObject objUser = cmd.PesquisarRetornandoObjeto();
			
			if(objUser != null) {
				if(objUser.has("error")) {
					throw new Exception(objUser.getString("error"));
				}
				
				this._getSeguidores = objUser.getString("qtdSeguidores");
				this._getSeguindo   = objUser.getString("qtdSeguindo");
			}	
		}catch(Exception e)
		{
			throw new Exception("Erro ao atualizar seguidores");
		}
	}
	
	
	public String getSeguidores() 
	{
		return this._getSeguidores;
	}
	public String getSeguindo()
	{
		return this._getSeguindo; 
	}
}
