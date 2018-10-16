package Functions;
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
			
	        URL url = new URL("http://localhost/teste.php");

			JSONArray dados = bd.Select(url, parametros);
			JSONObject _tmp;
			
			for(int i = 0; i <= dados.length(); i++) {
				_tmp = (JSONObject) dados.get(i);
				break;
			}
			return true;
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
}
