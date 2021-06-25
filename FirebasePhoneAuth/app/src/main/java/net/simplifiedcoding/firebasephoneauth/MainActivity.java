
package net.simplifiedcoding.firebasephoneauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.firebasephoneauth.R;
import com.example.firebasephoneauth.VerifyPhoneActivity;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private EditText editText;
    private Object net;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinnerCountries);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,CountryData.countryNames));
        editText = findViewById(R.id.editTextMobile);
        findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = CountryData.countryAreas[spinner.getSelectedItemPosition()];
                String number = editText.getText().toString().trim();
                if(number.isEmpty()) {
                    editText.setError(" Valid Number is Required");
                    editText.requestFocus();
                    return;
                }
                String phoneNumber = "+" + code +number;
                Intent intent = new Intent(MainActivity.this, VerifyPhoneActivity.class);
                intent.putExtra("phonenumber",phoneNumber);
                startActivity(intent);
            }
        });
    }

}