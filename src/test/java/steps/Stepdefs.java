package steps;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class Stepdefs {

    private ValidatableResponse validatableResponse;

    private String endpoint = ConfigFileReader.getProperty("url");

    @Given("I have a valid URL")
    public void iHaveAValidURL() {
        System.out.println("Endpoint: " + ConfigFileReader.getProperty("url"));

        Assert.assertFalse(ConfigFileReader.getProperty("url").isEmpty());
        Assert.assertNotNull(ConfigFileReader.getProperty("url"));
    }

    @When("a POST request is made to {string} with payload : {string} , {string} ,{string} ,{string} ,{string} ,{string}")
    public void aPOSTRequestIsMadeToWithPayload(String path, String age, String gender, String highestQualification, String jobRole, String salaryRands, String tobaccoUsage) {
        JSONObject payload = new JSONObject();
        payload.put("age", age);
        payload.put("gender", gender);
        payload.put("highestQualification", highestQualification);
        payload.put("jobRole", jobRole);
        payload.put("nonSpecificOccupationResponse", JSONObject.NULL);
        payload.put("salaryRands", salaryRands);
        payload.put("tobaccoUsage", tobaccoUsage);

        System.out.println("PayLoad: " +payload);

        validatableResponse = given().contentType(ContentType.JSON)
                .when()
                .body(payload.toString())
                .post(endpoint + path).then();

        System.out.println("Response :" + validatableResponse.extract().asPrettyString());
    }

    @Then("the response will return status {int}")
    public void theResponseWillReturnStatus(int statusCode) {
        validatableResponse.assertThat().statusCode(statusCode);
    }

    @And("Verify the Insurance Premiums is returned {int} , {int} , {int} , {int}")
    public void verifyTheInsurancePremiumsIsReturned(int lifeCoverPremium, int disabilityCoverPremium, int tempIncomeProtectionPremium, int illnessCoverPremium) {
        validatableResponse.assertThat()
                .body("benefits", hasSize(4))
                .body("benefits[0].premium", equalTo(lifeCoverPremium))
                .body("benefits[0].product", equalTo("LIFE_COVER"))
                .body("benefits[1].premium", equalTo(disabilityCoverPremium))
                .body("benefits[1].product", equalTo("DISABILITY_COVER"))
                .body("benefits[2].premium", equalTo(illnessCoverPremium))
                .body("benefits[2].product", equalTo("ILLNESS_COVER"))
                .body("benefits[3].premium", equalTo(tempIncomeProtectionPremium))
                .body("benefits[3].product", equalTo("INCOME_PROTECTION"))
                .body("comm_sacrifice.commission_fixed", equalTo(true))
                .body("comm_sacrifice.percentage.current", equalTo(0))
                .body("comm_sacrifice.percentage.max", equalTo(100))
                .body("comm_sacrifice.percentage.min", equalTo(0))
                .body("comm_sacrifice.total_cents", equalTo(0))
                .body("intermediaryCode", equalTo("A_OneSpark_OSystem_0001"));

    }
}
