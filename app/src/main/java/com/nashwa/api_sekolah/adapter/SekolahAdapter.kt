package com.nashwa.api_sekolah.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nashwa.api_sekolah.DetailSekolahActivity
import com.nashwa.api_sekolah.R
import com.nashwa.api_sekolah.model.SekolahResponse
import com.squareup.picasso.Picasso

class SekolahAdapter(

    val dataSekolah: ArrayList<SekolahResponse.ListItems>
): RecyclerView.Adapter<SekolahAdapter.ViewHolder>()
{
    class  ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgSekolah = view.findViewById<ImageView>(R.id.imgSekolah)
        val tvNama = view.findViewById<TextView>(R.id.tvNama)
        val tvNoTelp = view.findViewById<TextView>(R.id.tvNoTelp)
        val tvAkreditasi = view.findViewById<TextView>(R.id.tvAkreditasi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.layout_item_sekolah,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return dataSekolah.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val hasilResponse = dataSekolah[position]
        Picasso.get().load(hasilResponse.gambar).into(holder.imgSekolah)
        holder.tvNama.text = hasilResponse.nama
        holder.tvNoTelp.text = hasilResponse.no_telp
        holder.tvAkreditasi.text = hasilResponse.akreditasi

        holder.itemView.setOnClickListener(){
            val intent = Intent(holder.itemView.context,DetailSekolahActivity::class.java).apply {
                putExtra("gambar", hasilResponse.gambar)
                putExtra("nama",hasilResponse.nama)
                putExtra("no_telp", hasilResponse.no_telp)
                putExtra("akreditasi", hasilResponse.akreditasi)
                putExtra("informasi_sekolah", hasilResponse.informasi_sekolah)
            }
            holder.imgSekolah.context.startActivity(intent)
        }
    }

    fun setData(data: List<SekolahResponse.ListItems>){
        dataSekolah.clear()
        dataSekolah.addAll(data)
    }

}