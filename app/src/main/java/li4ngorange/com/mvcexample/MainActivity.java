package li4ngorange.com.mvcexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


// The MainActivity is basically a controller, and the xml file is the view.
// I will need to create another file for Model to have all student data in there
public class MainActivity extends ActionBarActivity {

    // Reference to the View
    Button buttonChange;
    Button addButton;

    EditText editName;
    EditText editNumber;
    EditText editGender;
    TextView infoLabel;
    TextView totalNumberLabel;

    // Reference to the model
    StudentModel studentModel = new StudentModel();


    private Integer studentID = 10001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the View
        buttonChange = (Button) findViewById(R.id.changeButton);
        addButton = (Button) findViewById(R.id.buttonAdd);

        editName = (EditText) findViewById(R.id.editName);
        editNumber = (EditText) findViewById(R.id.editNumber);
        editGender = (EditText) findViewById(R.id.editGender);
        infoLabel = (TextView) findViewById(R.id.resultLabel);
        totalNumberLabel = (TextView) findViewById(R.id.totalLabel);

        // Update the view when the app first load
        updateView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void changeStudentInfo(View view) {


        if (studentModel.getTotalStudentNumber() != 0) {

            int studentTempID = studentID - 1;

            if (!editName.getText().toString().equals("")) {
                System.out.println("Change Name: " + editName.getText().toString());
                studentModel.getStudent(studentTempID).setName(editName.getText().toString());
            }

            if (!editNumber.getText().toString().equals("")) {
                studentModel.getStudent(studentTempID).setNumber(editNumber.getText().toString());
            }

            if (!editGender.getText().toString().equals("")) {
                studentModel.getStudent(studentTempID).setGender(editGender.getText().toString());
            }

        }
        updateView();
    }


    public void addNewStudent(View view) {

        String tempName = "";
        String tempNumber = "";
        String tempGender = "";

        if (!editName.getText().toString().equals("")) {
            tempName = editName.getText().toString();
        }

        if (!editNumber.getText().toString().equals("")) {
            tempNumber = editNumber.getText().toString();
        }

        if (!editGender.getText().toString().equals("")) {
            tempGender = editGender.getText().toString();
        }


        Student student = new Student(tempName, tempNumber, tempGender);
        studentModel.addStudent(studentID, student);

        studentID++;

        updateView();

    }

    public void updateView() {


        if (studentModel.getTotalStudentNumber() != 0) {

            int studentTempID = studentID - 1;

            infoLabel.setText("Student: " + studentModel.getStudent(studentTempID).getName()
                    + "\nNumber: " + studentModel.getStudent(studentTempID).getNumber()
                    + "\nGender: " + studentModel.getStudent(studentTempID).getGender());
        }

        totalNumberLabel.setText("Total Students: " + studentModel.getTotalStudentNumber());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
