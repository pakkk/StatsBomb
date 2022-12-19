package es.iesjandula.statsbomb.models.matches;

public class Metadata
{
    private String data_version;
    private String shot_fidelity_version;
    private String xy_fidelity_version;

    public Metadata()
    {
    }

    public String getData_version()
    {
        return data_version;
    }

    public void setData_version(String data_version)
    {
        this.data_version = data_version;
    }

    public String getShot_fidelity_version()
    {
        return shot_fidelity_version;
    }

    public void setShot_fidelity_version(String shot_fidelity_version)
    {
        this.shot_fidelity_version = shot_fidelity_version;
    }

    public String getXy_fidelity_version()
    {
        return xy_fidelity_version;
    }

    public void setXy_fidelity_version(String xy_fidelity_version)
    {
        this.xy_fidelity_version = xy_fidelity_version;
    }

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
