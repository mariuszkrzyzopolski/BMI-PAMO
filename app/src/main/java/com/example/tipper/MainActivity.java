package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private static final NumberFormat numberFormat =
            NumberFormat.getNumberInstance();
    private double weight = 0; // weight entered by the user
    private double height = 0; // height entered by the user
    private TextView weightTextView; // shows formatted weight
    private TextView heightTextView; // shows formatted weight
    private TextView resultTextView; // shows calculated BMI

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_main); // inflate the GUI
        weightTextView = findViewById(R.id.weightTextView);
        heightTextView = findViewById(R.id.heightTextView);

        resultTextView = findViewById(R.id.resultTextView);

        Button calculateButton = findViewById(R.id.btn);
        calculateButton.setOnClickListener(calculateOnClick);

        EditText weightEditText = findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        EditText heightEditText = findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);
    }

    // listener object for the EditText's text-changed events
    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                weight = Double.parseDouble(s.toString());
                weightTextView.setText(numberFormat.format(weight));
            } catch (NumberFormatException e) { // if s is empty or non-numeric
                weightTextView.setText("");
                weight = 0.0;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };

        // listener object for the EditText's text-changed events
        private final TextWatcher heightEditTextWatcher = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    height = Double.parseDouble(s.toString());
                    heightTextView.setText(numberFormat.format(height));
                }
                catch (NumberFormatException e) { // if s is empty or non-numeric
                    heightTextView.setText("");
                    height = 0.00;
                }
            }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final View.OnClickListener calculateOnClick = new View.OnClickListener() {
        @SuppressLint("DefaultLocale")
        @Override
        public void onClick(View v) {
            double BMI = (weight) / (Math.pow(height/100, 2));
            resultTextView.setText(String.format("%.2f",BMI));
        }
    };
}


/*************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
