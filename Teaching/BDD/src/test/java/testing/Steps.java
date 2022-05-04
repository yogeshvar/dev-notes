package testing;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import testing.Team;

public class Steps {

    private Team team;

    @Given("^I register a team$")
    public void iRegisterATeam() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        team = new Team();
    }

    @Then("^my score is (\\d+)$")
    public void myScoreIs(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(0, team.getScore(arg1));
    }

    @When("^a batsmen hits (\\d+)$")
    public void aBatsmenHits(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(4, team.boundary(0));
    }

    @Then("^my score will be increased by (\\d+)\\.$")
    public void myScoreWillBeIncreasedBy(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(8, team.boundary(4));
    }

}