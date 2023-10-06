package com.sach.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class FragmentWelcome : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val btn = view.findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            val dirToOne = FragmentWelcomeDirections.actionFragmentWelcomeToFragmentIntroOne()
            findNavController().navigate(dirToOne)
        }


        return view
    }

}