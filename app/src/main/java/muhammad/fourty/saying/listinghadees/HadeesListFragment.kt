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
            SayingIndexModel(0, "اخلاص نیت ","Day 1"),
            SayingIndexModel(1,"مسلمانوں کے چند حقوق","Day 2"),
            SayingIndexModel(2,"رحمدلی ","Day 3"),
            SayingIndexModel(3," چخلخوری ","Day 4"),
            SayingIndexModel(4," قطح رحمی ","Day 5"),
            SayingIndexModel(5,"ظلم کی مذمت ","Day 6"),
            SayingIndexModel(6," ٹخنوں سے نیچے تک لباس پہننے پر وعید  ","Day 7"),
            SayingIndexModel(2,"کامل مسلمان کون ؟ ","Day 8"),
            SayingIndexModel(3,"  نرمی ومہربانی ","Day 9"),
            SayingIndexModel(4," قطح رحمی ","Day 10"),
            SayingIndexModel(5,"بے حیائی کے مذمت ","Day 11"),

            SayingIndexModel(2,"پا بندی اور مستقل مزاجی ","Day 12"),
            SayingIndexModel(3,"تصویر اور کتے کی نحوست","Day 13"),
            SayingIndexModel(4,"  نبی ﷺ کا محبوب ","Day 14"),
            SayingIndexModel(5,"دنیا کی حیثیت","Day 15"),

            SayingIndexModel(2,"ناراضگی کی مذمت ","Day 16"),
            SayingIndexModel(3,"  ہوشیاری اور بیدار مغزی ","Day 17"),
            SayingIndexModel(4," حقیقی مالداری ","Day 18"),
            SayingIndexModel(5,"دنیا میں رہنے کا طریقہ","Day 19"),

            SayingIndexModel(2,"جھوٹے کی پہچان","Day 20"),
            SayingIndexModel(3,"چچا کی عظمت","Day 21"),
               SayingIndexModel(5,"جھوٹے کی ایک پہچان","Day 23"),

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