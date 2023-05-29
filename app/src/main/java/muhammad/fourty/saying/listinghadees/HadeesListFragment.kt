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
import muhammad.fourty.saying.listinghadees.adapter.BookListAdapter
import muhammad.fourty.saying.listinghadees.adapter.DuaClickAdapter
import muhammad.fourty.saying.listinghadees.model.DuaModel


class HadeesListFragment : Fragment() , DuaClickAdapter {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and  - onDestroyView.
    private val binding get() = _binding!!

    private lateinit var bookListAdapter: BookListAdapter

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
        bookListAdapter = BookListAdapter(this@HadeesListFragment)
        binding.indexRecyclerView.apply {
            setHasFixedSize(true)
            adapter = bookListAdapter
        }



        val listOfDuaModel = listOf(
            DuaModel(0, "پہلی منزل  محمد ﷺ","Day 1"),
            DuaModel(1,"دوسری منزل ","Day 2"),
            DuaModel(2,"تیسری منزل ","Day 3"),
            DuaModel(3," چوتھی منزل ","Day 4"),
            DuaModel(4," پانچوی منزل ","Day 5"),
            DuaModel(5,"چھٹی منزل ","Day 6"),
            DuaModel(6,"ساتویں منزل ","Day 7")
        )

        bookListAdapter.updateInsideAdapter(listOfDuaModel)
    }


    override fun duaItemClicked(duaTitleModel: DuaModel) {
        findNavController().navigate(R.id.move_to_scroll_direction , bundleOf("stageIndex" to duaTitleModel.stageIndex))
    }

    override fun deleteUrlEvent(duaTitleModel: DuaModel) {

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}