package problrm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Translate 
{ 
	public static void main(String[] args) throws InterruptedException, IOException{
		ArrayList<String> result=Ui();
		System.out.println(result);
	}
    public static ArrayList<String> Ui() throws InterruptedException, IOException
	 {
    	String compare1=null;
		ArrayList<String> resultUi=new ArrayList<>();
		 WebDriver driver = new FirefoxDriver();
		 driver.get("https://www.bing.com/translator");
		 //driver.findElement(By.cssSelector(".LS_Header")).click();
			       File file =new File("/home/anshulgarg/Downloads/input.csv");
				   FileReader fr= new FileReader (file);
				   @SuppressWarnings("resource")
				BufferedReader bufferedReader = new BufferedReader(fr);
				   String line; 
				  
				   int j=0;
				   while ((line = bufferedReader.readLine()) != null) 
				   {
					   	List<WebElement> l1 =driver.findElements(By.className("LS_Header"));
					   	List<WebElement> list = driver.findElements(By.tagName("td")); 
						String [] bing = line.split(",");
						if(line.charAt(0)==',')
						{
							driver.findElement(By.id("srcText")).sendKeys(bing[2]);
							l1.get(1).click();
							while(!(list.get(j).getText().equalsIgnoreCase(bing[0])))
							{
								j+=1;
							}
							list.get(j).click();
							driver.findElement(By.id("TranslateButton")).click();
							Thread.sleep(1000);
						 compare1= driver.findElement(By.id("destText")).getText();
						}
						else
						{
							l1.get(0).click();
							Thread.sleep(2000);
							while(!(list.get(j).getText().equalsIgnoreCase(bing[0])))
							{
								j+=1;
							}
							Thread.sleep(2000);
							list.get(j).click();
							driver.findElement(By.id("srcText")).sendKeys(bing[2]);
							driver.findElement(By.id("TranslateButton")).click();
							compare1= driver.findElement(By.id("destText")).getText();
                       }
						//to dropdown
					
						
						while(!(list.get(j).getText().equalsIgnoreCase(bing[1])))
						{
							j+=1;
						}
								Thread.sleep(2000);
						//		list.get(j).click();
								Thread.sleep(2000);
	//							driver.findElement(By.id("TranslateButton")).click();
								Thread.sleep(1000);
						//	    compare1= driver.findElement(By.id("destText")).getText();
		          	resultUi.add(compare1);
				   }
			 return resultUi;
         }
}
