package com.dicoding.kotlinacademy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    lateinit var clubImageView: ImageView
    lateinit var clubNameTextView: TextView
    lateinit var clubDescTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailActivityUI().setContentView(this)

        val intent = intent
        val clubName = intent.getStringExtra("name")
        val clubImage = intent.getIntExtra("image", 0)
        val clubDesc = intent.getStringExtra("desc")

        Glide.with(this).load(clubImage).into(clubImageView)
        clubNameTextView.text = clubName
        clubDescTextView.text = clubDesc
    }

    inner class DetailActivityUI : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout{
                padding = dip(16)

                clubImageView = imageView().lparams(width = dip(80), height = dip(80)){
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                clubNameTextView = textView({
                    gravity = Gravity.CENTER
                    textSize = 18f
                }).lparams(width = matchParent){
                    topMargin = dip(6)
                }

                clubDescTextView = textView().lparams(width = matchParent){
                    topMargin = dip(18)
                }
            }
        }

    }
}