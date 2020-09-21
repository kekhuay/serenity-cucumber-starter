package starter.stepdefinitions

import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import net.serenitybdd.screenplay.GivenWhenThen
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.actors.OnlineCast
import org.hamcrest.Matchers
import starter.matchers.StringContainsIgnoringCase
import starter.navigation.NavigateTo
import starter.search.SearchFor
import starter.search.SearchResult

class SearchOnDuckDuckGoStepDefinitions {
    @Before
    fun setTheStage() {
        OnStage.setTheStage(OnlineCast())
    }

    @Given("^(.*) is on the DuckDuckGo home page")
    fun on_the_DuckDuckGo_home_page(actor: String?) {
        OnStage.theActorCalled(actor).attemptsTo(NavigateTo.theDuckDuckGoHomePage())
    }

    @When("^s?he searches for \"(.*)\"")
    fun search_for(term: String?) {
        OnStage.theActorInTheSpotlight().attemptsTo(SearchFor.term(term))
    }

    @Then("^all the result titles should contain the word \"(.*)\"")
    fun all_the_result_titles_should_contain_the_word(term: String?) {
        OnStage.theActorInTheSpotlight().should(
            GivenWhenThen.seeThat(
                "search result titles",
                SearchResult.titles(), Matchers.hasSize(Matchers.greaterThan(0))
            ),
            GivenWhenThen.seeThat(
                "search result titles",
                SearchResult.titles(),
                Matchers.everyItem(StringContainsIgnoringCase.Companion.containsIgnoringCase(term))
            )
        )
    }
}