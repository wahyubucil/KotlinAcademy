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

        Glide.with(this).load(R.drawable.img_acm).into(clubImageView)
        clubNameTextView.text = "Arsenal FC"
        clubDescTextView.text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
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