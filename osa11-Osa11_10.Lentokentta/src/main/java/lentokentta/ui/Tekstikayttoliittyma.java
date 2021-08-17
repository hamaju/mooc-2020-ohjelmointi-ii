/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lentokentta.ui;

import java.util.Scanner;
import lentokentta.domain.Lento;
import lentokentta.domain.Lentokone;
import lentokentta.logiikka.Lentohallinta;

/**
 *
 * @author juhani
 */
public class Tekstikayttoliittyma {
 
    private Lentohallinta lentohallinta;
    private Scanner lukija;
    
    public Tekstikayttoliittyma(Lentohallinta lentohallinta, Scanner lukija) {
        this.lentohallinta = lentohallinta;
        this.lukija = lukija;
    }
    
    public void kaynnista() {
        kaynnistaLentokentanHallinta();
        System.out.println("");
        kaynnistaLentoPalvelu();
        System.out.println("");
    }

    private void kaynnistaLentokentanHallinta() {   
        System.out.println("Lentokentän hallinta");
        System.out.println("--------------------");
        System.out.println("");
        
        while (true) {
            System.out.println("Valitse toiminto:");
            System.out.println("[1] Lisää lentokone");
            System.out.println("[2] Lisää lento");
            System.out.println("[x] Poistu hallintamoodista");
            
            System.out.print("> ");
            String komento = lukija.nextLine();
            
            if (komento.equals("1")) {
                lisaaLentokone();
            } else if (komento.equals("2")) {
                lisaaLento();
            } else if (komento.equals("x")) {
                break;
            }
        }
    }

    private void kaynnistaLentoPalvelu() {      
        System.out.println("Lentopalvelu");
        System.out.println("------------");
        System.out.println("");
        
        while (true) {
            System.out.println("Valitse toiminto:");
            System.out.println("[1] Tulosta lentokoneet");
            System.out.println("[2] Tulosta lennot");
            System.out.println("[3] Tulosta lentokoneen tiedot");
            System.out.println("[x] Lopeta");
            
            System.out.print("> ");
            String komento = lukija.nextLine();
            
            if (komento.equals("1")) {
                tulostaLentokoneet();
            } else if (komento.equals("2")) {
                tulostaLennot();
            } else if (komento.equals("3")) {
                tulostaLentokone();
            } else if (komento.equals("x")) {
                break;
            }
        }
    }

    private void lisaaLentokone() {
        System.out.print("Anna lentokoneen tunnus: ");
        String tunnus = lukija.nextLine();
        System.out.print("Anna lentokoneen kapasiteetti: ");
        int kapasiteetti = Integer.parseInt(lukija.nextLine());
        
        this.lentohallinta.lisaaLentokone(tunnus, kapasiteetti);
    }

    private void lisaaLento() {
        System.out.print("Anna lentokoneen tunnus: ");
        String tunnus = lukija.nextLine();
        Lentokone lentokone = lentohallinta.haeLentokone(tunnus);
        System.out.print("Anna lähtöpaikan tunnus: ");
        String lahtotunnus = lukija.nextLine();
        System.out.print("Anna kohdepaikan tunnus: ");
        String kohdetunnus = lukija.nextLine();
        
        this.lentohallinta.lisaaLento(lentokone, lahtotunnus, kohdetunnus);
    }
    
    private void tulostaLentokoneet() {
        for (Lentokone lentokone : lentohallinta.getLentokoneet()) {
            System.out.println(lentokone);
            System.out.println("");
        }
    }
    
    private void tulostaLennot() {
        for (Lento lento : lentohallinta.getLennot()) {
            System.out.println(lento);
            System.out.println("");
        }
    }
    
    private void tulostaLentokone() {
        System.out.print("Mikä kone: ");
        String lentokone = lukija.nextLine();
        System.out.println(lentohallinta.haeLentokone(lentokone));
        System.out.println("");
    }
}
