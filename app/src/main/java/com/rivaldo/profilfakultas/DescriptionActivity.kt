package com.rivaldo.profilfakultas

import android.content.Intent
import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
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
        val link = bundle?.getString("link")
        val email = bundle?.getString("email")
        val linkprogdi = bundle?.getStringArray("progdi")

        txtJudul.text = judul
        txtdesc.text = desc
        txtdesc2.text = desc2
        image?.let { imgLogoDesc.setImageResource(it) }
        txtlink.text = "Website Fakultas : "+link
        txtEmail.text = "Email : "+email

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            txtdesc.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        }

        if (linkprogdi != null) {
            var container = findViewById<LinearLayout>(R.id.linear_progdi)
            for (i in 0 until linkprogdi.size){
                val txt = TextView(this)
                txt.text = linkprogdi[i]
                txt.setTextColor(txtEmail.currentTextColor)
                txt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18F)
                txt.setPadding(24)
                container.addView(txt)
                txt.setOnClickListener {
                    val webviewintent = Intent(this, WebView::class.java)
                    webviewintent.putExtra("link", txt.text)
                    startActivity(webviewintent)
                }
            }
        }

        txtEmail.setOnClickListener {
            // intent email
            val sendemail = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",email, null))
            sendemail.putExtra(Intent.EXTRA_EMAIL, email.toString())
            startActivity(Intent.createChooser(sendemail,"Send Email"))
        }

        txtlink.setOnClickListener {
            val webviewintent = Intent(this, WebView::class.java)
            webviewintent.putExtra("link", link)
            startActivity(webviewintent)
        }
    }
}