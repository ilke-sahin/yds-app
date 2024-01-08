package com.example.studywilke;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GrammerCozumuActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button showAnswerButton;

    private String[] questions;
    private String[] answers;

    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammer_cozumu);

        questionTextView = findViewById(R.id.questionTextView);
        showAnswerButton = findViewById(R.id.showAnswerButton);


        questions = getResources().getStringArray(R.array.grammar_questions);
        answers = getResources().getStringArray(R.array.grammar_answers);


        showQuestion();


        showAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswer();
            }
        });
    }

    private void showQuestion() {

        questionTextView.setText(questions[currentQuestionIndex]);

        showAnswerButton.setEnabled(true);
    }
    private void showAnswer() {
        Toast.makeText(this, "Doğru Cevap: " + answers[currentQuestionIndex], Toast.LENGTH_SHORT).show();

        currentQuestionIndex++;
        if (currentQuestionIndex == questions.length) {
            currentQuestionIndex = 0;
        }
        showQuestion();
    }
}
