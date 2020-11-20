$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FlightSearch.feature");
formatter.feature({
  "line": 1,
  "name": "Test Flight Search Page",
  "description": "Description: The purpose of this feature is to search for flights on Flight Search Page",
  "id": "test-flight-search-page",
  "keyword": "Feature"
});
formatter.background({
  "line": 4,
  "name": "User is on Flight Search Page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User navigates to Flight Search Page",
  "keyword": "Given "
});
formatter.match({
  "location": "FlightSearchSteps.user_navigates_to_flight_search_page()"
});
formatter.result({
  "duration": 18754159000,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Validate the title of Flight Search Page",
  "description": "",
  "id": "test-flight-search-page;validate-the-title-of-flight-search-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "Retrieve title of Flight Search Page",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Validate that actual title is matching with the expected title of Flight Search Page",
  "keyword": "Then "
});
formatter.match({
  "location": "FlightSearchSteps.retrieve_title_of_flight_search_page()"
});
formatter.result({
  "duration": 7079800,
  "status": "passed"
});
formatter.match({
  "location": "FlightSearchSteps.validate_that_actual_title_is_matching_with_the_expected_title_of_flight_search_page()"
});
formatter.result({
  "duration": 2671800,
  "status": "passed"
});
formatter.after({
  "duration": 3110268200,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 11,
  "name": "Validate that flights are searched successfully on Flight Search page",
  "description": "",
  "id": "test-flight-search-page;validate-that-flights-are-searched-successfully-on-flight-search-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "Search flight from \u003csource\u003e to \u003cdestination\u003e",
  "keyword": "When "
});
formatter.examples({
  "comments": [
    {
      "line": 13,
      "value": "#Then Validate that flight Search is successful"
    }
  ],
  "line": 15,
  "name": "",
  "description": "",
  "id": "test-flight-search-page;validate-that-flights-are-searched-successfully-on-flight-search-page;",
  "rows": [
    {
      "cells": [
        "source",
        "destination"
      ],
      "line": 16,
      "id": "test-flight-search-page;validate-that-flights-are-searched-successfully-on-flight-search-page;;1"
    },
    {
      "cells": [
        "mum",
        "del"
      ],
      "line": 17,
      "id": "test-flight-search-page;validate-that-flights-are-searched-successfully-on-flight-search-page;;2"
    },
    {
      "cells": [
        "mum",
        "new york"
      ],
      "line": 18,
      "id": "test-flight-search-page;validate-that-flights-are-searched-successfully-on-flight-search-page;;3"
    },
    {
      "cells": [
        "del",
        "dubai"
      ],
      "line": 19,
      "id": "test-flight-search-page;validate-that-flights-are-searched-successfully-on-flight-search-page;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 4,
  "name": "User is on Flight Search Page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User navigates to Flight Search Page",
  "keyword": "Given "
});
formatter.match({
  "location": "FlightSearchSteps.user_navigates_to_flight_search_page()"
});
formatter.result({
  "duration": 10707952200,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Validate that flights are searched successfully on Flight Search page",
  "description": "",
  "id": "test-flight-search-page;validate-that-flights-are-searched-successfully-on-flight-search-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "Search flight from mum to del",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "mum",
      "offset": 19
    },
    {
      "val": "del",
      "offset": 26
    }
  ],
  "location": "FlightSearchSteps.search_flight_from_to(String,String)"
});
formatter.result({
  "duration": 1970899000,
  "status": "passed"
});
formatter.after({
  "duration": 3106967300,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "User is on Flight Search Page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User navigates to Flight Search Page",
  "keyword": "Given "
});
formatter.match({
  "location": "FlightSearchSteps.user_navigates_to_flight_search_page()"
});
formatter.result({
  "duration": 12306787100,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Validate that flights are searched successfully on Flight Search page",
  "description": "",
  "id": "test-flight-search-page;validate-that-flights-are-searched-successfully-on-flight-search-page;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "Search flight from mum to new york",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "mum",
      "offset": 19
    },
    {
      "val": "new york",
      "offset": 26
    }
  ],
  "location": "FlightSearchSteps.search_flight_from_to(String,String)"
});
formatter.result({
  "duration": 2090186700,
  "status": "passed"
});
formatter.after({
  "duration": 3176615400,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "User is on Flight Search Page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User navigates to Flight Search Page",
  "keyword": "Given "
});
formatter.match({
  "location": "FlightSearchSteps.user_navigates_to_flight_search_page()"
});
formatter.result({
  "duration": 11833640100,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Validate that flights are searched successfully on Flight Search page",
  "description": "",
  "id": "test-flight-search-page;validate-that-flights-are-searched-successfully-on-flight-search-page;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "Search flight from del to dubai",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "del",
      "offset": 19
    },
    {
      "val": "dubai",
      "offset": 26
    }
  ],
  "location": "FlightSearchSteps.search_flight_from_to(String,String)"
});
formatter.result({
  "duration": 1908714200,
  "status": "passed"
});
formatter.after({
  "duration": 3107738100,
  "status": "passed"
});
});