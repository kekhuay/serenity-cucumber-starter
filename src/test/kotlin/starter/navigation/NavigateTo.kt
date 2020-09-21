package starter.navigation

import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.actions.Open

object NavigateTo {
    fun theDuckDuckGoHomePage(): Performable {
        return Task.where(
            "{0} opens the DuckDuckGo home page",
            Open.browserOn().the(DuckDuckGoHomePage::class.java)
        )
    }

    fun aMissingPage(): Performable {
        return Task.where(
            "{0} opens the DuckDuckGo home page",
            Open.browserOn().the(WrongPage::class.java)
        )
    }
}