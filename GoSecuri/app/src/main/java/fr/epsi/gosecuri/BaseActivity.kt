package fr.epsi.gosecuri

import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity(){
    fun showBack(){
        val imageViewBack = findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility= View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }

    fun setHeaderTitle(text:String){
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.text=text
        textViewTitle.setSelected(true);
        textViewTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textViewTitle.setHorizontallyScrolling(true);
        textViewTitle.setSingleLine(true);
        textViewTitle.setLines(1);
    }
}