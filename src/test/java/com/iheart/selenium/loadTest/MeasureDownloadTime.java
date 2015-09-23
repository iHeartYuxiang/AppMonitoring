package com.iheart.selenium.loadTest;


import com.iheart.selenium.loadTest.*;


import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*; 

import org.junit.Test; 
import org.junit.Ignore; 
import org.junit.Before; 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class MeasureDownloadTime {
	
	
	 WebDriver driver;
		
		HomePage homePage;
		
		
		String browser = "firefox";
		//String browser = "chrome";
		
		 
		final String URL = "http://beta.iheart.com";
		//final String URL = "http://www.iheart.com";
		
		Long startTime; 
		Long endTime;
		Long loadTime;
		
	   // Map loadTimes;
		static List loadTimes;
		
		@Rule public TestName name = new TestName();
		
		@BeforeClass
		public static void prepare()
		{
			loadTimes = new ArrayList<Long>();
		}
		
		@Before
	    public void init() {
			 driver = Utils.createWebDriver(browser);
			 Page.setDriver (driver);
	        homePage = PageFactory.initElements(driver, HomePage.class);
	      
	        Page.getErrors().delete(0, Page.getErrors().length());
	        
	    }
		
		
		 @Ignore("skip")
	     public void measureLoadTime() throws Exception
	     {   
	         System.out.print( name.getMethodName() +":" );
	         try{
	        	 
	        	 for (int i = 0; i < 10; i++)
	        	 {	 
	        		 measureNow();
	        		 Thread.sleep(5000);
	        	 }
	 			
	         }catch(Exception e)
	         {
	             handleException(e);
	         }  
	         
	         System.out.println("Load times:" + loadTimes.toString());
	         System.out.println("Average time:" + calculateAverage(loadTimes));
	         
	         System.out.println(name.getMethodName() + " is Done.");
	     }
		 
		 
		 @Test
	     public void measure_1() throws Exception
	     {   
			 System.out.print( name.getMethodName() +":" );
	          measureNow();
	        
	     }
		
		 @Test
	     public void measure_2() throws Exception
	     {   
			 System.out.print( name.getMethodName() +":" );
	          measureNow();
	         
	     }
		 
		 @Test
	     public void measure_3() throws Exception
	     {   
			 System.out.print( name.getMethodName() +":" );
	          measureNow();
	         
	     }
		
		 @Test
	     public void measure_4() throws Exception
	     {   
			 System.out.print( name.getMethodName() +":" );
	          measureNow();
	         
	     }
		 
		 
		 @Test
	     public void measure_5() throws Exception
	     {   
			 System.out.print( name.getMethodName() +":" );
	          measureNow();
	         
	     }
		
		 @Test
	     public void measure_6() throws Exception
	     {   
			 System.out.print( name.getMethodName() +":" );
	          measureNow();
	         
	     }
		 
		
		  private void measureNow()
		  {
			  startTime = System.nanoTime();
	 			driver.get(URL);
	 			endTime = System.nanoTime();
	 			loadTime = (endTime - startTime)/1000000;
	 			System.out.println( loadTime + " ms");
	 			loadTimes.add(loadTime);
		  }
		 
		 private static double calculateAverage(List <Long> marks) {
			  long sum = 0;
			  if(!marks.isEmpty()) {
			    for (Long mark : marks) {
			        sum += mark;
			    }
			    return sum / marks.size();
			  }
			  return sum;
			}
		 
		  
		  
		    @After
		    public void tearDown() throws Exception{
		    	driver.quit(); 
		    	if (Page.getErrors().length() > 0)
					 fail(Page.getErrors().toString());
		    }
		 
		    @AfterClass
		    public static void printResult() throws Exception{
		    	 System.out.println("Load times:" + loadTimes.toString());
		         System.out.println("Average time:" + calculateAverage(loadTimes));
		         
		    }
		    
		    private void handleException(Exception e)
		    {   Page.getErrors().append("Exception is thrown.");
		        e.printStackTrace();
	            try{
		    	   Page.takeScreenshot(driver, name.getMethodName());
	            }catch(Exception eX)
	            {
	            	
	            }
		    }
		    
	
	
	

}
