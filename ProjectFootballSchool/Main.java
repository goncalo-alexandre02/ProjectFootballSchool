
/**
 * Escreva uma descrição da classe Main aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Main
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    

    public static void main() {
        // TODO code application logic here
        //Management management = new Management();
        Player player = new Player();
        int option;
        do {
            option = Menu.generalMenu();
            switch (option) {
                case 1:
                   player.showMenuPlayer();
                    break;
                case 4:
                    System.out.println("\nSaiu do menu! Até à próxima!\n");
                    break;
            }
        } while (option != 7);
        
        if(option==1){
            do {
                switch (option) {
                    case 1:
                        player.makePlayer();
                        break;
                    case 6:
                        System.out.println("\nSaiu do menu! Até à próxima!\n");
                        break;
                }
            } while (option != 7);   
        }
    }
}
