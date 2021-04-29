package com.example.epass.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.epass.R
import com.example.epass.domain.Pass
import com.example.epass.databinding.RecViewItemBinding

class MyRecAdapter (private val passesList:List<Pass>?) :
    RecyclerView.Adapter<MyRecAdapter.ViewHolder>()
{

    inner class ViewHolder(val binding:RecViewItemBinding) : RecyclerView.ViewHolder( binding.root )
    {
        fun bind(pass: Pass?)
        {
           binding.passName.text = pass?.name

          /* binding.completed.setOnClickListener {
               if ( habit?.done_dates?.isEmpty()!!  || ((  (System.currentTimeMillis()/3600000) - habit?.done_dates?.last()!!.toLong())   >= ((habit.count*24)/habit.frequency) )){
                   doneListener(habit!!)
                   binding.completed.isActivated = true
               }
           }
           binding.cardview.setOnClickListener{
               editListner(habit)
           }
           binding.cardview.setOnLongClickListener( View.OnLongClickListener {
               clickListener(habit!!)
           })*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding:RecViewItemBinding = DataBindingUtil.inflate(inflater,
            R.layout.rec_view_item,parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount():Int
    {
        // TODO : should be fixed
        var a = 0
        try{
            a = passesList!!.size
        }catch (e:Exception){

        }
        return a
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        // just a different way to bind the data
        holder.bind(passesList?.get(position))
    }

    /*private fun setCompleted(binding:RecViewLayoutBinding, habit:Habit?){
        binding.completed.isChecked = !(habit?.done_dates?.isEmpty()!!  ||  ( (System.currentTimeMillis()/3600000 - habit?.done_dates?.last()!!.toLong())   >= ((habit.count*24)/habit.frequency) ))
    }*/
}