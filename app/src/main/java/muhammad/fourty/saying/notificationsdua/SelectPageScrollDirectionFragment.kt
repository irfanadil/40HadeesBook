package muhammad.fourty.saying.notificationsdua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import muhammad.fourty.saying.R
import muhammad.fourty.saying.util.StringPatternMatching
import muhammad.fourty.saying.databinding.FragmentScrollDirectionBinding


class SelectPageScrollDirectionFragment : Fragment() {

    private var _binding: FragmentScrollDirectionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    val firstString = "مسلمانوں کے چند حقوق جو\n" +
            "حضور اکرم صلى الله عليه وسلم نے ارشاد فرمایا\n" +
            "مسلمان کے مسلمان پر پانچ حقوق ہیں (۱) سلام کا جواب دینا۔ (۲) مریض\n" +
            "کی بیمار پرسی کرنا (۳) جنازے کے ساتھ جانا (۴) اسکی دعوت قبول کرنا (۵) اور چھینک کا جواب یرحمک اللہ\n" +
            "کہہ کر دینا\n" +
            "( بخاری ومسلم)\n" +
            "تشریح\n" +
            "Hadees.No.2\n\n  \n  صلى الله عليه وسلم  " +
            "یہ حدیث مسلمانوں کے باہمی حقوق کے بارے میں بلکل واضح ہے۔ البتہ مذکورہ حقوق میں چند باتوں کیطرف توجہ ضروری ہے\n" +
            "(1) سلام کا جواب دینے میں بعض جگہ رسمی طور پر ہاتھ ملالیتے ہیں یا دعائیں دیتے ہیں مگر ”وعلیکم اسلام کا لفظ نہیں کہتے حالانکہ یہ ضروری ہے، سلام کا جواب دینا محمد صلى الله عليه وسلم  واجب ہے ” جیتے رہو\" لمبی عمر پاؤ کہنے سے یہ واجب ادا نہیں ہوتا ۔\n" +
            "(۲) مریض کی مزاج پرسی میں اسکا خیال رہنا چاہئے کہ ایسے وقت میں عیادت کیلئے جائیں جب اس کو ملاقات کرنے میں کوئی تکلیف نہ ہو۔ اور اتنی دیر اس کے پاس نہ بیٹھے کہ وہ اکتا جائے، یا اپنی کسی ضرورت میں تنگی محسوس کرے۔ مثلاً لبعض اوقات کوئی بیما در امریض پر اسطرح مسلط ہو جاتا ہے کہ اگر وہ سونا چاہے تو سو نہیں سکتا یا خاموش رہنا چا ہتا ہے تو لحاظ کی وجہ سے نہیں رہ سکتا۔\n" +
            "(۳) جنازے کے ساتھ جانے میں بھی اس کا خیال رہے کہ کوئی کام خلاف سنت نہ ہو۔ آج کل جنازے میں بہت سی چیزیں اپنی طرف سے بڑھائی گئی ہیں، ان سے بچنے اور کسی مناسب موقع پر دوسروں کو بھی ان رسومات و بدعات سے منع کرے۔\n" +
            "(۴) حضرت محمد صلى الله عليه وسلم  دعوت قبول کرنے میں بھی یہ شرط ہے کہ وہاں جا کر کسی ناجائز کام میں شرکت نہ ہو جیسے آجکل ولیمہ وغیرہ کی دعوتیں، بے پردگی ، غیر محرم مردو عورت کے آزادانہ اختلاط اور فلم سازی اور تصویر بازی سے بھری ہوئی ہوتی  ہیں ایسی دعوتوں کا قبول کرنا جائز نہیں۔ \n" +
            "(۵) چھنے والا جب \" الحمد للہ کہے تو اس وقت اسکو یہ کہہ کر دعا دینی چاہئے یرحمک اللہ اللہ تم پر رحمت کرے۔ البتہ کچھ لوگ دینی یاد نیاوی کاموں میں مشغول ہیں تو وہاں چھنکنے والے کیلئے بہتر یہ ہے کہ وہ الحمد للہ زیرلب کہے تا کہ سننے والوں پر یہ دعائیہ کلمہ کہنا لازم نہ ہو۔\n"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentScrollDirectionBinding.inflate(inflater, container, false)
        val root: View = binding.root
        arguments?.getInt("stageIndex")?.let {
            //findNavController().navigate(R.id.move_to_dua_read_page , bundleOf("stageIndex" to it , "scrollType" to 1))
        }

        binding.horizontalBtn.setOnClickListener{
            arguments?.getInt("stageIndex")?.let {
                findNavController().navigate(R.id.move_to_dua_read_page , bundleOf("stageIndex" to it , "scrollType" to 0))
            }
        }

        binding.verticalBtn.setOnClickListener {
            arguments?.getInt("stageIndex")?.let {
                findNavController().navigate(
                    R.id.move_to_dua_read_page,
                    bundleOf("stageIndex" to it, "scrollType" to 1)
                )
            }
        }

       binding.sayingTextView.text = StringPatternMatching.returnAllMatchingNameOfProphet(firstString)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}