package starter.search

import org.openqa.selenium.By

internal object SearchForm {
    var SEARCH_FIELD: By = By.name("q")
    var SEARCH_BUTTON: By = By.cssSelector(".search__button")
}