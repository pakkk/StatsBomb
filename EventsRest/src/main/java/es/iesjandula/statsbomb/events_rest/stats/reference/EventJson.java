package es.iesjandula.statsbomb.events_rest.stats.reference;

import es.iesjandula.statsbomb.models.event.Player;
import es.iesjandula.statsbomb.models.event.Team;
import es.iesjandula.statsbomb.models.event.shot.Shot;
import es.iesjandula.statsbomb.models.event.Type;

public class EventJson
{
	int minute;
	int second;
	Team team;
	Player player;
	Shot shot;
	Type type;
	
	// EMPTY CONSTRUCTOR
	public EventJson() 
	{

	}
	
	// GETTERS AND SETTERS
		public int getMinute()
		{
			return minute;
		}
		public void setMinute(int minute) 
		{
			this.minute = minute;
		}
		public int getSecond() 
		{
			return second;
		}
		public void setSecond(int second) 
		{
			this.second = second;
		}
		public Team getTeam() 
		{
			return team;
		}
		public void setTeam(Team team) 
		{
			this.team = team;
		}
		public Player getPlayer()
		{
			return player;
		}
		public void setPlayer(Player player) 
		{
			this.player = player;
		}
		public Shot getShot() 
		{
			return shot;
		}
		public void setShot(Shot shot)
		{
			this.shot = shot;
		}
		public Type getType() 
		{
			return type;
		}
		public void setType(Type type) 
		{
			this.type = type;
		}
		// TO STRING
		@Override
		public String toString()
		{
			return "EventJson [minute=" + minute + ", second=" + second + ", team=" + team + ", player=" + player
					+ ", shot=" + shot + ", type=" + type + "]";
		}
}
