package webServ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class ReadFromFile extends WebServices
{	Connections con;
	TokenObtain tokn;
	
	String token;
	String finaltoken;
	String from;
	String to;
	String text;
	String fromCode;
	String toCode;
	ArrayList<String> resultFromAPI=new ArrayList<>();
	ArrayList<String> fileRead()
	{	
		try{ 
			String csvFile = "/home/girvanasahchaurasia/Downloads/input.csv";
			String csvFile1 = "/home/girvanasahchaurasia/Downloads/codes.csv";
			BufferedReader br1=null;
			BufferedReader br = null;
			String line = "";
			String line1 = "";
			String cvsSplitBy = ",";
			String[] inputValues = null;
			String[] inputValues1 = null;
			br = new BufferedReader(new FileReader(csvFile));
			br1 = new BufferedReader(new FileReader(csvFile1));
			HashMap<String, String> arr=new HashMap<>();
			while ((line1 = br1.readLine()) != null)
			{ 
//				codeTuple cd = new codeTuple( null , null );
				inputValues1 = line1.split(cvsSplitBy);
				arr.put(inputValues1[1], inputValues1[0]);
//				cd.sety(inputValues1[1]);
//				arr.add(cd);
			}
			con=new Connections();
			tokn=new TokenObtain();
			
			token=con.connection_establish("girvanasah", "DW2ivRcDTaqHC9PoYuR1Xj3fXdpYCRS11NY2PAg8axI=",
					"http://api.microsofttranslator.com", "client_credentials");
		
			finaltoken=tokn.getToken(token);
			int j=0;
			while ((line = br.readLine()) != null) {
              
				inputValues = line.split(cvsSplitBy);
				 from=inputValues[0];
				 to=inputValues[1];
				 text = inputValues[2];
				 if(from.isEmpty()){
					 from=Translate.lang_from_DropDown.get(j);
				 }
				 if(arr.containsKey(from)){
					 fromCode=arr.get(from);
				 }
				 if(arr.containsKey(to)){	
					 toCode=arr.get(to);
				 }
								
				getAuthentication( fromCode , toCode , text,finaltoken);
				j++;
		
			}	
		}
		catch (Exception e){}
	return	resultFromAPI;
	}
	public void getAuthentication(String from , String to , String text, String finaltoken) throws UnsupportedEncodingException 
	{
		
		XMLParsing xml;
	System.out.println(from+" "+to);
			String url = "http://api.microsofttranslator.com/V2/Http.svc/Translate?text="+  URLEncoder.encode(text,"UTF-8") + "&from=" + from + "&to=" + to;
			
			HttpClient client = HttpClientBuilder.create().build();
			
			HttpGet request = new HttpGet(url);
			
			try 
			{
			// add request header
				
				finaltoken = "Bearer " + finaltoken;
				request.addHeader("Authorization", finaltoken);
//				System.out.println("heyaaa"+finaltoken);
				HttpResponse response = client.execute(request);

//				System.out.println("\nSending 'GET' request to URL : " + url);
//				System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

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
				String resultBing=xml.parseXML(result);
				resultFromAPI.add(resultBing);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
}

