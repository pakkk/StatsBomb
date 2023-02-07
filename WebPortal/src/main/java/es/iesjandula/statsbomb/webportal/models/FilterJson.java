package es.iesjandula.statsbomb.webportal.models;

public class FilterJson
{
	/**	Attribute - ComboBox's text */
	private String name;
	/**	Attribute - EndPoint associate to the ComboBox */
	private String entrypoint;
	/** Attribute - EndPoint's description */
	private String description;
	
	/**
	 * Constructor by default 
	 */
	public FilterJson()
	{
		
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEntrypoint()
	{
		return entrypoint;
	}

	public void setEntrypoint(String entrypoint)
	{
		this.entrypoint = entrypoint;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
