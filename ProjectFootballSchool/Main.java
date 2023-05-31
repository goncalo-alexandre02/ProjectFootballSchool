import java.util.ArrayList;
import java.util.List;

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
         Player player = new Player();
        Trainer trainer = new Trainer();
        Team team = new Team();
        int option;
        
        do {
            option = Menu.generalMenu();
            switch (option) {
                case 1:
                  // Replace with the actual file path
                    player.showMenuPlayer();
                    break;
                case 2:
                   trainer.showMenuTrainer();
                    break;
                case 3:
                   team.showMenuTeam();
                    break;
            }
        } while (option != 4);
    }
}
