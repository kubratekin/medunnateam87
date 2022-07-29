package stepdefinitions.dbsteps;

import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.PhysicianPage;
import utilities.DBUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class US18_DBStepDefs {
    static List<WebElement> tableBody;
    static String bloodGroup;
    PhysicianPage physicianPage = new PhysicianPage();
    static Map<String, Object> result;


    @Then("eh User retrieves physician details for each physician retrieved earlier from the UI and verifies the returned information matches with the edited data.")
    public void siUserRetrievesPhysicianDetailsForEachPhysicianRetrievedEarlierFromTheUIAndVerifiesTheReturnedInformationMatchesWithTheEditedData() {
        List<String> columnNames = new ArrayList<>();
        columnNames.add("first_name");
        columnNames.add("last_name");
        columnNames.add("birth_date");
        columnNames.add("phone");
        columnNames.add("gender");
        columnNames.add("blood_group");
        columnNames.add("adress");
        columnNames.add("speciality");
        columnNames.add("exam_fee");
        columnNames.add("description");
        columnNames.add("created_date");

        for (WebElement record : tableBody) {
            String id = record.findElement(By.tagName("td")).getText();
            String physicianRecord = record.getText();
            for (String column : columnNames) {
                String query = "Select "+ column+" FROM PHYSICIAN WHERE ID = " + id;
                List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap(query);
                result = queryResultMap.get(0);
                Assert.assertEquals(1, queryResultMap.size());
                if (column.equals("blood_group")) {
                    switch (result.get(column).toString()) {
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
                    Assert.assertTrue(physicianRecord.contains(bloodGroup));
                    break;
                } else if (column.contains("date")) {
                    String date = result.get(column).toString();
                    String dateAfterFormat = date.substring(8,10) + "/" + date.substring(5,7) +"/"+ date.substring(2,4);
                    Assert.assertTrue(physicianRecord.contains(dateAfterFormat));
                } else {
                    Assert.assertTrue(physicianRecord.contains(result.get(column).toString()));
                }
            }
        }
    }

    @Then("User retrieves the info for all Physicians from the first page of UI")
    public void userRetrievesTheInfoForAllPhysiciansFromTheFirstPageOfUI() {

        tableBody = physicianPage.tableBody;
    }
}
