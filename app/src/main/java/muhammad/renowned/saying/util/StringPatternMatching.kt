package muhammad.renowned.saying.util

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import muhammad.renowned.saying.R


object StringPatternMatching {

    fun returnAllQuoteHighlighted(hadeesText:Spannable , context:Context) : Spannable {

        val sentenceExtracted = Regex("quote").findAll(hadeesText)
            .map { it.range.first }
            .toMutableList()

        return if(sentenceExtracted.size>1)
            highLightQuote(hadeesText, sentenceExtracted, context)
        else
            hadeesText
    }

    private fun highLightQuote(wordToSpan:Spannable, quoteIndex:List<Int> , context:Context ):Spannable{

        wordToSpan.setSpan(
            ForegroundColorSpan(context.resources.getColor(R.color.Navy, context.theme)),
            quoteIndex[0],
            quoteIndex[1],
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        wordToSpan.setSpan(
            StyleSpan(Typeface.BOLD),
            quoteIndex[0],
            quoteIndex[1],
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        wordToSpan.setSpan(
            RelativeSizeSpan(.1f),
            quoteIndex[0],
            quoteIndex[0]+5,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        wordToSpan.setSpan(
            RelativeSizeSpan(.1f),
            quoteIndex[1],
            quoteIndex[1]+5,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        return wordToSpan
    }


    fun returnHighLightHadeesNumber(hadeesText:Spannable , context:Context) : Spannable {

        val wordToSpan = hadeesText
        val sentenceExtracted = Regex("Hadees.No.").findAll(wordToSpan)
            .map { it.range.first }
            .toMutableList()

       if(sentenceExtracted.size == 1){
           wordToSpan.setSpan(
               ForegroundColorSpan(context.resources.getColor(R.color.Red, context.theme)),
               sentenceExtracted[0],
               sentenceExtracted[0]+12,
               Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
           )
       }

        return wordToSpan
    }



    fun returnAllMatchingNameOfProphet(prophetSaying:String , context:Context) : Spannable {

        val wordToSpan: Spannable = SpannableString(prophetSaying)
        //val pattern1 = "حضور اکرم صلى الله عليه وسلم"
        //val pattern2 = "حضرت محمد صلى الله عليه وسلم"
        //val pattern3 = "محمد صلى الله عليه وسلم"
        val pattern4 = "صلى الله عليه وسلم"
        //val pattern5 = "ﷺ"
        //val pattern5 = "حضوراکرم ﷺ"
        //val pattern6 = "رسول اکرم ﷺ"
        //val pattern7 = "آنحضرت ﷺ"
        //val pattern8 = "آنحضرت صلى الله عليه وسلم"



        val nameList:MutableList<Int> = mutableListOf()
        //nameList.addAll(returnMatchingIndexes(pattern1, prophetSaying))
       // nameList.addAll(returnMatchingIndexes(pattern2, prophetSaying))
        //nameList.addAll(returnMatchingIndexes(pattern3, prophetSaying))
        nameList.addAll(returnMatchingIndexes(pattern4, prophetSaying))
        //nameList.addAll(returnMatchingIndexes(pattern5, prophetSaying))
        //nameList.addAll(returnMatchingIndexes(pattern6, prophetSaying))
       // nameList.addAll(returnMatchingIndexes(pattern7, prophetSaying))
       // nameList.addAll(returnMatchingIndexes(pattern8, prophetSaying))
        return highLightProphetName(wordToSpan, nameList , context)

    }

    private fun highLightProphetName(wordToSpan:Spannable, nameList:MutableList<Int> , context:Context ):Spannable{
        for (index in nameList) {
            wordToSpan.setSpan(
                ForegroundColorSpan(context.resources.getColor(R.color.green_500, context.theme)),
                //RelativeSizeSpan(.1f),
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