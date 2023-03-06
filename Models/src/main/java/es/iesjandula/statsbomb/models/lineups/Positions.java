package es.iesjandula.statsbomb.models.lineups;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Table(name = "positions")
@Entity
public class Positions
{
	@Id
	private Long position_id;

	@Column(length = 15)
	private String position;
	@Column(length = 15)
	private String from;
	@Column(length = 15)
	private String to;
	@Column(length = 10)
	private int from_period;
	@Column(length = 10)
	private int to_period;
	@Column(length = 15)
	private String start_reason;
	@Column(length = 15)
	private String end_reason;

	@ManyToOne
	@JoinColumn(name = "player_id")
	private Lineup lineup;

	public Positions()
	{
	}

	public Long getPosition_id()
	{
		return position_id;
	}

	public void setPosition_id(Long position_id)
	{
		this.position_id = position_id;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public String getFrom()
	{
		return from;
	}

	public void setFrom(String from)
	{
		this.from = from;
	}

	public String getTo()
	{
		return to;
	}

	public void setTo(String to)
	{
		this.to = to;
	}

	public int getFrom_period()
	{
		return from_period;
	}

	public void setFrom_period(int from_period)
	{
		this.from_period = from_period;
	}

	public int getTo_period()
	{
		return to_period;
	}

	public void setTo_period(int to_period)
	{
		this.to_period = to_period;
	}

	public String getStart_reason()
	{
		return start_reason;
	}

	public void setStart_reason(String start_reason)
	{
		this.start_reason = start_reason;
	}

	public String getEnd_reason()
	{
		return end_reason;
	}

	public void setEnd_reason(String end_reason)
	{
		this.end_reason = end_reason;
	}

	public Lineup getLineup()
	{
		return lineup;
	}

	public void setLineup(Lineup lineup)
	{
		this.lineup = lineup;
	}

	@Override
	public String toString()
	{
		return "Positions [position_id=" + position_id + ", position=" + position + ", from=" + from + ", to=" + to
				+ ", from_period=" + from_period + ", to_period=" + to_period + ", start_reason=" + start_reason
				+ ", end_reason=" + end_reason + ", lineup=" + lineup + "]";
	}
}
