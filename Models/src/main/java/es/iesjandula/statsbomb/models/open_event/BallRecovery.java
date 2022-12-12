package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 30/11/2022
 */
public class BallRecovery
{

    private Boolean recovery_failure;

    public BallRecovery()
    {

    }

    public Boolean getRecovery_failure()
    {
        return this.recovery_failure;
    }

    public void setRecovery_failure(Boolean recovery_failure)
    {
        this.recovery_failure = recovery_failure;
    }

    @Override
    public String toString()
    {
        return "BallRecovery{" + "recovery_failure=" + recovery_failure + '}';
    }
}
