package com.example.app2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextSwitcher;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {
    EditText et;
    Button bt;
    CheckBox cb;
    ToggleButton tb;
    RadioButton rb;
    ProgressBar pb;
    SeekBar sk;
    AutoCompleteTextView act;
    MultiAutoCompleteTextView mac;
    CheckedTextView ctv;
    TextSwitcher ts;
    ImageView iv;
    LinearLayout mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        et = findViewById(R.id.et1);
        bt = findViewById(R.id.bt1);
        cb = findViewById(R.id.cb1);
        tb = findViewById(R.id.tb1);
        rb = findViewById(R.id.rb1);
        pb = findViewById(R.id.pb1);
        sk = findViewById(R.id.sb1);
        act = findViewById(R.id.ac);
        mac = findViewById(R.id.mac);
        ctv = findViewById(R.id.ctv);
        ts = findViewById(R.id.ts);
        iv = findViewById(R.id.iv);
        mc = findViewById(R.id.MainContainer);

//Edit Text
        et.setTypeface(null, Typeface.BOLD);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Not needed for this example
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Not needed for this example
            }

            @Override
            public void afterTextChanged(Editable editable) {
                showToast("Text entered: " + editable.toString());
            }
        });

//Button

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startProgressBar();
            }
        });
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Student is in N1", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Student Must Be assigned to N1", Toast.LENGTH_LONG).show();
                }
            }
        });

//Toggle Button

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Student is a Degree student", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Student is a Masters student", Toast.LENGTH_LONG).show();
                }
            }
        });

//Radio Button

        rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Checkbox is checked, set background color to green
                    Toast.makeText(getApplicationContext(), "Student is a Regular student", Toast.LENGTH_LONG).show();
                }
            }
        });

//Seek bar

        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Not needed for this example
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed for this example
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                handleSeekBarProgress(seekBar.getProgress());
            }
        });

//MultiAutoCompleteTextView

        String[] sectionsArray = getResources().getStringArray(R.array.sections);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, sectionsArray);
        mac.setAdapter(adapter2);
        mac.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        String[] sections = getResources().getStringArray(R.array.sections);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, sections);

//AutoCompleteTextView
        act.setAdapter(adapter);
        act.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = (String) parent.getItemAtPosition(position);
            showToast("Selected: " + selectedItem);
        });

//CheckedText

        ctv.setChecked(false);
        ctv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctv.toggle();
                if (ctv.isChecked()) {
                    showToast("CheckedTextView is Checked");
                } else {
                    showToast("CheckedTextView is Unchecked");
                }
            }
        });
    }

//Progress Bar

    private void startProgressBar() {
        pb.setVisibility(View.VISIBLE);
        simulateProgressBar();
    }
    private void simulateProgressBar() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pb.setVisibility(View.GONE);
                showToast("Registration completed");
            }
        }, 2000);
    }

//Seek Bar

         private void handleSeekBarProgress(int progress){
            int percentage = (int) ((float) progress / sk.getMax() * 100);

            String message;
            if (percentage <= 25) {
                message = "1 year learned";
            } else if (percentage <= 50) {
                message = "2 years learned";
            } else if (percentage <= 75) {
                message = "3 years learned";
            } else {
                message = "4 years learned";
            }

            showToast("Progress: " + percentage + "% - " + message);
        }
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    }
