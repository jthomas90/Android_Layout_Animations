package com.lambdaschool.sprint2_challenge

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.grocery_list_items.view.*

class ShoppingListAdapter (val groceryList: MutableList<ShoppingListModel>) : RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.grocery_list_items,parent,false) as View)
    }

    override fun getItemCount(): Int {
        return groceryList.size
    }

    private var context: Context? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pickedItems = groceryList[position]
        holder.bindModel(pickedItems)

        holder.shoppingItemParent.setOnClickListener {
            pickedItems.isShare = !pickedItems.isShare
            notifyItemChanged(position)
        }
    }

     fun setEnterAmimation(viewToAnimate : View, position: Int) {
         val animation : Animation = AnimationUtils.loadAnimation(viewToAnimate.context, android.R.anim.slide_in_left)
         viewToAnimate.startAnimation(animation)

     }  //how to make custom one at 47 min mark

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val shoppingImageView: ImageView = view.grocery_image_view
        val shoppingNameView: TextView = view.grocery_name_view
        val shoppingItemParent: LinearLayout = view.grocery_item_parent


        fun bindModel(pickedItems: ShoppingListModel) {
            shoppingImageView.setImageResource(pickedItems.imageId)
            shoppingNameView.text = pickedItems.groceries
            if (pickedItems.isShare)
                shoppingItemParent.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.colorPrimary))
            else
                shoppingItemParent.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.White))



        }

    }

    //setEnterAmimation(viewHolder.shoppingItemParent, position) //not working with my code ??
}