package com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.rsh_engineering.tkachenkoni.checkpressurelist.R


class WeightFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weight, container, false)
        setHasOptionsMenu(true)



        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.weight_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

//        if(item.itemId == R.id.menu_add){
//            insertDataToDb()
//        }

        return super.onOptionsItemSelected(item)
    }

}