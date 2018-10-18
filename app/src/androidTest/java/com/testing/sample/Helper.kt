package com.testing.sample

import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.w3c.dom.Text

fun textViewHasValue(): Matcher<View>{
    return object: TypeSafeMatcher<View>(){
        override fun describeTo(description: Description?) {
            description?.appendText("the view has value")
        }

        override fun matchesSafely(item: View?): Boolean {
            item?.let {
                if (it is TextView || it is EditText){
                    var text = ""
                    if (it is TextView) text = it.text.toString()
                    else if (it is EditText) text = it.text.toString()
                    return text.isNotEmpty()
                }else{
                    return false
                }
            }
            return false
        }

    }
}