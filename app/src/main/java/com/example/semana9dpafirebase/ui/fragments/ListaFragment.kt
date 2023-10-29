package com.example.semana9dpafirebase.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.semana9dpafirebase.R
import com.example.semana9dpafirebase.adapter.ProductAdapter
import com.example.semana9dpafirebase.model.ProductModel
import com.google.firebase.firestore.FirebaseFirestore

class ListaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View= inflater.inflate(R.layout.fragment_lista, container, false)

        val db=FirebaseFirestore.getInstance()
        var lstProducts: List<ProductModel>
        val rvProduct: RecyclerView = view.findViewById(R.id.rvProduct)
        db.collection("products")
            .addSnapshotListener{snap, error ->
                if (error!=null){
                    return@addSnapshotListener
                }
                lstProducts =snap!!.documents.map { document ->
                    ProductModel(document["description"].toString(),document["price"].toString(),document["imageUrl"].toString())
                }

                rvProduct.adapter=ProductAdapter(lstProducts)
                rvProduct.layoutManager=LinearLayoutManager(requireContext())

            }



        return view
    }

}