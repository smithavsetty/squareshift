package squareshift.sampleProject;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageobjects.HeadLinePage;
import pageobjects.MainPage;
import util.BaseClass;

public class News extends BaseClass {

	private static final String url = "https://www.channelnewsasia.com/";
	private static final String interurl = "https://www.channelnewsasia.com/international";

	@Test(priority = 1)
	public void scenario1() throws Exception {
		MainPage mp = new MainPage(driver);
		HeadLinePage hp = new HeadLinePage(driver);
		mp.launchUrl(url);
		maximizePage();
		waitForPageToLoad(20);
		String expected = mp.getLatestHeadLine();
		Reporter.log("Expected Latest Headline is :" + expected);
		mp.clickLatestHeadLine();
		waitForPageToLoad(10);
		String actual = hp.getPageTitle();
		Reporter.log("Actual Latest Headline is :" + actual);
		Assert.assertTrue(actual.contains(expected), "Wrong Title");
		hp.scrollInToSecondExpandBtn();
		hp.clickSecondExpandBtn();
	}

	@Test(priority = 2)
	public void scenario2() throws Exception {
		MainPage mp = new MainPage(driver);
		HeadLinePage hp = new HeadLinePage(driver);
		mp.launchUrl(interurl);
		maximizePage();
		waitForPageToLoad(20);
		mp.selectSingapore();
		String expected = mp.getLatestHeadLineSingapore();
		Reporter.log("Expected Latest Singapore Headline is :" + expected);
		mp.clickLatestHeadLineSingapore();
		String actual = hp.getPageTitle();
		Reporter.log("Actual Latest Singapore Headline is :" + actual);
		Assert.assertTrue(actual.contains(expected), "Wrong Title");
		hp.scrollInToSecondExpandBtn();
		hp.clickSecondExpandBtn();
	}

	@Test(priority = 3)
	public void scenario3() throws Exception {
		MainPage mp = new MainPage(driver);
		mp.launchUrl(interurl);
		maximizePage();
		waitForPageToLoad(20);
		mp.selectAllSections();
		mp.clickWeather();
		Reporter.log("Singapore Weather is :" + mp.captureSingaporeWeather());
	}

	@AfterClass
	public void close() {
		closeBrowser();
	}
}
