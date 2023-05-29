package muhammad.fourty.saying.detailhadees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import muhammad.fourty.saying.R
import muhammad.fourty.saying.databinding.FragmentDashboardBinding


class HadeesDetailFragment : Fragment() {


    val firstStage = intArrayOf(
        R.mipmap.img1_1,
    )

    val secondStage  = intArrayOf(
        R.mipmap.img2_1,
    )

    val thirdStage = intArrayOf(
        R.mipmap.img3_1,
    )

    val forthStage= intArrayOf(
        R.mipmap.img4_1,
    )

    val fifthStage= intArrayOf(
        R.mipmap.img5_1,
    )

    val sixthStage= intArrayOf(
        R.mipmap.img6_1,
    )

    val seventhStage= intArrayOf(
        R.mipmap.img7_1,
    )

    private val listStages = arrayListOf(firstStage, secondStage,thirdStage, forthStage, fifthStage, sixthStage, seventhStage)


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
        arguments?.getInt("stageIndex")?.let {indexForwarded->
            arguments?.getInt("scrollType")?.let { scrollDirection ->
                if(scrollDirection ==  0)
                    loadHorizontalSetup(indexForwarded)
                else
                    loadVerticalSetup()
            }
        }
    }


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


    private fun loadVerticalSetup(){
        val traditionalRecycleViewAdapter = TraditionalRecycleViewAdapter()
        binding.imagerRecycleView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext() , LinearLayoutManager.VERTICAL, false)
            adapter = traditionalRecycleViewAdapter
        }
        arguments?.getInt("stageIndex")?.let {
            traditionalRecycleViewAdapter.updateInsideAdapter(listStages[it] , 1)
        }

    }



    /*
    private fun setupViewPager(){

        // Object of ViewPager2Adapter
        // this will passes the
        // context to the constructor
        // of ViewPager2Adapter

        // Object of ViewPager2Adapter
        // this will passes the
        // context to the constructor
        // of ViewPager2Adapter
        val viewPager2Adapter = ViewPager2Adapter()

        // adding the adapter to viewPager2
        // to show the views in recyclerview

        // adding the adapter to viewPager2
        // to show the views in recyclerview
        binding.viewpager.adapter = viewPager2Adapter

        // To get swipe event of viewpager2

        // To get swipe event of viewpager2
        binding.viewpager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            // This method is triggered when there is any scrolling activity for the current page
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            // triggered when you select a new page
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            // triggered when there is
            // scroll state will be changed
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
    }
    */

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}