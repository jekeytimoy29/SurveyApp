package com.example.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.surveyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.surveyTypesGroup.removeAllViews()
        var count = 0

        for (survey in resources.getStringArray(R.array.survey_types)) {
            val radioButton = RadioButton(this)
            radioButton.text = survey
            radioButton.textSize = resources.getDimension(R.dimen.radio_text_size)
            radioButton.id = count
            binding.surveyTypesGroup.addView(radioButton)
            count++
        }
    }

    fun startSurveyButtonOnClick(view: View) {
        val selectedSurveyTypeId : Int = binding.surveyTypesGroup.checkedRadioButtonId
        if (selectedSurveyTypeId != -1) {
            val intent = Intent(this, SurveyQuestionsActivity::class.java).apply {
                putExtra("surveyTypeId", selectedSurveyTypeId)
            }
            startActivity(intent)

        } else {
            Toast.makeText(this, "Error: Please select a survey type.", Toast.LENGTH_LONG).show()
        }
    }
}