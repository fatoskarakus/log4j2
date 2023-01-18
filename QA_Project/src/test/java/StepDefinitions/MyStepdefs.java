package StepDefinitions;
import Pages.*;
import Utils.Log;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.io.IOException;
import static BaseClass.BaseClass.launchApp;
import static BaseClass.BaseClass.prop;


public class MyStepdefs {
    IndexPage indexpage;
    ElmntPage elementpage;
    FormPage formPage;
    BooksPage booksPage;

    ProfilePage profilePage;

    @Given("I navigate the Homepage")
    public void i_navigate_the_homepage() throws IOException {
        launchApp();
        Log.info("Navigate to URL   " + prop.getProperty("url") + "  And Opened the Website");
    }

    @Then("Choose The Card Type")
    public void choose_the_card_type() {
        indexpage = new IndexPage();
        indexpage.clickTheElmntCrd();
        Log.info("Choosed The Card Type");

    }

    @When("Choose The Element Type")
    public void choose_the_element_type() {
        elementpage = new ElmntPage();
        elementpage.clickTheWebTables();
        Log.info("Choosed The Element Type");

    }

    @Then("See The Record Table")
    public void see_the_record_table() {
        String text = indexpage.getTittle();
        Assert.assertEquals("Web Tables", text);
        Log.info("I Navigated the BooksList Page  ");

    }

    @Then("Click the Add Button")
    public void click_the_add_button() {
        elementpage.clickTheAddBtn();
        Log.info("Clicked Add Button ");

    }

    @Then("Give the Firstname {string}")
    public void give_the_firstname(String first_name) {
        elementpage.sendTxtAdd(first_name);
        Log.info("Texted Firstname:  "+ first_name );

    }

    @Then("Give the LastName {string}")
    public void give_the_last_name(String soy_isim) {
        elementpage.sendTxtSoyAdd(soy_isim);
        Log.info("Texted Lastname:  "+ soy_isim );

    }

    @Then("Give the Email {string}")
    public void give_the_email(String email) {
        elementpage.sendTxtEmail(email);
        Log.info("Texted email:  "+ email );

    }

    @Then("Give the Age {string}")
    public void give_the_age(String age) {
        elementpage.sendTxtAge(age);
        Log.info("Texted email:  "+ age );

    }

    @Then("Give the Salary {string}")
    public void give_the_salary(String salary) {
        elementpage.sendTxtSlry(salary);
        Log.info("Texted email:  "+ salary );

    }

    @Then("Give the Department {string}")
    public void giveTheDepartment(String department) {
        elementpage.sendTxtDepartmnt(department);
        Log.info("Texted email:  "+ department );

    }

    @When("Click the Submit Button")
    public void click_the_submit_button() {
        elementpage.clickSbmtBtn();
        Log.info("Clicked the Submit Button:  " );

    }

    @Then("Delete The New Register")
    public void delete_the_new_register() throws InterruptedException {
        Thread.sleep(500);
        elementpage.deleteTheNewRcrd();
        Log.info("Deleted the new product:   " );

    }

    @And("Choose The Form Type")
    public void choose_the_form_type() {
        indexpage = new IndexPage();
        indexpage.clickTheformCrd();
        Log.info("Clicked the new form page    " );

    }

    @And("Open The Form Page")
    public void open_the_form_page() {
        formPage = new FormPage();
        formPage.clickThePrctiseForm();
        Log.info("Opened The Form Page  " );

    }

    @And("Give the Firstname")
    public void give_the_firstname() throws IOException {
        formPage.sendTheEmpFrstName();
        Log.info("Texted the Firstname:   " );

    }

    @And("Give the LastName")
    public void give_the_last_name() {
        formPage.sendTheEmpLstName();
        Log.info("Texted the Lastname:   " );

    }

    @And("Give the email")
    public void give_the_email() {
        formPage.sendTheEmail();
        Log.info("Texted the email:   " );

    }

    @And("Choose the Gender")
    public void choose_the_gender() {
        formPage.selectGender();
        Log.info("Choosed the Gender:   " );

    }

    @And("Give the Mobile Phone")
    public void give_the_mobile_phone() {
        formPage.sendTheMobileLine();
        Log.info("Texted the Mobile Phone:   " );

    }

    @And("Choose the BirthDay")
    public void choose_the_birth_day() {
        formPage.choseTheBirtDay();
        Log.info("Choosed the BirthDay:   " );

    }

    @And("Select the Hobbies")
    public void select_the_hobbies() {
        formPage.scltHobies();
        Log.info("Selected the Hobbies:   " );

    }

    @And("Download the Document")
    public void download_the_document() throws IOException {
        formPage.clcTheDownDocmt();
        Log.info("Downloaded the Document:   " );

    }

    @And("Give Current Address")
    public void give_current_address() {
        formPage.sendCrntAdress();
        Log.info("Texted the new Current Address:   " );

    }

    @When("Click the Submit Btn")
    public void click_the_submit_btn() {
        formPage.sbtBtn();
        Log.info("Clicked the Submit Btn:   " );

    }

    @Then("See the New Registration")
    public void see_the_new_registration() {
        String frmName = formPage.verfyTheRecord();
        Assert.assertEquals(frmName, prop.getProperty("recordTittle"));
        Log.info("New Registration has been verified.   " );

    }

    @And("I navigate to the Book Store Card")
    public void i_navigate_to_the_book_store_card() {
        indexpage = new IndexPage();
        indexpage.clickTheBookStrApp();
        Log.info("I navigated to the Book Store Card   " );

    }

    @And("I navigate to the Login Page")
    public void i_navigate_to_the_login_page() {
        booksPage = new BooksPage();
        booksPage.clickTheBookStoreLgnBtn();
        Log.info("I navigated to the Login Page   " );

    }

    @When("I submit username and password")
    public void i_submit_username_and_password() {
        booksPage.giveUserNameAndPass();
        Log.info("Texted username and password   " );

    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        String value = booksPage.VerifyTheLogin();
        Assert.assertEquals(value, prop.getProperty("UserName"));
        Log.info("Login is Verified   " );

    }

    @And("I navigate to the Book Store")
    public void i_navigate_to_the_book_store() {
        booksPage.goToStorePage();
        Log.info("I navigated the Books Page  " );

    }

    @Given("User search for {string}")
    public void user_search_for(String Book) {
        booksPage.searchThePrdct(Book);
        booksPage.clickTheBookLink();
        Log.info("Book details have been reached  " );

    }

    @When("Add the first book that appears in the search result to the basket")
    public void add_the_first_book_that_appears_in_the_search_result_to_the_basket() {
        booksPage.addTheYourCollection();
        Log.info("Added The Book to the Basket  " );

    }

    @Then("User basket should display with added item")
    public void user_basket_should_display_with_added_item() throws InterruptedException {
        boolean result = booksPage.seeTheAlert();
        Assert.assertEquals(true, result);
        Log.info("Product addition Pop_Up Verified   " );

    }

    @Then("Close the App")
    @After
    public void close_the_app() {
        booksPage.closeDriver();
        Log.info("Closing the Browser....   " );

    }

    @Given("User navigate for Profile Page")
    public void user_navigate_for_profile_page() {
        profilePage = new ProfilePage();
        profilePage.clickTheProfile();
        Log.info("User Navigated Profile Page   " );

    }

    @When("See and delete the Book that you added to the basket")
    public void see_and_delete_the_book_that_you_added_to_the_basket() throws InterruptedException {
        boolean result = profilePage.validateTheBook();
        Assert.assertEquals(true, result);
        profilePage.deleteTheBookBasket();
        profilePage.clickThePopUp();
        Log.info("Validated that the product has been deleted from the Basket.  " );

    }

    @Then("User basket should display empty")
    public void user_basket_should_display_empty() {
        boolean alert_result = profilePage.seeTheEmptyUserBasket();
        Assert.assertEquals(false, alert_result);
        Log.info("Validated User basket is empty   " );

    }

    @And("I log out from the App")
    public void i_log_out_from_the_app() {
        profilePage=new ProfilePage();
        profilePage.clickTheLogOutBtn();
        Log.info("Log out from the App   " );

    }

    @Then("See be log out of the app succesfull")
    public void see_be_log_out_of_the_app_succesfull() {
        String result=booksPage.seeTheWelcmeToLogin();
        Assert.assertEquals(result,prop.getProperty("loginPageTxt"));
        Log.info("Logout is Verified  " );

    }
}
