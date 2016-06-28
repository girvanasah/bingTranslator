package webServ;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TokenObtain extends WebServices
{
	String getToken(String token)
	{
		JSONParser jsonparser = new JSONParser();
		try {
			Object obj = jsonparser.parse(token);
			JSONObject jsonobj = (JSONObject) obj;
			token = (String) jsonobj.get("access_token");
			System.out.println(token);
			duration = Integer.parseInt((String) jsonobj.get("expires_in"));
			System.out.println(duration);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return token;
	}
}

