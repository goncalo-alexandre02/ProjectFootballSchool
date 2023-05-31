
/**
 * Escreva uma descrição da classe TrainerCategory aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public enum TrainerCategory
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    
    MAIN, ASSISTANT, PERSONAL, GOALKEEPER;
    
    public String toChar(){
        switch (this){
            case MAIN : return "TP";
            case ASSISTANT : return "TA";
            case PERSONAL: return "TP";
            case GOALKEEPER: return "GR";
            default: return "N/A";
        }
    }

    public String toString(){
        switch (this){
            case MAIN: return "Treinador Principal";
            case ASSISTANT: return "Treinador Assistente";
            case PERSONAL: return "Preparador Físico";
            case GOALKEEPER: return "Treinador de Guarda-Redes";
            default: return "N/A";
        }
    }
    
}
