package es.iesjandula.statsbomb.models.matches;
/**
 * @author David Armijo
 * @author Jesus Guerrero
 *
 * Contains a list of tags detailing the versions of various parts of
 * the event data for this match.
 */
public class Metadata
{

    /**
     * Attribute -
     * The version number for the method in
     * which the data was collected.
     */
    private String data_version;
    /**
     * Attribute -
     * version of the shot fidelity
     */
    private String shot_fidelity_version;
    /**
     * Attribute -
     * version of the xy fidelity
     */
    private String xy_fidelity_version;

    /**
     * Default constructor
     */
    public Metadata()
    {

    }

    /**
     * @return the data version in metadatas
     */
    public String getData_version()
    {
        return data_version;
    }

    /**
     * @param data_version in metadata
     */
    public void setData_version(String data_version)
    {
        this.data_version = data_version;
    }

    /**
     * @return the shot fidelity version
     */
    public String getShot_fidelity_version()
    {
        return shot_fidelity_version;
    }

    /**
     * @param shot_fidelity_version in metadata
     */
    public void setShot_fidelity_version(String shot_fidelity_version)
    {
        this.shot_fidelity_version = shot_fidelity_version;
    }

    /**
     * @return the xy fidelity version in metadata
     */
    public String getXy_fidelity_version()
    {
        return xy_fidelity_version;
    }

    /**
     * @param xy_fidelity_version in metadata
     */
    public void setXy_fidelity_version(String xy_fidelity_version)
    {
        this.xy_fidelity_version = xy_fidelity_version;
    }

    /**
     * @return the instance of metadata
     */
    @Override
    public String toString()
    {
        return "Metadata{" +
                "data_version='" + data_version +
                ", shot_fidelity_version='" + shot_fidelity_version +
                ", xy_fidelity_version='" + xy_fidelity_version +
                '}';
    }
}
