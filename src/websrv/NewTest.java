package webServ;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class NewTest
{ 
	ArrayList<String> resultFromApi=new ArrayList<>();
	ArrayList<String> resultFromUi=new ArrayList<>();

	@BeforeTest
	public void initializeBingAutomate() throws Exception
	{
		Translate trans=new Translate();
		resultFromUi=trans.automateBingMethod();
		WebServices bing=new WebServices();
		resultFromApi=bing.webServ();
		
	}
		
	@Test
  public void testBing() 
	{
      for(int i=0;i<resultFromUi.size();i++){
		Assert.assertEquals(resultFromUi.get(i), resultFromApi.get(i) , "Not match");
		Reporter.log("Matched", true);
      }
  }
}
