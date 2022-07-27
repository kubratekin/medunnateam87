package stepdefinitions.dbsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class US_027_DbStepDefs {


    @Given("FK Admin connects to the database")
    public void fk_admin_connects_to_the_database() {
        DBUtils.createConnection();
    }
    @Given("FK Admin creates a new message data with these values {string}")
    public void fk_admin_creates_a_new_message_data_with_these_values(String messageTable) {
        String myQuery= " INSERT INTO cmessage (id,name,email,subject,message) VALUES ("+messageTable+"); ";
        DBUtils.executeQuery(myQuery);
    }
    @Given("FK Admin reads all of the {string} column data from {string} table")
    public void fk_admin_reads_all_of_the_column_data_from_table(String messageColumn, String messageTable) throws SQLException {
        String myQuery= " select " +messageColumn+ " from " + messageTable;
        DBUtils.executeQuery(myQuery);

        List<Object> allData=new ArrayList<>();
        while (DBUtils.getResultset().next()){
            Object eachColumnData=DBUtils.getResultset().getObject(messageColumn);
            System.out.println(eachColumnData);
            allData.add(eachColumnData);
        }
        System.out.println("allData = " + allData);
        Assert.assertTrue(allData.contains("admin databasede"));
    }


    List<Object> Id;

    List<Object> Name;

    List<Object> Email;

    List<Object> Subject;

    List<Object> Message;


    @Given("FK Admin reads all of the {string} and {string} and {string} and {string} and {string} and {string} column data")
    public void fk_admin_reads_all_of_the_and_and_and_and_and_column_data(String query, String id, String name, String email, String subject, String message) {
        Id=DBUtils.getColumnData(query,id);
        System.out.println("Id = " + Id);
        Name=DBUtils.getColumnData(query,name);
        Email=DBUtils.getColumnData(query,email);
        Subject=DBUtils.getColumnData(query,subject);
        Message=DBUtils.getColumnData(query,message);
        System.out.println("Name = " + Name);
        System.out.println("Email = " + Email);
        System.out.println("Subject = " + Subject);
        System.out.println("Message = " + Message);





    }
    @Then("FK Admin verifies the creation is successfull using DB")
    public void fk_admin_verifies_the_creation_is_successfull_using_db() {
        for ( Object w : Id    ) {
            if (w.toString().contains("78055")){
                Assert.assertTrue(w.toString().contains("78055"));
            }
        }
        Assert.assertTrue("Name is not found",Name.contains("admin dbde"));
        Assert.assertTrue("Email is not found",Email.contains("admindbde@yahoo.com"));
        Assert.assertTrue("Subject is not found",Subject.contains("admindb"));
        Assert.assertTrue("Message is not found",Message.contains("admin databasede"));



    }




}
