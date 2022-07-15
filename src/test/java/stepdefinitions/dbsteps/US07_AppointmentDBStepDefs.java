package stepdefinitions.dbsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DBUtils.getColumnData;

public class US07_AppointmentDBStepDefs {

    List<Object> appointmentListEmail = new ArrayList<>();

    @Given("user set a connection with database")
    public void user_sets_a_connection_with_database() {

        DBUtils.createConnection();
    }

    @And("user select all {string} column data")
    public void user_selects_all_column_data(String email) {
       appointmentListEmail = getColumnData("Select * from appointment a, patient p  \n" +
                "where a.patient_id = p.id", email);
        System.out.println(appointmentListEmail);
        System.out.println("appointmentListId.size() = " + appointmentListEmail.size());
}

    @Then("user validates appointment {string} with the database")
    public void user_validates_appointment_ids_with_the_database(String email) {

        assertTrue(appointmentListEmail.contains(email));
    }

}



