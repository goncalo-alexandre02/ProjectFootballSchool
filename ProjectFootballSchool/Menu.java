
/**
 * Escreva uma descrição da classe Menu aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

 
public class Menu
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio

    public static int generalMenu() {
        InputReader reader = new InputReader();
        FootballSchool title = new FootballSchool();
        System.out.println("\n\t****************** Escola "+ title.getName() +" *******************\n\t*\t\t\t\t\t\t*");
        System.out.println("\t****************** Menu Principal \t*\t*");
        System.out.println("\t*1. Menu do Jogador");
        System.out.println("\t*2. Menu do Treinador");
        System.out.println("\t*3. Menu da Equipe");
        System.out.println("\t*\t\t\t\t\t\t*");
        System.out.println("\t*************************************************");
        return reader.getIntegerNumber("Escolha uma das opções: ");
    }
    
    public static int menuJogador() {
        InputReader reader = new InputReader();
        System.out.println("\n\t****************** Jogador *******************\n\t*\t\t\t\t\t\t*");
        System.out.println("\t*  1 - Inserir uma nova ficha \t\t\t*");
        System.out.println("\t*  2 - Alterar jogador \t\t\t\t*");
        System.out.println("\t*  3 - Procurar jogador \t\t\t*");
        System.out.println("\t*  4 - Listar todos os jogadores cujo nome \t*");
        System.out.println("\t*  5 - Listar todos os jogadores \t\t*");
        System.out.println("\t*  6 - Sair \t\t\t\t\t*");
        System.out.println("\t*\t\t\t\t\t\t*");
        System.out.println("\t*************************************************");
        return reader.getIntegerNumber("Escolha uma das opções: ");
    }

    public static int menuTrainer() {
        InputReader reader = new InputReader();
        System.out.println("\n\t****************** Treinador *******************\n\t*\t\t\t\t\t\t*");
        System.out.println("\t*  1 - Inserir uma nova ficha \t\t\t*");
        System.out.println("\t*  2 - Alterar Treinador \t\t\t*");
        System.out.println("\t*  3 - Procurar Treinador \t\t\t*");
        System.out.println("\t*  4 - Listar todos os treinador cujo nome \t*");
        System.out.println("\t*  5 - Listar todos os treinador \t\t*");
        System.out.println("\t*  6 - Classificar Jogador \t\t\t*");
        System.out.println("\t*  7 - Sair \t\t\t\t\t*");
        System.out.println("\t*\t\t\t\t\t\t*");
        System.out.println("\t*************************************************");
        return reader.getIntegerNumber("Escolha uma das opções: ");
    }
    
    public static int menuTeam() {
        InputReader reader = new InputReader();
        System.out.println("\n\t****************** Treinador *******************\n\t*\t\t\t\t\t\t*");
        System.out.println("\t*  1 - Inserir uma Equipa \t\t\t*");
        System.out.println("\t*  2 - Alterar Equipa \t\t\t\t*");
        System.out.println("\t*  3 - Procurar Equipa \t\t\t\t*");
        System.out.println("\t*  4 - Listar todas as equipas cujo nome \t*");
        System.out.println("\t*  5 - Listar todas as equipas \t\t\t*");
        System.out.println("\t*  6 - Listar equipa por treinador\t\t\t*");
        System.out.println("\t*  7 - Classificar Equipa \t\t\t*");
        System.out.println("\t*  8 - Sair \t\t\t\t\t*");
        System.out.println("\t*\t\t\t\t\t\t*");
        System.out.println("\t*************************************************");
        return reader.getIntegerNumber("Escolha uma das opções: ");
    }
    
    public static int menuAlterarJogador(){
        InputReader reader = new InputReader();
        System.out.println("\n\t****************** Alterar Jogador *******************\n\t*\t\t\t\t\t\t*");
        System.out.println("\t*  1 - Alterar Tudo \t\t\t\t*");
        System.out.println("\t*  2 - Alterar Nome \t\t\t\t*");
        System.out.println("\t*  3 - Alterar Data de nascimento \t\t*");
        System.out.println("\t*  4 - Alterar Data de entrada \t\t\t\t*");
        System.out.println("\t*  5 - Alterar Número da camisola \t\t*");
        System.out.println("\t*  6 - Sair \t\t\t\t\t*");
        System.out.println("\t*\t\t\t\t\t\t*");
        System.out.println("\t*************************************************");
        return reader.getIntegerNumber("Escolha uma das opções: ");
    }
    public static int menuAlterarTrainer(){
        InputReader reader = new InputReader();
        System.out.println("\n\t****************** Alterar Treinador *******************\n\t*\t\t\t\t\t\t*");
        System.out.println("\t*  1 - Alterar Tudo \t\t\t\t*");
        System.out.println("\t*  2 - Alterar Nome \t\t\t\t*");
        System.out.println("\t*  3 - Alterar Data de entrada \t\t\t\t*");
        System.out.println("\t*  4 - Alterar Categoria \t\t*");
        System.out.println("\t*  5 - Sair \t\t\t\t\t*");
        System.out.println("\t*\t\t\t\t\t\t*");
        System.out.println("\t*************************************************");
        return reader.getIntegerNumber("Escolha uma das opções: ");
    }
}
