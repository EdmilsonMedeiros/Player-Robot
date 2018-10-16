package BancodeDados;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class Mysql {

	public JSONArray Select(URL url, HashMap<String, Object> parametros) throws Exception {
		
		try {
			
			//Preparar Parametros POST
			StringBuilder postData = new StringBuilder();
	        for(HashMap.Entry<String,Object> param : parametros.entrySet()){
	            if(postData.length() >= 0){
	                postData.append('&');
	                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	                postData.append('=');
	                postData.append(URLEncoder.encode(String.valueOf(param.getValue().toString()),"UTF-8"));
	            }
	        }
	        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	        
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        
	        conn.getOutputStream().write(postDataBytes);
	        
	        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
	        StringBuilder sb = new StringBuilder();
	        for(int c; (c = in.read()) >= 0;){
	            sb.append((char) c);
	        }
	        
	        JSONArray array = new JSONArray(sb.toString());
	        return array;
	        
			
		}catch(Exception e) {
			throw new Exception("Erro na pesquisa");
		}
		
	}
}
