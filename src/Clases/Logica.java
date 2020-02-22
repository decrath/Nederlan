
package Clases;

public class Logica {
    
    public double Iva(double bruto){
        
        double iva=bruto*0.19;
        return iva;       
        
    }//calculo de el iva
    
    public double neto(double iva,double bruto){
        
        double neto=iva+bruto;
        
        return neto;
    }//calclar precio neto
    
    
}
