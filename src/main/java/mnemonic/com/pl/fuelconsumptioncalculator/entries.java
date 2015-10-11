package mnemonic.com.pl.fuelconsumptioncalculator;

/**
 * Created by mnemonic Dell on 2015-02-04.
 */
public class entries {


    private int idrefueling;
    private String refdate;
    private String litre;
    private String kilometres;
    private String consumption;

    public int getIdrefueling() {
        return idrefueling;
    }

    public void setIdrefueling(int idrefueling) {
        this.idrefueling = idrefueling;
    }

    public String getRefdate() {
        return refdate;
    }

    public void setRefdate(String refdate) {
        this.refdate = refdate;
    }

    public String getLitre() {
        return litre;
    }

    public void setLitre(String litre) {
        this.litre = litre;
    }

    public String getKilometres() {
        return kilometres;
    }

    public void setKilometres(String kilometres) {
        this.kilometres = kilometres;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }
}
