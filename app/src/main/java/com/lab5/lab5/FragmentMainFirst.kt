package com.lab5.lab5

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lab5.lab5.databinding.ActivityFirstExerciseBinding
import com.lab5.lab5.databinding.FragmentMainFirstBinding

class FragmentMainFirst : Fragment() {

    private lateinit var binding: FragmentMainFirstBinding
    private var position:Int = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        position = requireArguments().getInt("position")
        if(position === 0){
            binding.imageView.setImageResource(R.drawable.image1)
            binding.root.setBackgroundColor(Color.GREEN)
        }else if(position === 1){
            binding.imageView.setImageResource(R.drawable.image2)
            binding.root.setBackgroundColor(Color.GRAY)
        }else if (position === 2){
            binding.imageView.setImageResource(R.drawable.image3)
            binding.root.setBackgroundColor(Color.MAGENTA)
        }

    }

    companion object{
        fun newInstance(position : Int):FragmentMainFirst {
            val args = Bundle()
            args.putInt("position",position)
            
            val fragment = FragmentMainFirst()
            fragment.arguments = args
            return fragment
        }
    }
}