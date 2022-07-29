package stepdefinitions.apisteps;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pojos.Physician;
import utilities.ApiUtils;

import java.util.List;

public class US18_APIStepDefs {
    static List<WebElement> tableBody;
    static String bloodGroup;

    @When("eh User sends a GET request to get physician details foe each Physician with ID and verifies the returned info matches")
    public void siUserSendsAGETRequestToGetPhysicianDetailsFoeEachPhysicianWithIDAndVerifiesTheReturnedInfoMatches() {

        for (WebElement record : tableBody) {
            String id = record.findElement(By.tagName("td")).getText();
            String physicianRecord = record.getText();
            siUserSendsAGETRequestToGetPhysicianDetailsWithID(id);
            siUserVerifiesTheReturnedInformationMatchesWithTheEditedData(physicianRecord);
        }
    }

    public void siUserSendsAGETRequestToGetPhysicianDetailsWithID(String id) {
        RequestSpecification spec = ApiUtils.getSpec();
        spec.pathParams("first", "physicians", "second", id);


//        APIUtils.addBearerTokenToSpec(userName,password);
        //before api call you need to add bearer token
        //following one just add admin's bearer token to spec
        ApiUtils.addBearerTokenToSpec();

        String relativePath = "/{first}/{second}";
        ApiUtils.get(relativePath);
    }

    public void siUserVerifiesTheReturnedInformationMatchesWithTheEditedData(String recordData) {

        Response response = ApiUtils.getResponse();
        Physician physician = ApiUtils.convertJsonToJavaObject(response.asString(), Physician.class);

        switch (physician.getBloodGroup()) {
            case "Apositive":
                bloodGroup = "A+";
                break;
            case "Anegative":
                bloodGroup = "A-";
                break;
            case "Bpositive":
                bloodGroup = "B+";
                break;
            case "Bnegative":
                bloodGroup = "B-";
                break;
            case "ABpositive":
                bloodGroup = "AB+";
                break;
            case "ABnegative":
                bloodGroup = "AB-";
                break;
            case "Opositive":
                bloodGroup = "O+";
                break;
            case "Onegative":
                bloodGroup = "O-";
                break;
        }
        if (physician.getAdress() == null) {
            physician.setAdress("");
        } else if (physician.getCountry().getName() == null) {
            physician.getCountry().setName(""); }

        String birthday = physician.getBirthDate();
        String birthdateFormatted = birthday.substring(8,10) + "/" + birthday.substring(5,7) +"/"+ birthday.substring(2,4);
        Assert.assertTrue(recordData.contains(birthdateFormatted));
        Assert.assertTrue(recordData.contains(physician.getFirstName()));
        Assert.assertTrue(recordData.contains(physician.getLastName()));
        Assert.assertTrue(recordData.contains(physician.getAdress()));
        Assert.assertTrue(recordData.contains(bloodGroup));
        Assert.assertTrue(recordData.contains(physician.getGender()));
        Assert.assertTrue(recordData.contains(physician.getPhone()));
        Assert.assertTrue(recordData.contains(physician.getSpeciality()));
        Assert.assertTrue(recordData.contains(physician.getDescription()));
        String creationDate = physician.getCreatedDate();
        String creationDateFormatted = creationDate.substring(8,10) + "/" + creationDate.substring(5,7) +"/"+ creationDate.substring(0,4);
        Assert.assertTrue(recordData.contains(creationDateFormatted));
        Assert.assertTrue(recordData.contains(String.valueOf(physician.getExamFee()).substring(0,
                String.valueOf(physician.getExamFee()).indexOf("."))));
        Assert.assertTrue(recordData.contains(String.valueOf(physician.getCountry().getName())));
        Assert.assertTrue(recordData.contains(String.valueOf(physician.getCstate().getName())));

    }
}


