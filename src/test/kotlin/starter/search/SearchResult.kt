package starter.search

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.TextContent

object SearchResult {
    fun titles(): Question<List<String>> {
        return Question { actor: Actor? -> TextContent.of(SearchResultList.RESULT_TITLES).viewedBy(actor).asList() }
    }
}