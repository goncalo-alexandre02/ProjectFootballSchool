import java.util.ArrayList;
import java.util.Scanner;

/**
 * Escreva uma descrição da classe Team aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Team
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String teamName;
    private Trainer trainer;
    private ArrayList<Player> players;
    private ArrayList<Trainer> trainers;
    private ArrayList<Team> teams;
     private TeamLevel level;
     
    /**
     * Construtor para objetos da classe Team
     */
    public Team(String teamName, ArrayList<Trainer> trainer, ArrayList<Player> players)
    {
        // inicializa variáveis de instância
        this.teams = new ArrayList();
        players = new ArrayList<>();
        trainers = new ArrayList<>();
    }
    
    public Team(){
        this.teams = new ArrayList();
        players = new ArrayList<>();
        trainers = new ArrayList<>();
    }
    
    
    public static void showMenuTeam() {
        Team team = new Team();
        int option;
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Trainer> trainers = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        do {
            String search = null;
            option = Menu.menuTeam();
            
            switch (option) {
                case 1:
                 team.makeTeam(trainers, players);               
                //team.makePlayer();
                break;
                case 2:
                    //player.changePlayerInfo();
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 3:
                    //player.searchPlayer();
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 4:
                    //player.showPlayersContainsName(search);
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 5:
                    //player.showAllPlayers();
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 6:
                    Main.main();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 7);
    
        scanner.close(); // close the Scanner object when you're done using it
    }

    public void makeTeam(ArrayList<Trainer> trainers, ArrayList<Player> players) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("_____________________________________");
        System.out.println("\n************** Criar uma nova equipe *******************\n");

        System.out.print("Nome da equipe: ");
        String teamName = scanner.nextLine();
        
        TeamLevel level = getTeamLevel();
    
        System.out.println("Treinadores disponíveis:");
        for (int i = 0; i < trainers.size(); i++) {
            System.out.println((i + 1) + ". " + trainers.get(i).getName());
        }
        int trainerNumber;
        do {
            System.out.print("Selecione o número do treinador: ");
            trainerNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (trainerNumber < 1 || trainerNumber > trainers.size()) {
                System.out.println("Erro: Número de treinador inválido. Tente novamente.");
            } else {
                trainer = trainers.get(trainerNumber - 1);
            }
        } while (trainer == null);
        players = new ArrayList<>();
        boolean addPlayer = true;
        while (addPlayer) {
            System.out.println("\nJogadores disponíveis:");
            for (int i = 0; i < players.size(); i++) {
                System.out.println((i + 1) + ". " + players.get(i).getName());
            }
            int playerNumber;
            do {
                System.out.print("Selecione o número do jogador (-1 para sair): ");
                playerNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (playerNumber == -1) {
                    addPlayer = false;
                    break;
                } else if (playerNumber < 1 || playerNumber > players.size()) {
                    System.out.println("Erro: Número de jogador inválido. Tente novamente.");
                } else {
                    Player selectedPlayer = players.get(playerNumber - 1);
                    this.players.add(selectedPlayer);
                    System.out.println("Jogador selecionado: " + selectedPlayer.getName());
                }
            } while (addPlayer);
        }
        this.teamName = teamName;
        System.out.println("Equipe criada com sucesso!");
        scanner.close();
    }
    
    private TeamLevel getTeamLevel(){
        Scanner scanner = new Scanner(System.in);
        String input;
        TeamLevel level = null;
        boolean isValidInput = false;
        do {
            System.out.print("Escalões da Equipa (S7/S9/S11): ");
            input = scanner.nextLine().toUpperCase();
            switch (input) {
                case "S7":
                    level = TeamLevel.PETIZES;
                    isValidInput = true;
                    break;
                case "S9":
                    level = TeamLevel.TRAQUINAS;
                    isValidInput = true;
                    break;
                case "S11":
                     level = TeamLevel.BENJAMINS;
                    isValidInput = true;
                    break;
                case "HELP":
                    System.out.println("Opções de escalões: ");
                    for (TeamLevel c : TeamLevel.values()) {
                        System.out.println(c.toChar() + " - " + c.toString());
                    }
                    break;
                default:
                    System.out.println("Escalão inválido. Digite HELP para ver as opções.");
                    break;
            }
        } while (!isValidInput);
        return level;
    }     
    
}
