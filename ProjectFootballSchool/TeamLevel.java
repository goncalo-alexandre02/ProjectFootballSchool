
/**
 * Enumeração TeamLevel - escreva a descrição da enumeração aqui
 * 
 * @author (seu nome aqui)
 * @version (número da versão ou data aqui)
 */
public enum TeamLevel
{
    
    PETIZES, TRAQUINAS, BENJAMINS;
    
    public String toChar(){
        switch (this){
            case PETIZES : return "S7";
            case TRAQUINAS : return "S9";
            case BENJAMINS: return "S11";
            default: return "N/A";
        }
    }

    public String toString(){
        switch (this){
            case PETIZES: return " Sub-7 Petizes";
            case TRAQUINAS: return "Sub-9 Traquinas";
            case BENJAMINS: return "Sub-11 Benjamins";
            default: return "N/A";
        }
    }
}
