package com.testing.sample

import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
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

    private val validUserDetails = HashMap<String, String>()

    @Before
    fun init(){
        validUserDetails.put("Satheesh","password")
        validUserDetails.put("Arun","password123")
    }

    private val username_tobe_typed="Satheesh"
    private val correct_password ="password"
    private val wrong_password = "passme123"

    @Test
    fun testLoginSuccess(){
        Log.e("@Test","Performing login success test")
        onView((withId(R.id.txtUserName))).perform(ViewActions.typeText(username_tobe_typed))
        onView(withId(R.id.txtUserName)).check(matches(textViewHasValue()))
        onView((withId(R.id.txtPassword))).perform(ViewActions.typeText(correct_password))
        onView((withId(R.id.btnNext))).perform(ViewActions.click())
    }
}