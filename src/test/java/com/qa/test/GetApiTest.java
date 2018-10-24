/**
 * 
 */
package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

/**
 * @author manish
 *
 */
public class GetApiTest extends TestBase {
	TestBase testBase;
	String serviceUrl;
	String appUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closebaleHttpResponse;
	
	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException {
		testBase = new  TestBase();
		serviceUrl = prop.getProperty("URL");
		appUrl = prop.getProperty("serviceURL");
		
		url = serviceUrl + appUrl;
		
	}
	
	@Test(priority=1)
	public void getAPITestWithoutHeaders() throws ClientProtocolException, IOException{
		restClient = new RestClient();
		closebaleHttpResponse = restClient.get(url);
		
		//a. Status Code:
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code--->"+ statusCode);
		

		//b. Json String:
		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response JSON from API---> "+ responseJson);
		
		
		
		
		
	}

}
