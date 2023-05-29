package com.bottomenu.islamicbook.ui.notificationsdua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import muhammad.fourty.saying.R
import muhammad.fourty.saying.databinding.FragmentScrollDirectionBinding

class SelectPageScrollDirectionFragment : Fragment() {

    private var _binding: FragmentScrollDirectionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       // val notificationsViewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentScrollDirectionBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.horizontalBtn.setOnClickListener{
            arguments?.getInt("stageIndex")?.let {
                findNavController().navigate(R.id.move_to_dua_read_page , bundleOf("stageIndex" to it , "scrollType" to 0))
            }
        }

        binding.verticalBtn.setOnClickListener{
            arguments?.getInt("stageIndex")?.let {
                findNavController().navigate(R.id.move_to_dua_read_page , bundleOf("stageIndex" to it , "scrollType" to 1))
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}