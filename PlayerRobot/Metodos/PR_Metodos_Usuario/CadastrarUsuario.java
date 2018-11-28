package PR_Metodos_Usuario;

import org.json.JSONObject;

import PR_BancodeDados.ExecutaComandos;
import PR_TimeLifeApp.TimeLifeApp;

public class CadastrarUsuario {
	public String Cadastrar(String nome, String usuario,String email, String senha) throws Exception 
	{
		try 
		{
			ExecutaComandos cmd = new ExecutaComandos(TimeLifeApp._CadastrarUsuario);
			cmd.AdicionarParamentros("nome", nome);
			cmd.AdicionarParamentros("usuario", usuario);
			cmd.AdicionarParamentros("email", email);
			cmd.AdicionarParamentros("senha", senha);
			
			JSONObject resultado = cmd.PesquisarRetornandoObjeto();
			if(resultado.has("error")) {
				throw new Exception(resultado.getString("error"));
			}
			
			return resultado.getString("ok");
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
}
