import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestCRM.Pages.EditProfilePage;
import com.TestCRM.Pages.LoginPage;
import com.TestCRM.TestBase.TestBase;
import com.TestCRM.TestUtils.Timers;

public class EditProfileTest extends TestBase {

	EditProfilePage editprofile;
	LoginPage loginpage;
	
	public EditProfileTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		installation();
		loginpage= new LoginPage();
		editprofile = new EditProfilePage();
		loginpage.verifyLoginButton();
		loginpage.verifyLogin();
	}
	
	@Test
	public void verifyEditProfileTest()
	{
		editprofile.updateProfile();
		editprofile.submitChnages();
	}
	
	
	@AfterMethod
	public void tearoff()
	{
		Timers.smallStaticWait();
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
}
