package muhammad.fourty.saying.detaildua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import muhammad.fourty.saying.R
import muhammad.fourty.saying.databinding.FragmentDashboardBinding


class DuaDetailFragment : Fragment() {
    val zeroStage = intArrayOf(
        R.mipmap.khutba_start)

    val firstStage = intArrayOf(
        R.mipmap.img1_1,
        R.mipmap.img1_2_copy,
        R.mipmap.img1_3_copy,
        R.mipmap.img1_4,
        R.mipmap.img1_5,
        R.mipmap.img1_6,
        R.mipmap.img1_7,
        R.mipmap.img1_8,
        R.mipmap.img1_9,
        R.mipmap.img1_10,
        R.mipmap.img1_11,
        R.mipmap.img1_12,
        R.mipmap.img1_13,
        R.mipmap.img1_14,
        R.mipmap.img1_15,
        R.mipmap.img1_16,
        R.mipmap.img1_17
    )

    val secondStage  = intArrayOf(
        R.mipmap.img2_1,
        R.mipmap.img2_2,
        R.mipmap.img2_3,
        R.mipmap.img2_4,
        R.mipmap.img2_5,
        R.mipmap.img2_6,
        R.mipmap.img2_7,
        R.mipmap.img2_8,
        R.mipmap.img2_9,
        R.mipmap.img2_10,
        R.mipmap.img2_11,
        R.mipmap.img2_12,
        R.mipmap.img2_13,
        R.mipmap.img2_14,
        R.mipmap.img2_15,
        R.mipmap.img2_16,
        R.mipmap.img2_17,
        R.mipmap.img2_18
    )

    val thirdStage = intArrayOf(
        R.mipmap.img3_1,
        R.mipmap.img3_2,
        R.mipmap.img3_3,
        R.mipmap.img3_4,
        R.mipmap.img3_5,
        R.mipmap.img3_6,
        R.mipmap.img3_7,
        R.mipmap.img3_8,
        R.mipmap.img3_9,
    )

    val forthStage= intArrayOf(
        R.mipmap.img4_1,
        R.mipmap.img4_2,
        R.mipmap.img4_3,
        R.mipmap.img4_4,
        R.mipmap.img4_5,
        R.mipmap.img4_6,
        R.mipmap.img4_7,
        R.mipmap.img4_8,
        R.mipmap.img4_9,
        R.mipmap.img4_10,
        R.mipmap.img4_11,
        R.mipmap.img4_12,
        R.mipmap.img4_13,
        R.mipmap.img4_14,
        R.mipmap.img4_15,
        R.mipmap.img4_16,
        R.mipmap.img4_17,
        R.mipmap.img4_18,
        R.mipmap.img4_19
    )

    val fifthStage= intArrayOf(
        R.mipmap.img5_1,
        R.mipmap.img5_2,
        R.mipmap.img5_3,
        R.mipmap.img5_4,
        R.mipmap.img5_5,
        R.mipmap.img5_6,
        R.mipmap.img5_7,
        R.mipmap.img5_8,
        R.mipmap.img5_9,
        R.mipmap.img5_10,
        R.mipmap.img5_11,
        R.mipmap.img5_12,
        R.mipmap.img5_13,
        R.mipmap.img5_14,
        R.mipmap.img5_15,
        R.mipmap.img5_16
    )

    val sixthStage= intArrayOf(
        R.mipmap.img6_1,
        R.mipmap.img6_2,
        R.mipmap.img6_3,
        R.mipmap.img6_4,
        R.mipmap.img6_5,
        R.mipmap.img6_6,
        R.mipmap.img6_7,
        R.mipmap.img6_8,
        R.mipmap.img6_9
    )

    val seventhStage= intArrayOf(
        R.mipmap.img7_1,
        R.mipmap.img7_2,
        R.mipmap.img7_3,
        R.mipmap.img7_4,
        R.mipmap.img7_5,
        R.mipmap.img7_6,
        R.mipmap.img7_7,
        R.mipmap.img7_8,
        R.mipmap.img7_9,
        R.mipmap.img7_10,
        R.mipmap.img7_11,
        R.mipmap.img7_12,
        R.mipmap.img7_13,
        R.mipmap.img7_14,
        R.mipmap.img7_15,
        R.mipmap.img7_16,
        R.mipmap.img7_17,
        R.mipmap.img7_18,
        R.mipmap.img7_19
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