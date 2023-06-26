package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;

public class DBStepDefs {
    @Given("user connects to the application database")
    public void user_connects_to_the_application_database() {
        DBUtils.createConnection();
    }

    @Given("user gets the column {string} from the table {string}")
    public void user_gets_the_column_from_the_table(String column, String table) {
        String query = "SELECT " + column + " FROM " + table + " ORDER BY id";
        DBUtils.executeQuery(query);
    }

    @Then("user reads all the column {string} data")
    public void user_reads_all_the_column_data(String column) throws SQLException {
        DBUtils.getResultset().next();
        //DBUtils.getResultset().next();
        Object object1 = DBUtils.getResultset().getObject(column);
        System.out.println(object1);
        // Assert.assertTrue(object1.toString().equals("anonymoususer"));

        //   --------verify adam_admin login name-----------
        int rowNumber = 3;
        while (DBUtils.getResultset().next()) {//similar to hasNext()
            Object currentRowData = DBUtils.getResultset().getObject(column);
            System.out.println(currentRowData.toString());
            rowNumber++;
        }
        System.out.println("DATA COUNT : " + rowNumber);
    }

    @Then("verify table {string} and column {string} contains the data {string}")
    public void verify_table_and_column_contains_the_data(String table, String column, String data) {

        String query =  "SELECT " + column + " FROM " + table + " ORDER BY id";
        List<Object> currentColumnList = DBUtils.getColumnData(query,column);
        System.out.println(currentColumnList);

        Assert.assertTrue(currentColumnList.contains(data));

    }

}
