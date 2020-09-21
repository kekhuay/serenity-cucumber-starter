package starter.stepdefinitions

import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.actors.OnlineCast
import net.serenitybdd.screenplay.ensure.that
import starter.navigation.NavigateTo
import starter.search.LookForInformation
import starter.search.WikipediaArticle

class SearchStepDefinitions {
    @Before
    fun setTheStage() {
        OnStage.setTheStage(OnlineCast())
    }

    @Given("{actor} is researching things on the internet")
    fun researchingThings(actor: Actor) {
        actor.wasAbleTo(NavigateTo.theWikipediaHomePage())
    }

    @When("{actor} looks up {string}")
    fun searchesFor(actor: Actor, term: String?) {
        actor.attemptsTo(
            LookForInformation.about(term!!)
        )
    }

    @Then("{actor} should see information about {string}")
    fun should_see_information_about(actor: Actor, term: String?) {
        actor.attemptsTo(
            that(WikipediaArticle.HEADING).hasText(term!!)
        )
    }
}
