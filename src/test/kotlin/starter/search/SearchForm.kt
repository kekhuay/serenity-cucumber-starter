package starter.search

import org.openqa.selenium.By

internal object SearchForm {
    var SEARCH_FIELD = By.name("q")
    var SEARCH_BUTTON = By.cssSelector(".search__button")
}