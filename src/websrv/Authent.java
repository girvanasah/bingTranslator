package webServ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class Authent extends WebServices
{
	public Authent(String from , String to , String text, String finaltoken) 
	{XMLParsing xml;
			String url = "http://api.microsofttranslator.com/V2/Http.svc/Translate?text="+ text + "&from=" + from + "&to=" + to;
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);
			
			try 
			{
			// add request header
				
				finaltoken = "Bearer " + finaltoken;
				request.addHeader("Authorization", finaltoken);
				System.out.println("heyaaa"+finaltoken);
				HttpResponse response = client.execute(request);

				System.out.println("\nSending 'GET' request to URL : " + url);
				System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) 
				{
					result.append(line);
				}
				xml=new XMLParsing();
//				result1 = result.toString();
				System.out.println(result);
				xml.parseXML(result);
			// FileWriter file=new FileWriter("xml1.xml");
			// file.write(result1);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
}

