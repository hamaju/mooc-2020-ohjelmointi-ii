/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanakirja;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author juhani
 */
public class MuistavaSanakirja {
    
    private List<String> sanat;
    private String tiedosto;
    
    public MuistavaSanakirja() {
        this.sanat = new ArrayList<>();
    }
    
    public MuistavaSanakirja(String tiedosto) {
        this.sanat = new ArrayList<>();
        this.tiedosto = tiedosto;
    }
    
    public void lisaa(String sana, String kaannos) {
        this.sanat.add(sana + ":" + kaannos);
    }
    
    public String kaanna(String sana) {
        for (String s : sanat) {
            String[] osat = s.split(":");
            if (osat[0].equalsIgnoreCase(sana)) {
                return osat[1];
            } else if (osat[1].equalsIgnoreCase(sana)) {
                return osat[0];
            }
        }
        
        return null;
    }
    
    public void poista(String sana) {
        Iterator<String> i = sanat.iterator();
        while (i.hasNext()) {
            String s = i.next();
            if (s.contains(sana)) {
                i.remove();
            }
        }
    }
    
    public boolean lataa() {
        try (Scanner tiedostonLukija = new Scanner(new File(tiedosto))) {
            while (tiedostonLukija.hasNextLine()) {
                String rivi = tiedostonLukija.nextLine();
                String[] osat = rivi.split(":");
                this.lisaa(osat[0], osat[1]);
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean tallenna() {
        try (PrintWriter kirjoittaja = new PrintWriter(tiedosto)) {
            for (String s : sanat) {
                kirjoittaja.println(s);
            }
        } catch (Exception e) {
           System.out.println("Virhe: " + e.getMessage());
           return false;
       }
        
       return true;
    }
}
