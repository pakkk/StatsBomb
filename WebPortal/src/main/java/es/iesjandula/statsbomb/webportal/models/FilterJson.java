package es.iesjandula.statsbomb.webportal.models;

public class FilterJson
{
	/**	Attribute - ComboBox's text */
	private String name;
	/**	Attribute - EndPoint associate to the ComboBox */
	private String endpoint;
	/** Attribute - EndPoint's description */
	private String description;
	
	/**
	 * Constructor by default 
	 */
	public FilterJson()
	{
		
	}

	/**
	 * @return the ComboBox's text
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name, ComboBox's text
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return EndPoint associate to the ComboBox
	 */
	public String getEndpoint()
	{
		return this.endpoint;
	}

	/**
	 * @param endpoint, EndPoint associate to the ComboBox
	 */
	public void setEndpoint(String endpoint)
	{
		this.endpoint = endpoint;
	}

	/**
	 * @return EndPoint's description
	 */
	public String getDescription()
	{
		return this.description;
	}

	/**
	 * @param description, EndPoint's description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
}
