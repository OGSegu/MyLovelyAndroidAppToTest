package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.example.myapplication.AboutUtilsKt.openAbout;

import android.content.pm.ActivityInfo;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class NavigationTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void fragment1ToAbout_back() {
        openAbout();
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment1ToAbout_navigateUp() {
        openAbout();
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()));
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click());
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment1To2() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment2To1_back() {
        onView(withId(R.id.bnToSecond)).perform(click());
        pressBack();
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment2To1_navigateUp() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click());
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment2To1_btn() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToFirst)).perform(click());
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment2ToAbout_back() {
        onView(withId(R.id.bnToSecond)).perform(click());
        openAbout();
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment2ToAbout_navigateUp() {
        onView(withId(R.id.bnToSecond)).perform(click());
        openAbout();
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()));
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click());
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment2To3() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToThird)).perform(click());

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3ToAbout_back() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToThird)).perform(click());
        openAbout();
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3ToAbout_navigateUp() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToThird)).perform(click());
        openAbout();
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()));
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click());
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3To2_back() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToThird)).perform(click());

        pressBack();

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3To2_navigateUp() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToThird)).perform(click());

        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click());

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3To2_btn() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToThird)).perform(click());

        onView(withId(R.id.bnToSecond)).perform(click());

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3To1_back() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToThird)).perform(click());

        pressBack();
        pressBack();

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3To1_navigateUp() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToThird)).perform(click());

        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click());
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click());

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3To1_btn() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToThird)).perform(click());

        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToFirst)).perform(click());

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3To1_btn_immediately() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToThird)).perform(click());

        onView(withId(R.id.bnToFirst)).perform(click());

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void changeOrientationMainActivity() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToThird)).perform(click());
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));

        mActivityRule.getScenario().onActivity(activity ->
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE));

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click());
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click());
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void changeOrientationAboutActivity() {
        onView(withId(R.id.bnToSecond)).perform(click());
        onView(withId(R.id.bnToThird)).perform(click());
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));
        openAbout();
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()));

        mActivityRule.getScenario().onActivity(activity ->
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE));

        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click());
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click());
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click());
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

}
