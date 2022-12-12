package es.iesjandula.statsbomb.models.open_event;

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
