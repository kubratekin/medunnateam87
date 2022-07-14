package stepdefinitions.dbsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DBUtils;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DBUtils.createConnection;
import static utilities.DBUtils.getColumnData;

public class AppointmentDBStepDefs {

    List<Object> appointmentListEmail = new ArrayList<>();

    @Given("user sets a connection with database")
    public void user_sets_a_connection_with_database() {
        //createConnection("jdbc:postgresql://medunna.com:5432/medunna_db", "medunnadb_user","Medunnadb_@129");
        DBUtils.createConnection();
    }

    @And("user selects all {string} column data")
    public void user_selects_all_column_data(String email) {
        appointmentListEmail = getColumnData("Select * from appointment a, patient p  \n" +
                "where a.patient_id = p.id", email);
        System.out.println(appointmentListEmail);
        System.out.println("appointmentListId.size() = " + appointmentListEmail.size());
    }

    @Then("user validates appointment {string} with the database")
    public void user_validates_appointment_ids_with_the_database(String email) {
        //System.out.println("appointmentListEmail.contains(email) = " + appointmentListEmail.contains(email));
        assertTrue(appointmentListEmail.contains(email));
    }


}



