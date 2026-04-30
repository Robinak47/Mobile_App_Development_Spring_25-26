package com.example.firebaseauth

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val context: Context, private val productList: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productCode.text = product.code
        holder.productName.text = product.name
        holder.productCategory.text = product.catagory
        holder.productQuantity.text = product.quantity.toString()
        holder.productPrice.text = product.price.toString()
    }

    override fun getItemCount(): Int = productList.size

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productCode: TextView = view.findViewById(R.id.pCodeTB)
        val productName: TextView = view.findViewById(R.id.pNameTB)
        val productCategory: TextView = view.findViewById(R.id.pCatagoryTB)
        val productQuantity: TextView = view.findViewById(R.id.pQuantityTB)
        val productPrice: TextView = view.findViewById(R.id.pPriceTB)
    }
}