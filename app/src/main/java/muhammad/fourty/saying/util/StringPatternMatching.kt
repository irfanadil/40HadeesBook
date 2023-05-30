package muhammad.fourty.saying.util

import android.content.Context
import android.content.res.Resources
import android.content.res.Resources.Theme
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import muhammad.fourty.saying.R

object StringPatternMatching {

    fun returnAllMatchingNameOfProphet(prophetSaying:String , context:Context) : Spannable {

        val wordToSpan: Spannable = SpannableString(prophetSaying)
        val pattern1 = "حضور اکرم صلى الله عليه وسلم"
        val pattern2 = "حضرت محمد صلى الله عليه وسلم"
        val pattern3 = "محمد صلى الله عليه وسلم"
        val pattern4 = "صلى الله عليه وسلم"
        val pattern5 = "حضوراکرم ﷺ"
        val pattern6 = "رسول اکرم ﷺ"
        val pattern7 = "آنحضرت ﷺ"
        val pattern8 = "آنحضرت صلى الله عليه وسلم"



        val nameList:MutableList<Int> = mutableListOf()
        nameList.addAll(returnMatchingIndexes(pattern1, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern2, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern3, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern4, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern5, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern6, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern7, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern8, prophetSaying))
        return highLightProphetName(wordToSpan, nameList , context)

    }

    private fun highLightProphetName(wordToSpan:Spannable, nameList:MutableList<Int> , context:Context ):Spannable{
        for (index in nameList) {
            wordToSpan.setSpan(
                ForegroundColorSpan(context.resources.getColor(R.color.green_500, context.theme)),
                index,
                (index + 19),
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

class ResourcesHelper {

    companion object {
        val greenColor = Resources.getSystem().getColor(R.color.green_500)

    }

}