package es.iesjandula.statsbomb.webportal.models;

import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 07/02/2023
 */
public class Lineups
{

    private String base_url;
    private List<FilterJson> endpoints;


    public Lineups()
    {

    }

    public Lineups(String base_url, List<FilterJson> endpoints)
    {
        this.base_url = base_url;
        this.endpoints = endpoints;
    }

    public String getBase_url()
    {
        return base_url;
    }

    public void setBase_url(String base_url)
    {
        this.base_url = base_url;
    }

    public List<FilterJson> getEndpoints()
    {
        return endpoints;
    }

    public void setEndpoints(List<FilterJson> endpoints)
    {
        this.endpoints = endpoints;
    }
}
