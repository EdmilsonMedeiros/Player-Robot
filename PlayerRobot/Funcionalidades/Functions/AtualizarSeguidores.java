package Functions;

import java.net.URL;
import java.util.HashMap;
import Static.App;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BancodeDados.ServerMysql;
import Objetos.Usuario;

public class AtualizarSeguidores {
	
	//Classe Resposavel pelo Envio e Retorno no Servidor
	private ServerMysql bd = new ServerMysql();
	//Método Responsavel por atualizar os Seguidores do usuario no pacote statico
	//e enviar um true ou false confirmando a atualização 
	public boolean atualizar() throws Exception {
		try {
			//Parametros passados para o webservice
			HashMap<String,Object> parametros = new HashMap<String,Object>();
			parametros.put("id", App._usuario.getId());
			//Url de envio. Todas as URL estão na classe statica
			URL url = new URL(App._Seguidores);
			//Retorno do JSON objeto
			JSONObject _tmp = this.popular(url,parametros);
			//Confirma se o objeto retornado não é igual a null
			if(_tmp != null) {
				//Confirma que o objeto retornado não contem a chave erro. 
				//Caso contenha, sera enviado como uma exception
				if(_tmp.has("error")) {
					throw new Exception(_tmp.getString("error"));
				}
				
				//Se tudo estiver okey.. será atualidado os seguidores e retornado true
				App._usuario.setQtdSeguidores(_tmp.getString("qtdSeguidores"));
				App._usuario.setQtdSeguindo(_tmp.getString("qtdSeguindo"));
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	//Método responsavel por popular um objeto JSON
public JSONObject popular(URL url, HashMap<String, Object> parametros) throws Exception {
		
		try {
			ServerMysql mysql = new ServerMysql();
			Usuario _usuario = new Usuario();
			Gson gson = new Gson();
			
			
			String resultado = mysql.Executa(url, parametros);
			JSONObject temp = new JSONObject(resultado);
			return temp;
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
