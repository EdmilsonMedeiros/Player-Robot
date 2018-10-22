package Functions;
import Static.App;
import Objetos.Usuario;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import BancodeDados.Mysql;

public class Logar {

	private Mysql bd = new Mysql();
	
	public boolean start(String email, String senha) throws Exception {
		try {
			
			HashMap<String,Object> parametros = new HashMap<String,Object>();
			parametros.put("email", email);
			parametros.put("senha", senha);
			
	        URL url = new URL(App._logar);

			JSONArray dados = bd.Select(url, parametros);
			JSONObject _tmp = null;
			
			for(int i = 0; i <= dados.length(); i++) {
				_tmp = (JSONObject) dados.get(i);
				break;
			}
			
			if(_tmp != null) {
				
				if(_tmp.has("error")) {
					throw new Exception(_tmp.getString("error"));
				}
				
				int    _id = Integer.parseInt(_tmp.getString("id"));
				String _nick = _tmp.getString("nick");
				String _nome = _tmp.getString("nome");
				String _email = _tmp.getString("email");
				String _telefone = _tmp.getString("telefone");
				
				Usuario _tempUsuario = new Usuario(_id,_nick,_email,_nome,_telefone,"");
				_tempUsuario.setQtdSeguidores(_tmp.getString("qtdSeg"));
				_tempUsuario.setQtdSeguindo(_tmp.getString("qtdSegd"));
				App._usuario = _tempUsuario;
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
}
