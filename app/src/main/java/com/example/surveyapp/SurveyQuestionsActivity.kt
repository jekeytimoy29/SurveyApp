package com.example.surveyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.surveyapp.databinding.ActivitySurveyQuestionsBinding

class SurveyQuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySurveyQuestionsBinding
    private lateinit var surveyQuestionsArray: Array<String>
    private lateinit var surveyChoicesArray: Array<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when (intent.getIntExtra("surveyTypeId", -1)) {
            0 -> {
                surveyQuestionsArray = resources.getStringArray(R.array.food_pref_questions)
                surveyChoicesArray = arrayOf(
                    resources.getStringArray(R.array.fave_cuisine_choices),
                    resources.getStringArray(R.array.frequent_choices),
                    resources.getStringArray(R.array.yes_no_choices),
                    resources.getStringArray(R.array.yes_no_choices),
                    resources.getStringArray(R.array.yes_no_choices)
                )

                binding.surveyTitle.text = resources.getStringArray(R.array.survey_types)[0]
            }

            1 -> {
                surveyQuestionsArray = resources.getStringArray(R.array.diet_habits_questions)
                surveyChoicesArray =
                    arrayOf(
                        resources.getStringArray(R.array.yes_no_choices),
                        resources.getStringArray(R.array.yes_no_choices),
                        resources.getStringArray(R.array.yes_no_choices),
                        resources.getStringArray(R.array.yes_no_choices),
                        resources.getStringArray(R.array.yes_no_choices)
                    )

                binding.surveyTitle.text = resources.getStringArray(R.array.survey_types)[1]
            }
        }
    }
}