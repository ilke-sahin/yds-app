package com.example.studywilke;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KelimeDefteriActivity extends AppCompatActivity {

    private EditText englishWordEditText, turkishMeaningEditText, exampleSentenceEditText;
    private TableLayout wordTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelime_defteri);

        englishWordEditText = findViewById(R.id.englishWordEditText);
        turkishMeaningEditText = findViewById(R.id.turkishMeaningEditText);
        exampleSentenceEditText = findViewById(R.id.exampleSentenceEditText);
        wordTableLayout = findViewById(R.id.wordTableLayout);

        Button addWordButton = findViewById(R.id.addWordButton);
        addWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addWordToTable();
            }
        });
    }

    private void addWordToTable() {
        String englishWord = englishWordEditText.getText().toString();
        String turkishMeaning = turkishMeaningEditText.getText().toString();
        String exampleSentence = exampleSentenceEditText.getText().toString();

        if (!englishWord.isEmpty() && !turkishMeaning.isEmpty() && !exampleSentence.isEmpty()) {
            TableRow row = new TableRow(this);

            TextView englishWordTextView = new TextView(this);
            englishWordTextView.setText(englishWord);

            TextView turkishMeaningTextView = new TextView(this);
            turkishMeaningTextView.setText(turkishMeaning);

            TextView exampleSentenceTextView = new TextView(this);
            exampleSentenceTextView.setText(exampleSentence);

            row.addView(englishWordTextView);
            row.addView(turkishMeaningTextView);
            row.addView(exampleSentenceTextView);

            wordTableLayout.addView(row);

            englishWordEditText.getText().clear();
            turkishMeaningEditText.getText().clear();
            exampleSentenceEditText.getText().clear();
        }
    }
}
