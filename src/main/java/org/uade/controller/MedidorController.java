package org.uade.controller;

import org.uade.model.Medidor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class MedidorController {
    private static volatile MedidorController INSTANCE;
    private Collection<Medidor> medidores;

    private MedidorController() {
        this.medidores = new ArrayList<Medidor>();
    }

    public static MedidorController getInstance() {
        MedidorController result = INSTANCE;
        if (result != null) {
            return result;
        }
        synchronized (MedidorController.class) {
            if (INSTANCE == null) {
                INSTANCE = new MedidorController();
            }
            return INSTANCE;
        }
    }

    public Collection<Medidor> getMedidores() {
        return medidores;
    }

    public static Medidor crearMedidor() {
        Integer nroMedidor = getInstance().getMedidores().size() + 1;
        Medidor medidor = new Medidor(nroMedidor, new Date());
        getInstance().getMedidores().add( medidor );

        return medidor;
    }
}
