package com.omelenko.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Spinner dropdown1 = findViewById(R.id.spinner);
        String[] items = new String[]{"Км в милі", "Кілограми в фунти", "Градуси Цельсія в Фаренгейти"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown1.setAdapter(adapter);
        dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                EditText Text1 = findViewById(R.id.editTextText);
                EditText Text2 = findViewById(R.id.editTextText2);
                switch((int)id)
                {
                    case 0:
                    {
                        Text2.setText("0.62");
                        break;
                    }
                    case 1:
                    {
                        Text2.setText("2.20");
                        break;
                    }
                    case 2:
                    {
                        Text2.setText("0.55");
                        break;
                    }
                }
                Text1.setText("1");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(view -> {
            EditText Text = findViewById(R.id.editTextText);
            double value = String.valueOf(Text.getText()).isEmpty() ? 1 : Double.parseDouble(Text.getText().toString());
            double multiplier =
                    dropdown1.getSelectedItemId() == 0 ? 0.621371 :
                    dropdown1.getSelectedItemId() == 1 ? 2.20462262 :
                    dropdown1.getSelectedItemId() == 2 ? 0.556 : 0;
            double valueTo = value*multiplier;
            EditText mlText = findViewById(R.id.editTextText2);
            mlText.setText(String.valueOf(valueTo));
        });

        Spinner dropdown2 = findViewById(R.id.spinner2);
        String[] items1 = new String[]{"Прямокутник", "Круг", "Трикутник"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        dropdown2.setAdapter(adapter1);
        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                TextView Text7 = findViewById(R.id.textView7);
                TextView Text8 = findViewById(R.id.textView8);
                EditText editText3 = findViewById(R.id.editTextText3);
                //EditText editText4 = findViewById(R.id.editTextText4);
                switch((int)id)
                {
                    case 0:
                    {
                        Text7.setText("Ширина:");
                        Text8.setText("Висота:");
                        Text8.setEnabled(true);
                        Text8.setVisibility(View.VISIBLE);
                        editText3.setEnabled(true);
                        editText3.setVisibility(View.VISIBLE);
                        break;
                    }
                    case 1:
                    {
                        Text7.setText("Радіус:");
                        Text8.setEnabled(false);
                        Text8.setVisibility(View.INVISIBLE);
                        editText3.setEnabled(false);
                        editText3.setVisibility(View.INVISIBLE);
                        break;
                    }
                    case 2:
                    {
                        Text7.setText("Основа:");
                        Text8.setText("Висота:");
                        Text8.setEnabled(true);
                        Text8.setVisibility(View.VISIBLE);
                        editText3.setEnabled(true);
                        editText3.setVisibility(View.VISIBLE);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(view -> {
            long id = dropdown2.getSelectedItemId();
            EditText Text3 = findViewById(R.id.editTextText3);
            EditText Text4 = findViewById(R.id.editTextText4);
            EditText Text5 = findViewById(R.id.editTextText5);
            double value1 = String.valueOf(Text4.getText()).isEmpty() ? 1 : Double.parseDouble(String.valueOf(Text4.getText()));
            double value2 = String.valueOf(Text3.getText()).isEmpty() ? 1 : Double.parseDouble(String.valueOf(Text3.getText()));
            switch((int)id)
            {
                case 0:
                {
                    Text5.setText(String.valueOf(value1*value2));
                    break;
                }
                case 1:
                {
                    Text5.setText(String.valueOf((value1*value1)*3.14));
                    break;
                }
                case 2:
                {
                    Text5.setText(String.valueOf((value1*value2)/2));
                    break;
                }
            }
        });
    }

}