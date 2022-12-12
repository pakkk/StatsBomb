package es.iesjandula.statsbomb.models.open_event.foul_commited;

import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 30/11/2022
 */
public class Carry
{

    private List<Integer> end_location;

    public Carry()
    {

    }

    public List<Integer> getEnd_location()
    {
        return this.end_location;
    }

    public void setEnd_location(List<Integer> end_location)
    {
        this.end_location = end_location;
    }

    @Override
    public String toString()
    {
        return "Carry{" + "end_location=" + end_location + '}';
    }
}
