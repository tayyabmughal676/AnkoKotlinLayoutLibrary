package com.example.mrtayyab.ankokotlin

import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v4.app.FrameMetricsAggregator
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivityUI : AnkoComponent<MainActivity>{
    override fun createView(ui: AnkoContext<MainActivity>)= with(ui){
        frameLayout{

            var textField = editText{
                hint = "Text toast and Snackbar"
        }.lparams(width = matchParent){
                margin = dip(12)
                topMargin = dip(30)
            }
            imageView(R.drawable.ic_android_black_24dp){
                onClick {
                    this@imageView.imageTintList =
                            ColorStateList.valueOf(Color.GREEN)
                }

            }.lparams(dip(72) , dip(72)){

                gravity = Gravity.CENTER
            }

           linearLayout(){
               button("Show Toast"){
                   onClick {
                       toast(textField.text)
                   }
               }

               button("Show Snack bar"){
                   onClick {
                       longSnackbar(this@frameLayout , textField.text.toString())
                   }
               }

               button("Show"){
                  setOnClickListener {
                      alert(textField.text.toString() , "Parho Likho Computer Science"){
                          yesButton { toast("Okay") }
                          noButton { }
                      }.show()
                  }
               }
           }.lparams{
               gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
               bottomMargin = dip(72)
           }

        }
    }


}