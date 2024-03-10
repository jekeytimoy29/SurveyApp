package com.example.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.example.surveyapp.databinding.ActivityMainBinding
import com.example.surveyapp.model.SurveyListData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.surveyTypesGroup.removeAllViews()

        for (survey in resources.getStringArray(R.array.survey_types)) {
            val radioButton = RadioButton(this)
            radioButton.text = survey
            radioButton.textSize = resources.getDimension(R.dimen.radio_text_size)
            binding.surveyTypesGroup.addView(radioButton)
        }
    }

    fun startSurveyButtonOnClick(view: View) {
        val surveyListData: SurveyListData
        when (binding.surveyTypesGroup.checkedRadioButtonId) {
            0 -> {
                surveyListData = SurveyListData(
                    resources.getStringArray(R.array.food_pref_questions),
                    arrayOf(
                        resources.getStringArray(R.array.fave_cuisine_choices),
                        resources.getStringArray(R.array.frequent_choices),
                        resources.getStringArray(R.array.yes_no_choices),
                        resources.getStringArray(R.array.yes_no_choices),
                        resources.getStringArray(R.array.yes_no_choices)
                    )
                )
            }
            1-> {
                surveyListData = SurveyListData(
                    resources.getStringArray(R.array.diet_habits_questions),
                    arrayOf(
                        resources.getStringArray(R.array.yes_no_choices),
                        resources.getStringArray(R.array.yes_no_choices),
                        resources.getStringArray(R.array.yes_no_choices),
                        resources.getStringArray(R.array.yes_no_choices),
                        resources.getStringArray(R.array.yes_no_choices)
                    )
                )
            }
            else -> surveyListData = SurveyListData(arrayOf(), arrayOf())
        }

        val intent = Intent(this, SurveyQuestionsActivity::class.java).apply {
            putExtra("surveyQuestions", surveyListData)
        }
        startActivity(intent)
    }
}