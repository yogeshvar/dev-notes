Feature: Cricket team scoring
    Cricket team should start with zero
    Capture overs,run, wicket after each ball.

    Scenario: New team should start with zero
        Given I register a team
        Then my score is 0

    Scenario: Batsmen hits a boundary
        Given I register a team
        When a batsmen hits 4
        Then my score will be increased by 4.
