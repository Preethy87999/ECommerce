package com.simplilearn.ECommerceTest;

import org.testng.annotations.Test;

public class ApplicationTest {

	@Test
	public  void verifyApplications() throws InterruptedException  {
		Application ap = new Application();
		ap.openBrowser();
		ap.testEcommerce();
		ap.closeBrowser();
	}
}
