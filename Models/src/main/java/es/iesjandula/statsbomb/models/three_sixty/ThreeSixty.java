package es.iesjandula.statsbomb.models.three_sixty;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Alejandro Aljarilla
 * @author Manuel Canio Gil
 */
@Entity
@Table(name = "three_sixty")
public class ThreeSixty 
{
	/**
	 * Attribute
	 * The unique identifier for the event matching this
	   freeze frame.
	 */
	@Id
	@Column(name = "event_uuid", length = 120)
	private String event_uuid;
	/**
	 * Attribute
	 * An array of coordinates describing the polygon
	   visible to the camera, from which the 360 freeze
	   frame was collected. This shape makes it explicit
	   which areas were visible. Player locations may be
	   outside the visible area where these were
	   manually placed. The format of the array is: [X1
	   Y1 X2 Y2... Xn Yn X1 Y1], describing a closed loop
	   around the visible area of the pitch. The visible
	   area can also be empty where the camera was
	   not on the pitch at the time the frame was
	   collected.
	 */
	@Column(name = "visible_area")
	private List<Double> visible_area;
	/**
	 * Attribute
	 * Like shots, this is an array of freeze frame
	   objects, similar to those described in the Events
	   API spec. However these freeze frames will not
	   contain player identification, beyond their team
	   (except for the player performing the current
	   event who will be marked as the actor).
	 */
    @OneToMany
	private List<FreezeFrame> freeze_frame;
	
	/**
	 * empty constructor
	 */
	public ThreeSixty() 
	{
		this.event_uuid = "";
		this.visible_area = new ArrayList<>();
		this.freeze_frame = new ArrayList<>();
	}

	/**
	 * parameter constructor
	 * @param event_uuid
	 * @param visible_area
	 * @param freeze_frame
	 */
	public ThreeSixty(String event_uuid, List<Double> visible_area, 
			          List<FreezeFrame> freeze_frame) 
	{
		this.event_uuid = event_uuid;
		this.visible_area = visible_area;
		this.freeze_frame = freeze_frame;
	}

	/**
	 * @return the getter of the attribute event_uuid
	 */
	public String getEvent_uuid() 
	{
		return this.event_uuid;
	}

	/**
	 * @param event_uuid with the identifier of the event
	 */
	public void setEvent_uuid(String event_uuid) 
	{
		this.event_uuid = event_uuid;
	}

	/**
	 * @return the getter of the attribute visible_area
	 */
	public List<Double> getVisible_area() 
	{
		return this.visible_area;
	}

	/**
	 * @param visible_area with the coordinates describing the polygon visible camera
	 */
	public void setVisible_area(List<Double> visible_area) 
	{
		this.visible_area = visible_area;
	}

	/**
	 * @return the getter of the attribute freeze_frame
	 */
	public List<FreezeFrame> getFreeze_frame() 
	{
		return this.freeze_frame;
	}

	/**
	 * 
	 * @param freeze_frame with the atributes teammate, location, actor and keeper
	 */
	public void setFreeze_frame(List<FreezeFrame> freeze_frame) 
	{
		this.freeze_frame = freeze_frame;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() 
	{
		return "ThreeSixty [event_uuid=" + this.event_uuid + ", visible_area=" 
	            + this.visible_area + ", freeze_frame="
				+ this.freeze_frame + "]";
	}	
}
