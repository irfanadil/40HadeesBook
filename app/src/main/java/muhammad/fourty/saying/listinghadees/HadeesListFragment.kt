package muhammad.fourty.saying.listinghadees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import muhammad.fourty.saying.R
import muhammad.fourty.saying.databinding.FragmentHomeBinding
import muhammad.fourty.saying.listinghadees.adapter.IndexListAdapter
import muhammad.fourty.saying.listinghadees.adapter.DuaClickAdapter
import muhammad.fourty.saying.listinghadees.model.SayingIndexModel


class HadeesListFragment : Fragment() , DuaClickAdapter {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and  - onDestroyView.
    private val binding get() = _binding!!

    private lateinit var indexListAdapter: IndexListAdapter

    //private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupBookView()
        return root
    }





    private fun setupBookView(){
        indexListAdapter = IndexListAdapter(this@HadeesListFragment)
        binding.indexRecyclerView.apply {
            setHasFixedSize(true)
            adapter = indexListAdapter
        }



        val listOfSayingIndexModels = listOf(
            SayingIndexModel(0, "اخلاص نیت ","Hadees 1"),
            SayingIndexModel(1,"مسلمانوں کے چند حقوق","Hadees 2"),
            SayingIndexModel(2,"رحمدلی ","Hadees 3"),
            SayingIndexModel(3," چخلخوری ","Hadees 4"),
            SayingIndexModel(4," قطح رحمی ","Hadees 5"),
            SayingIndexModel(5,"ظلم کی مذمت ","Hadees 6"),
            SayingIndexModel(6,"ٹخنوں سے نیچے تک لباس","Hadees 7"),
            SayingIndexModel(7,"کامل مسلمان کون ؟ ","Hadees 8"),
            SayingIndexModel(8,"  نرمی ومہربانی ","Hadees 9"),
            SayingIndexModel(9,"حقیقی پہلواں","Hadees 10"),
            SayingIndexModel(10,"بے حیائی کے مذمت ","Hadees 11"),

            SayingIndexModel(11,"پا بندی اور مستقل مزاجی ","Hadees 12"),
            SayingIndexModel(12,"تصویر اور کتے کی نحوست","Hadees 13"),
            SayingIndexModel(13,"  نبی ﷺ کا محبوب ","Hadees 14"),
            SayingIndexModel(14,"دنیا کی حیثیت","Hadees 15"),

            SayingIndexModel(15,"ناراضگی کی مذمت ","Hadees 16"),
            SayingIndexModel(16,"  ہوشیاری اور بیدار مغزی ","Hadees 17"),
            SayingIndexModel(17," حقیقی مالداری ","Hadees 18"),
            SayingIndexModel(18,"دنیا میں رہنے کا طریقہ","Hadees 19"),

            SayingIndexModel(19,"جھوٹے کی پہچان","Hadees 20"),
            SayingIndexModel(20,"چچا کی عظمت","Hadees 21"),
               SayingIndexModel(21,"عیب کی پردہ پوشی","Hadees 22"),
            SayingIndexModel(22,"کامیاب شخص","Hadees 23"),

            )

        indexListAdapter.updateInsideAdapter(listOfSayingIndexModels)
    }


    override fun duaItemClicked(duaTitleModel: SayingIndexModel) {
        findNavController().navigate(R.id.move_to_dua_read_page , bundleOf("stageIndex" to duaTitleModel.stageIndex))
    }

    override fun deleteUrlEvent(duaTitleModel: SayingIndexModel) {

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}