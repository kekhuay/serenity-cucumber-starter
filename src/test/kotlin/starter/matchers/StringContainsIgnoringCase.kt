package starter.matchers

import org.hamcrest.Factory
import org.hamcrest.Matcher
import org.hamcrest.core.SubstringMatcher

class StringContainsIgnoringCase(substring: String?) : SubstringMatcher(substring) {
    override fun evalSubstringOf(string: String): Boolean {
        return string.toLowerCase().indexOf(substring.toLowerCase()) >= 0
    }

    override fun relationship(): String {
        return "containing"
    }

    companion object {
        @Factory
        fun containsIgnoringCase(substring: String?): Matcher<String?> {
            return StringContainsIgnoringCase(substring)
        }
    }
}