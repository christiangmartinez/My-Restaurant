package com.example.guest.myrestaurants;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.guest.myrestaurants.R;
import com.example.guest.myrestaurants.activityRestaurants;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.IsNot.not;


public class activityRestaurantsInstrumentationTest {

    @Rule
    public ActivityTestRule<activityRestaurants> activityTestRule =
            new ActivityTestRule<>(activityRestaurants.class);

    @Test
    public void listItemClickDisplaysToastWithCorrectRestaurant(){
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String restaurantName = "Mi Mero Mole";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withText(restaurantName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(restaurantName)));
    }
}