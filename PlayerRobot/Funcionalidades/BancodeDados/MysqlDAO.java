package BancodeDados;

import java.awt.Window.Type;
import java.net.URL;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import BancodeDados.ServerMysql;
import Objetos.Usuario;

public class MysqlDAO {

	//NOVO MÉTODO. 
	//
	//NOVA CLASSE RESPONSAVEL POR ENVIAR E RETORNA UM OBJETO
	//
	//FALTA AINDA TRATAR PARA ENVIAR QUALQUER TIPO DE OBJETO.
	
	public MysqlDAO() {}
	public Object RetornaObjeto(URL url, HashMap<String, Object> parametros) throws Exception {
		
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
