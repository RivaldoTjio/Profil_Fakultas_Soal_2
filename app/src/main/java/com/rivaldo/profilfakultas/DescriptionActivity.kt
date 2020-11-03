package com.rivaldo.profilfakultas

import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {

    companion object{
        const val TITLE_DATA = "title_data"
        const val DESC_DATA = "desc_data"
        const val IMAGE_DATA = "image_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        val bundle : Bundle? = intent.getBundleExtra(DESC_DATA)
        val judul = bundle?.getString("Judul")
        val desc = bundle?.getString("desc")
        val desc2 = bundle?.getString("desc2")
        val image = bundle?.getInt("img")

        txtJudul.text = judul
        txtdesc.text = desc
        txtdesc2.text = desc2
        image?.let { imgLogoDesc.setImageResource(it) }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            txtdesc.justificationMode = JUSTIFICATION_MODE_INTER_WORD
//        }
    }
}