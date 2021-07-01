package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AccountPage;
import pages.LoginPage;

public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credentialTable) {
		List<Map<String, String>> credentialList = credentialTable.asMaps();
		String username = credentialList.get(0).get("username");
		String password = credentialList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountPage = loginPage.doLogin(username, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountPage.getAccountPageTitle();
		System.out.println("Account page title: " + title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionList) {
		List<String> expectedAccountSectionList = sectionList.asList();
		System.out.println("Expected account section list: " + expectedAccountSectionList);
		List<String> actualAccountSectionList = accountPage.getAccountSectionList();
		System.out.println("Actual account section list: " + actualAccountSectionList);
		
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountPage.getAccountSectionCount() == expectedSectionCount);
	}

}
