package com.example.surveyapp.model

import java.io.Serializable

data class SurveyListData(val questionsArray: Array<String>, val choicesArray: Array<Array<String>>) :
    Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SurveyListData

        if (!questionsArray.contentEquals(other.questionsArray)) return false
        if (!choicesArray.contentDeepEquals(other.choicesArray)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = questionsArray.contentHashCode()
        result = 31 * result + choicesArray.contentDeepHashCode()
        return result
    }
}
