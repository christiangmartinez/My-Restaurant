package com.epicodus.myrestaurants;


import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.epicodus.myrestaurants.ui.RestaurantActivity;

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
import static org.hamcrest.Matchers.not;

public class RestaurantsActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<RestaurantActivity> activityTestRule =
            new ActivityTestRule<>(RestaurantActivity.class);

    @Test
    public void listItemClickDisplaysToastWithCorrectRestaurant() {
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String shopName = "Pip's Original";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withText(shopName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(shopName)));
    }
}
