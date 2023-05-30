package muhammad.fourty.saying.util

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan

object StringPatternMatching {

    fun returnAllMatchingNameOfProphet(prophetSaying:String) : Spannable {

        val wordToSpan: Spannable = SpannableString(prophetSaying)
        val pattern1 = "حضور اکرم صلى الله عليه وسلم"
        val pattern2 = "حضرت محمد صلى الله عليه وسلم"
        val pattern3 = "محمد صلى الله عليه وسلم"
        val pattern4 = "صلى الله عليه وسلم"
        val pattern5 = "حضوراکرم ﷺ"
        val pattern6 = "رسول اکرم ﷺ"


        val nameList:MutableList<Int> = mutableListOf()
        nameList.addAll(returnMatchingIndexes(pattern1, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern2, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern3, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern4, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern5, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern6, prophetSaying))
        return highLightProphetName(wordToSpan, nameList)

    }

    private fun highLightProphetName(wordToSpan:Spannable, nameList:MutableList<Int>):Spannable{
        for (index in nameList) {
            wordToSpan.setSpan(
                ForegroundColorSpan(Color.GREEN),
                index,
                index + 19,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        return wordToSpan
    }

    private fun returnMatchingIndexes(patternPassed:String, hadeesText: String):List<Int>{
        return Regex(patternPassed).findAll(hadeesText)
            .map { it.range.first }
            .toMutableList()
    }

}