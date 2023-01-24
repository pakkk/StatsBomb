package es.iesjandula.statsbomb.models.three_sixty;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/** 
 * @author Alejandro Aljarilla
 * @author Manuel Canio Gil
 */
@Entity
@Table(name = "freeze_frame")
public class FreezeFrame 
{
   /**
    * Attribute
    * The position of the player on the field, with
 	  coordinates oriented in the same direction as the
 	  linked event (i.e. the actor's team attacking 0 to 120
      on the X axis.
    */
   private List<Double> location;
   /**
    * Attribute
    * Indicates the player plays on the same team as the
	  'actor' in this event.
    */
	@Column(name = "teammate", nullable = false)
   private Boolean teammate;
   /**
    * Attribute
    * Indicates the current player is the same as the one
      performing the associated event.
    */
	@Column(name = "actor", nullable = false)
   private Boolean actor;
   /**
    * Attribute - Indicates this player is a keeper.
    */
	@Column(name = "keeper", nullable = false)
   private Boolean keeper;
   
   /**
    * empty constructor
    */
   public FreezeFrame() 
   {
	   this.location = new ArrayList<>();
	   this.teammate = false;
	   this.actor = false;
	   this.keeper = false;
   }

   /**
    * parameter constructor
    * @param location
    * @param teammate
    * @param actor
    * @param keeper
    */
   public FreezeFrame(List<Double> location, Boolean teammate, 
		   			  Boolean actor, Boolean keeper) 
   {
	this.location = location;
	this.teammate = teammate;
	this.actor = actor;
	this.keeper = keeper;
   }

    /** 
     * @return the getter of the attribute location
     */
	public List<Double> getLocation() 
	{
		return this.location;
	}
	
	/**
	 * @param the setter of the attribute location
	 */
	public void setLocation(List<Double> location) 
	{
		this.location = location;
	}
	
	/**
     * @return the getter of the attribute teammate
     */
	public Boolean getTeammate() 
	{
		return this.teammate;
	}
	
	/**
	 * @param the setter of the attribute teammate
	 */
	public void setTeammate(Boolean teammate) 
	{
		this.teammate = teammate;
	}
	
	/**
     * @return the getter of the attribute actor
     */
	public Boolean getActor() 
	{
		return this.actor;
	}
	
	/**
	 * @param the setter of the attribute actor
	 */
	public void setActor(Boolean actor) 
	{
		this.actor = actor;
	}
	
	/**
     * @return the getter of the attribute keeper
     */
	public Boolean getKeeper() 
	{
		return this.keeper;
	}
	
	/**
	 * @param the setter of the attribute keeper
	 */
	public void setKeeper(Boolean keeper) 
	{
		this.keeper = keeper;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() 
	{
		return "FreezeFrame [location=" + this.location + ", teammate=" + this.teammate
				+ ", actor=" + this.actor + ", keeper="
				+ this.keeper + "]";
	}   
}
