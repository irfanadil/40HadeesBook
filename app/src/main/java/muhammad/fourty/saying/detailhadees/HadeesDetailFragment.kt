package muhammad.fourty.saying.detailhadees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import muhammad.fourty.saying.databinding.FragmentDashboardBinding
import muhammad.fourty.saying.util.Saying


class HadeesDetailFragment : Fragment() {



    private val listOfSaying = arrayListOf(
        Saying.first, Saying.second , Saying.third,
        Saying.forth, Saying.fifth, Saying.sixth, Saying.seventh, Saying.eight, Saying.nine,
        Saying.tenth, Saying.eleventh, Saying.twelve, Saying.thirteen, Saying.fourteen,
        Saying.fifteen, Saying.sixteen, Saying.seventeen, Saying.eighteen, Saying.nineteen, Saying.twenty,
        Saying.twentyOne, Saying.twentyTwo, Saying.twentyThree)


    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //setupViewPager()
        setupRecyclerView()
        return root
    }

    private fun setupRecyclerView(){
        loadVerticalSetup()
    }



    private fun loadVerticalSetup(){
        val traditionalRecycleViewAdapter = TraditionalRecycleViewAdapter()
        binding.imagerRecycleView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext() , LinearLayoutManager.VERTICAL, false)
            adapter = traditionalRecycleViewAdapter
        }
        arguments?.getInt("stageIndex")?.let {
            traditionalRecycleViewAdapter.updateInsideAdapter(listOfSaying , 1)
            binding.imagerRecycleView.layoutManager?.scrollToPosition(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


/*
private fun loadHorizontalSetup(indexForwarded:Int){

    val recycleViewAdapter = ZoomInOutRecycleViewAdapter()
    binding.imagerRecycleView.apply {
        setHasFixedSize(true)
        //isNestedScrollingEnabled = true
        adapter = recycleViewAdapter
        layoutManager = LinearLayoutManager(requireContext() , LinearLayoutManager.HORIZONTAL, true)
        PagerSnapHelper().attachToRecyclerView(this)
    }

    recycleViewAdapter.updateZoomAdapter(listStages[indexForwarded]  )
}
 */