package model;
import classe.*;
import java.util.ArrayList;
import java.util.*;

public class Model_tabRsrvSej {
    private Reservation[] reservations;
    private Sejour[] sejours;
    
    public Model_tabRsrvSej() {
        reservations = new Reservation[0];
        sejours = new Sejour[0];
    }
    
    public void registerRsrv(Reservation[] newRsrv) {
	System.out.println("Tableau de réservations mis à jour");
        reservations = newRsrv;
    }
    
    public Reservation[] getCurrentRsrv() {
        return this.reservations;
    }
    
    public void registerSej(Sejour[] newSej) {
	System.out.println("Tableau de séjours mis à jour");
        sejours = newSej;
    }

    public Sejour[] getCurrentSej(){
	return this.sejours;
    }
}
