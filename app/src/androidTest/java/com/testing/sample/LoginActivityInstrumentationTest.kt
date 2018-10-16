package com.testing.sample

import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.testing.sample.ui.login.LoginActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityInstrumentationTest{

    @Rule
    @JvmField
     val rule = ActivityTestRule(LoginActivity::class.java)

    private val username_tobe_typed="Satheesh"
    private val correct_password ="password"
    private val wrong_password = "passme123"

    @Before
    fun init(){
        rule.activity.setFragment()
    }

    @Test
    fun testLoginSuccess(){
        Log.e("@Test","Performing login success test")
        onView((withId(R.id.txtUserName))).perform(ViewActions.typeText(username_tobe_typed))
    }
}