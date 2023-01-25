package es.iesjandula.statsbomb.matches_rest.stats.matches_result_filters;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchesResults
{
	@JsonProperty("match_id")
	private int matchId;
	@JsonProperty("home_team")
	private String homeTeam;
	@JsonProperty("away_team")
	private String awayTeam;
	@JsonProperty("home_score")
	private int homeScore;
	@JsonProperty("away_score")
	private int awayScore;
	@JsonProperty("match_status_360")
	private String matchStatus360;
	@JsonProperty("competition_stage")
	private String competitionStage;

	public MatchesResults()
	{

	}

	public int getMatchId()
	{
		return this.matchId;
	}

	public void setMatchId(int matchId)
	{
		this.matchId = matchId;
	}

	public String getHomeTeam()
	{
		return this.homeTeam;
	}

	public void setHomeTeam(String homeTeam)
	{
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam()
	{
		return this.awayTeam;
	}

	public void setAwayTeam(String awayTeam)
	{
		this.awayTeam = awayTeam;
	}

	public int getHomeScore()
	{
		return this.homeScore;
	}

	public void setHomeScore(int homeScore)
	{
		this.homeScore = homeScore;
	}

	public int getAwayScore()
	{
		return this.awayScore;
	}

	public void setAwayScore(int awayScore)
	{
		this.awayScore = awayScore;
	}

	public String getMatchStatus360()
	{
		return this.matchStatus360;
	}

	public void setMatchStatus360(String matchStatus360)
	{
		this.matchStatus360 = matchStatus360;
	}

	public String getCompetitionStage()
	{
		return this.competitionStage;
	}

	public void setCompetitionStage(String competitionStage)
	{
		this.competitionStage = competitionStage;
	}
}
