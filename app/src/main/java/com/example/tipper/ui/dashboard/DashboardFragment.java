package com.example.tipper.ui.dashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tipper.databinding.FragmentDashboardBinding;

import java.text.NumberFormat;
import java.util.Objects;

public class DashboardFragment extends Fragment {

    private static final NumberFormat numberFormat =
            NumberFormat.getNumberInstance();
    private double weight = 0; // weight entered by the user
    private double height = 0; // height entered by the user
    private String sex;
    private int age = 0;
    private TextView weightTextView; // shows formatted weight
    private TextView heightTextView; // shows formatted weight
    private TextView resultTextView; // shows calculated BMI
    private TextView sexTextView;

    private TextView ageTextView;
    private Button calculateButton;

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        weightTextView = binding.weightTextView;
        heightTextView = binding.heightTextView;
        resultTextView = binding.resultTextView;
        sexTextView = binding.sexEditView;
        ageTextView = binding.ageTextView;
        calculateButton = binding.btn;
        calculateButton.setOnClickListener(calculateOnClick);

        EditText weightEditText = binding.weightEditText;
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        EditText heightEditText = binding.heightEditText;
        heightEditText.addTextChangedListener(heightEditTextWatcher);

        EditText sexEditText = binding.sexEditText;
        sexEditText.addTextChangedListener(sexEditTextWatcher);

        EditText ageEditText = binding.ageEditText;
        ageEditText.addTextChangedListener(ageEditTextWatcher);

        dashboardViewModel.getText().observe(getViewLifecycleOwner(), resultTextView::setText);
        return root;
    }

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

    private final TextWatcher sexEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
                sexTextView.setText(s);
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final TextWatcher ageEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try {
                age = Integer.parseInt(s.toString());
                ageTextView.setText(numberFormat.format(age));
            } catch (NumberFormatException e) { // if s is empty or non-numeric
                ageTextView.setText("");
                age = 0;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };

    private final View.OnClickListener calculateOnClick = new View.OnClickListener() {
        @SuppressLint("DefaultLocale")
        @Override
        public void onClick(View v) {
            double result = 0.0;
            if (Objects.equals(sex, "m")) {
                result = 66.5+(13.75*(weight) + (5.003*(height))-(6.775*(age)));
            } else {
                result = 655.1+(9.563*(weight) + (1.85*(height))-(4.676*(age)));
            }
            resultTextView.setText(String.format("%.2f",result));
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}