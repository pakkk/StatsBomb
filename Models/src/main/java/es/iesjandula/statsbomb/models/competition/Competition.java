package es.iesjandula.statsbomb.models.competition;

import java.util.Date;


public class Competition
{

    private Integer competition_id;
    private Integer season_id;
    private String country_name;
    private String competition_name;
    private String competition_gender;
    private Boolean competition_youth;
    private Boolean competition_international;
    private String season_name;
    private String match_updated;
    private Date match_updated_date;
    private String match_updated_360;
    private Date match_updated_360_date;
    private String match_available_360;
    private Date match_available_360_date;
    private String match_available;
    private Date match_available_date;

    public Integer getCompetition_id()
    {
        return this.competition_id;
    }

    public void setCompetition_id(Integer competition_id)
    {
        this.competition_id = competition_id;
    }

    public Integer getSeason_id()
    {
        return this.season_id;
    }

    public void setSeason_id(Integer season_id)
    {
        this.season_id = season_id;
    }

    public String getCountry_name()
    {
        return this.country_name;
    }

    public void setCountry_name(String country_name)
    {
        this.country_name = country_name;
    }

    public String getCompetition_name()
    {
        return this.competition_name;
    }

    public void setCompetition_name(String competition_name)
    {
        this.competition_name = competition_name;
    }

    public String getCompetition_gender()
    {
        return this.competition_gender;
    }

    public void setCompetition_gender(String competition_gender)
    {
        this.competition_gender = competition_gender;
    }

    public Boolean getCompetition_youth()
    {
        return this.competition_youth;
    }

    public void setCompetition_youth(Boolean competition_youth)
    {
        this.competition_youth = competition_youth;
    }

    public Boolean getCompetition_international()
    {
        return this.competition_international;
    }

    public void setCompetition_international(Boolean competition_international)
    {
        this.competition_international = competition_international;
    }

    public String getSeason_name()
    {
        return this.season_name;
    }

    public void setSeason_name(String season_name)
    {
        this.season_name = season_name;
    }

    public String getMatch_updated()
    {
        return this.match_updated;
    }

    public void setMatch_updated(String match_updated)
    {
        this.match_updated = match_updated;
    }

    public Date getMatch_updated_date()
    {
        return this.match_updated_date;
    }

    public void setMatch_updated_date(Date match_updated_date)
    {
        this.match_updated_date = match_updated_date;
    }

    public String getMatch_updated_360()
    {
        return this.match_updated_360;
    }

    public void setMatch_updated_360(String match_updated_360)
    {
        this.match_updated_360 = match_updated_360;
    }

    public Date getMatch_updated_360_date()
    {
        return this.match_updated_360_date;
    }

    public void setMatch_updated_360_date(Date match_updated_360_date)
    {
        this.match_updated_360_date = match_updated_360_date;
    }

    public String getMatch_available_360()
    {
        return this.match_available_360;
    }

    public void setMatch_available_360(String match_available_360)
    {
        this.match_available_360 = match_available_360;
    }

    public Date getMatch_available_360_date()
    {
        return this.match_available_360_date;
    }

    public void setMatch_available_360_date(Date match_available_360_date)
    {
        this.match_available_360_date = match_available_360_date;
    }

    public String getMatch_available()
    {
        return this.match_available;
    }

    public void setMatch_available(String match_available)
    {
        this.match_available = match_available;
    }

    public Date getMatch_available_date()
    {
        return this.match_available_date;
    }

    public void setMatch_available_date(Date match_available_date)
    {
        this.match_available_date = match_available_date;
    }

    @Override
    public String toString()
    {
        return "Competition{" +
                "competition_id=" + competition_id +
                ", season_id=" + season_id +
                ", country_name='" + country_name + '\'' +
                ", competition_name='" + competition_name + '\'' +
                ", competition_gender='" + competition_gender + '\'' +
                ", competition_youth=" + competition_youth +
                ", competition_international=" + competition_international +
                ", season_name='" + season_name + '\'' +
                ", match_updated='" + match_updated + '\'' +
                ", match_updated_date=" + match_updated_date +
                ", match_updated_360='" + match_updated_360 + '\'' +
                ", match_updated_360_date=" + match_updated_360_date +
                ", match_available_360='" + match_available_360 + '\'' +
                ", match_available_360_date=" + match_available_360_date +
                ", match_available='" + match_available + '\'' +
                ", match_available_date=" + match_available_date +
                '}';
    }
}
