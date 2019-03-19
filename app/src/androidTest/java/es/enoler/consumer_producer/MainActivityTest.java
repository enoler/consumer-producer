package es.enoler.consumer_producer;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

	@Rule
	public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

	@Test
	public void mainActivityTest() {
		ViewInteraction btAddProducer = onView(allOf(withId(R.id.bt_add_producer), childAtPosition(allOf(withId(R.id.ll_buttons), childAtPosition(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class), 1)), 0), isDisplayed()));
		btAddProducer.check(matches(isDisplayed()));

		ViewInteraction btAddConsumer = onView(allOf(withId(R.id.bt_add_consumer), childAtPosition(allOf(withId(R.id.ll_buttons), childAtPosition(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class), 1)), 1), isDisplayed()));
		btAddConsumer.check(matches(isDisplayed()));

		ViewInteraction rvItems = onView(allOf(withId(R.id.rv_items), childAtPosition(childAtPosition(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class), 1), 0), isDisplayed()));
		rvItems.check(matches(isDisplayed()));
	}

	private static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {

		return new TypeSafeMatcher<View>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("Child at position " + position + " in parent ");
				parentMatcher.describeTo(description);
			}

			@Override
			public boolean matchesSafely(View view) {
				ViewParent parent = view.getParent();
				return parent instanceof ViewGroup && parentMatcher.matches(parent) && view.equals(((ViewGroup) parent).getChildAt(position));
			}
		};
	}
}