package Functions;
import Static.App;
import Objetos.Usuario;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BancodeDados.ServerMysql;
import BancodeDados.MysqlDAO;

public class Logar {

	private ServerMysql bd = new ServerMysql();
	
	public boolean start(String email, String senha) throws Exception {
		try {
			Usuario _tempUsuario = new Usuario();
			
			HashMap<String,Object> parametros = new HashMap<String,Object>();
			parametros.put("email", email);
			parametros.put("senha", senha);
			
	        URL url = new URL(App._logar);
	        _tempUsuario = (Usuario) Autenticar(url, parametros);
	        
	        if(_tempUsuario != null) {
	        	App._usuario = _tempUsuario;
				return true;
	        }else {
	        	return false;
	        }
	        
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	
	public Usuario Autenticar(URL url, HashMap<String, Object> parametros) throws Exception {
		
		try {
			ServerMysql mysql = new ServerMysql();
			Usuario _usuario = new Usuario();
			Gson gson = new Gson();
			
			java.lang.reflect.Type usuarioType = new TypeToken<Usuario>() {}.getType();
			
			String resultado = mysql.Executa(url, parametros);
			_usuario = gson.fromJson(resultado, usuarioType);
			return _usuario;
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
