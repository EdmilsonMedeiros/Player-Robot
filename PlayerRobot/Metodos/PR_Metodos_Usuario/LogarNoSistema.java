package PR_Metodos_Usuario;

import org.json.JSONObject;
import PR_Usuario.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import PR_BancodeDados.ExecutaComandos;
import PR_TimeLifeApp.TimeLifeApp;


class LogarNoSistema {
	public boolean AutenticaUsuario(String usuario, String senha)throws Exception
	{
		try 
		{
			Gson 				   gson		   = new Gson();
			java.lang.reflect.Type usuarioType = new TypeToken<Usuario>() {}.getType();
			ExecutaComandos cmd = new ExecutaComandos(TimeLifeApp._logar);
			cmd.AdicionarParamentros("email", usuario);
			cmd.AdicionarParamentros("senha", senha);
			String resultado = cmd.PesquisarRetornandoString();
			
			//Parte 1 verificar se possui erro:
			JSONObject temp = new JSONObject(resultado);
			if(temp.has("error")) {
				throw new Exception(temp.getString("error"));
			}
			
			Usuario _usuario = gson.fromJson(resultado, usuarioType);
			if(TimeLifeApp._usuario == null) 
			{
				TimeLifeApp._usuario = _usuario;
				return true;
			}else
			{
				throw new Exception("Erro ao autenticar usuario");
			}
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
}
