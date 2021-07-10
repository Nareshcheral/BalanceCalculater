package StepDefinitions;

import Pages.HomePage;
import Utils.Logic_Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Balance_Calculater_Steps {
Logic_Utils utils= new Logic_Utils();
HomePage page= new HomePage();

@Given("^user launch \"([^\"]*)\" browser$")
public void launch_browser(String browser) {
	utils.open_browser(browser);
}

@Given("^User open homepage of exercise application$")
public void login_homepage_exercise_app() {
	utils.navigate_url();
}


@When("^user sum the all the values from value1 to value5$")
public void sum_all_values() {
	utils.sum_of_values();
}

@Then("^verify the count of values appear on the page as \"([^\"]*)\"$")
public void verify_count_values_on_page(int count_value) {
	utils.verify_count_of_values(count_value);
}


@Then("^verify the values on the screen are greater than \"([^\"]*)\"$")
public void verify_values(String value) {
	utils.verify_currency_value_isNot_zero(value);
}


@Then("^verify the values are formatted as currencies$")
public void verify_values_format() {
	utils.verify_currency_format();
}

@Then("^verify the sum of values is equal to Total Balance$")
public void verify_count_values_with_TotalBalance() {
	utils.verify_sumValues_with_TotalBalance();
}

}