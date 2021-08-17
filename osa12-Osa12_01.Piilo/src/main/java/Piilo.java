/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juhani
 */
public class Piilo<T> {
    
    private T piilo;
    
    //public Piilo() {}
    
    public void laitaPiiloon(T piilotettava) {
        this.piilo = piilotettava;
    }
    
    public T otaPiilosta() {
        if (this.piilo == null) {
            return null;
        }
        
        T piilotettu = this.piilo;
        this.piilo = null;
        return piilotettu;
    }
    
    public boolean onkoPiilossa() {
        if (this.piilo == null) {
            return false;
        }
        
        return true;
    }
}
