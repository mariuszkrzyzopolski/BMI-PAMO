package com.example.tipper.ui.quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tipper.R;
import com.example.tipper.databinding.FragmentNotificationsBinding;

public class QuizFragment extends Fragment implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;
    private Button nextButton;
    private TextView questionTextView;
    private int correct = 0;
    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {
            new Question(R.string.a, true),
            new Question(R.string.b, true),
            new Question(R.string.c, false),
            new Question(R.string.d, true),
            new Question(R.string.e, false),
            new Question(R.string.f, false),
    };
    private FragmentNotificationsBinding binding;

    public static QuizFragment newInstance() {
        return new QuizFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_quiz, container, false);
        falseButton = v.findViewById(R.id.false_button);
        trueButton = v.findViewById(R.id.true_button);
        nextButton = v.findViewById(R.id.next_button);
        questionTextView = v.findViewById(R.id.answer_text_view);

        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                checkAnswer(true);
                break;

            case R.id.next_button:
                if (currentQuestionIndex < 7) {
                    currentQuestionIndex
                            = currentQuestionIndex + 1;
                    if (currentQuestionIndex == 6) {
                        questionTextView.setText(getString(
                                R.string.correct, correct));
                        nextButton.setVisibility(
                                View.INVISIBLE);
                        trueButton.setVisibility(
                                View.INVISIBLE);
                        falseButton.setVisibility(
                                View.INVISIBLE);
                        if (correct > 3)

                            questionTextView.setText(
                                    "Poprawność " + correct
                                            + " "
                                            + "na 6");
                    }
                    else {
                        updateQuestion();
                    }
                }
                break;
        }
    }

    private void updateQuestion()
    {
        questionTextView.setText(
                questionBank[currentQuestionIndex]
                        .getAnswerResId());
    }
    private void checkAnswer(boolean userChooseCorrect)
    {
        boolean answerIsTrue
                = questionBank[currentQuestionIndex]
                .isAnswerTrue();
        if (userChooseCorrect == answerIsTrue) {
            correct++;
        }

    }
}