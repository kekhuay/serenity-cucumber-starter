package starter.search

import net.serenitybdd.screenplay.targets.Target

internal object SearchForm {
    var SEARCH_FIELD: Target = Target.the("search field")
        .locatedBy("#searchInput")
}
