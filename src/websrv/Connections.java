package webServ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class Connections extends WebServices
{
	public String connection_establish(String clientId, String clientSecret, String scope, String grantAccess) {
		try {
			this.clientId = clientId;

			this.clientSecret = clientSecret;
			this.scope = scope;
			this.grantAccess = grantAccess;
//			this.request = ("grant_type=" + this.grantAccess + "&client_id=" + this.clientId + "&client_secret="
//					+ this.clientSecret + "&scope=" + this.scope).toString();
			String url = "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13";

			HttpClient cli = HttpClientBuilder.create().build();

			HttpPost post = new HttpPost(url);

			post.setHeader("User-Agent", USER_AGENT);

			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("client_id", clientId));
			urlParameters.add(new BasicNameValuePair("grant_type", grantAccess));
			urlParameters.add(new BasicNameValuePair("client_secret", clientSecret));
			urlParameters.add(new BasicNameValuePair("scope", scope));

			post.setEntity(new UrlEncodedFormEntity(urlParameters));

			HttpResponse response = cli.execute(post);
//			System.out.println("\nSending 'POST' request to URL : " + url);
//			System.out.println("Post parameters : " + post.getEntity());
//			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null)
			{
				result.append(line);
			}
			result1 = result.toString();
			System.out.println(result1);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result1;
	}
}

