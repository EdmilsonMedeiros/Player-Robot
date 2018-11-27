package PR_BancodeDados;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class ExecutaComandos {
	
	private MysqlDAO conexao;
	private HashMap<String, Object> parametros;
	
	public ExecutaComandos(String URLConexao) throws Exception {
		try
		{
			URL url = new URL(URLConexao);
			parametros = new HashMap<String, Object>();
			conexao = new MysqlDAO(url); 
		}catch(Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}
	
	public JSONObject PesquisarRetornandoObjeto() throws Exception {
		try {
			
			String resultado = conexao.Executa(parametros);
			JSONObject temp = new JSONObject(resultado);
			return temp;
				
			}catch(Exception e) {
				throw new Exception(e.getMessage());
			}
	}
	public JSONArray  PesquisarRetornandoArray() throws Exception {
		try {
			
			String resultado = conexao.Executa(parametros);			
			JSONArray temp   = new JSONArray(resultado);
			return temp;
			}catch(Exception e) {
				throw new Exception(e.getMessage());
			}
	}
	public String PesquisarRetornandoString() throws Exception 
	{
		try 
		{
			return conexao.Executa(parametros);
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	public void AdicionarParamentros(String Paramentro, Object Valor) throws Exception 
	{
		try 
		{
			parametros.put(Paramentro,Valor);	
		}catch(Exception e) {
			throw new Exception("Erro ao adicionar o paramentro: "+Paramentro);
		}
	}
}
