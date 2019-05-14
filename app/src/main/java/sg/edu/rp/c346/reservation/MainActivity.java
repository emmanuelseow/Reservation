package sg.edu.rp.c346.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkSmoke;
    Button btnConfirm;
    Button btnReset;
    EditText etName;
    EditText etmobile;
    EditText etpax;
    DatePicker dp;
    TimePicker tp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tp =findViewById(R.id.timePicker);
        tp.setIs24HourView(true);
        dp =findViewById(R.id.datePicker);
        etpax = findViewById(R.id.editTextPax);
        etmobile = findViewById(R.id.editTextMobile);
        etName = findViewById(R.id.editTextName);
        btnReset = findViewById(R.id.buttonReset);
        btnConfirm = findViewById(R.id.buttonConfirm);
        chkSmoke = findViewById(R.id.checkBoxSmoke);



        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CharSequence text = "";


                if ((!(etName.getText().toString().isEmpty()) || !(etmobile.getText().toString().isEmpty()) || !(etpax.getText().toString().isEmpty()))){

                    String msg = "";

                    if (chkSmoke.isChecked()){
                        msg = "Smoking Area!";

                    }
                    else{
                        msg = "Non-Smoking Area!";
                    }

                    text ="Name: " + etName.getText().toString()
                            +"\n" + "MobileNo: " + etmobile.getText().toString()
                            +"\n" + "Pax: " + etpax.getText().toString()
                            +"\n" + "Time: " + tp.getCurrentHour() + ":" + tp.getCurrentMinute()
                            +"\n" + "Date: " + dp.getDayOfMonth() + "/" + (dp.getMonth()+1) + "/" + dp.getYear()
                            +"\n" + "Area: " + msg;

                }
                else{
                    text = "Fill in all fields";


                }
                Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();





            }

        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etpax.setText("");
                etmobile.setText("");
                etName.setText("");
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2019,0,1);
                chkSmoke.setChecked(false);
            }
        });

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                tp.setIs24HourView(true);
                if (tp.getCurrentHour() >= 20 || tp.getCurrentHour() < 21 ){
                    tp.setCurrentHour(20);

                }
            }
        });
    }
}


