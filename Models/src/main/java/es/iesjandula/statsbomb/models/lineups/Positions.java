package es.iesjandula.statsbomb.models.lineups;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Positions {

    @Id
    private Long player_id;

    public Positions(Long player_id) {
        this.player_id = player_id;
    }

    private String from;

    private String to;

    private int from_period;

    private int to_period;

    private String start_reason;

    private String end_reason;

    public Positions() {
    }

    public Long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Long player_id) {
        this.player_id = player_id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getFrom_period() {
        return from_period;
    }

    public void setFrom_period(int from_period) {
        this.from_period = from_period;
    }

    public int getTo_period() {
        return to_period;
    }

    public void setTo_period(int to_period) {
        this.to_period = to_period;
    }

    public String getStart_reason() {
        return start_reason;
    }

    public void setStart_reason(String start_reason) {
        this.start_reason = start_reason;
    }

    public String getEnd_reason() {
        return end_reason;
    }

    public void setEnd_reason(String end_reason) {
        this.end_reason = end_reason;
    }

    @Override
    public String toString() {
        return "Positions{" +
                "player_id=" + player_id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", from_period=" + from_period +
                ", to_period=" + to_period +
                ", start_reason='" + start_reason + '\'' +
                ", end_reason='" + end_reason + '\'' +
                '}';
    }
}
