package com.rivaldo.profilfakultas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list.*

class MainActivity : AppCompatActivity() {

    val list = ArrayList<Fakultas>()
    val facultyName = arrayOf(
        "Fakultas Ilmu Komputer",
        "Fakultas Pertanian",
        "Fakultas Teknik",
        "Fakultas Ekonomi dan Bisnis",
        "Rivaldo Hadi Winata"
    )

    val facultyDesc = arrayOf(
        "Fakultas Ilmu Komputer merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang terdiri dari program studi:  ",
        "Fakultas Pertanian merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang terdiri dari program studi:  ",
        "Fakultas Teknik merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang terdiri dari program studi:  ",
        "Fakultas Ekonomi dan Bisnis merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang terdiri dari program studi:  ",
        "Tempat, Tanggal lahir : Mojokerto, 11 Agustus 1999 \n Email : rivaldohadiwinata@gmail.com  "

    )

    val facultyDesc2 = arrayOf(
        " 1. Teknik Informatika \n 2. Sistem Informasi",
        " 1. Agroteknologi \n 2. Agribisnis",
        " 1. Teknik Kimia \n 2. Teknik Industri \n 3. Teknik Sipil \n 4. Teknik Lingkungan \n 5. Teknologi Pangan",
        " 1. Ekonomi Pembangunan \n 2. Akuntansi \n 3. Manajemen",
        " Github : https://github.com/RivaldoTjio \n Alamat : Kecapi 38 , Kota Mojokerto \n SMA : SMA Katolik St. Thomas Aquino"
    )

    val facultyImage = arrayOf(
        R.drawable.logoupn,
        R.drawable.logoupn,
        R.drawable.logoupn,
        R.drawable.logoupn,
        R.drawable.pasfoto
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        for (i in 0 until facultyName.size){
            list.add(Fakultas(facultyName.get(i), facultyDesc.get(i),facultyDesc2.get(i),facultyImage.get(i)))
            if (facultyName.size - 1 == i) {
                val adapter = Adapter(list)
                adapter.notifyDataSetChanged()
                rv.adapter = adapter

                adapter.setOnItemClickCallback(object : Adapter.OnItemClickCallback{
                    override fun onItemClicked(data: Fakultas) {
                        val bundle = Bundle()
                        bundle.putString("Judul", data.name)
                        bundle.putString("desc", data.desc)
                        bundle.putString("desc2", data.desc2)
                        bundle.putInt("img", data.image)
                        val description = Intent(this@MainActivity, DescriptionActivity::class.java)
                        description.putExtra(DescriptionActivity.DESC_DATA, bundle)
                        startActivity(description)
                    }
                })
            }


        }
    }
}