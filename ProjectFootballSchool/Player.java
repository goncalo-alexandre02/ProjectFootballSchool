import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;
import java.util.List;

/**
 * Escreva uma descrição da classe Player aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Player
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    int option;
    private InputReader reader= new InputReader();
    private ArrayList<Player> players;
    private int numberShirt;
    private static int numberPlayers = 0;
    private int playerNumber;
    private String name;
    private Date dateBirtday;
    private Date dateSchool;
    private int numberRegister;

    /**
     * Construtor para objetos da classe Player
     */
    public Player()
    {
        // inicializa variáveis de instância
         this.players = new ArrayList<>();
    }
    
    public static void showMenuPlayer() {
        Player player = new Player();
        int option;
        Scanner scanner = new Scanner(System.in);
        String input;
    
        do {
            String search = null;
            option = Menu.menuJogador();
            switch (option) {
                case 1:
                    player.makePlayer();
                    break;
                case 2:
                    player.changePlayerInfo();
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 3:
                    player.searchPlayer();
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 4:
                    player.showPlayersContainsName(search);
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 5:
                    player.showAllPlayers();
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


    
    public void makePlayer(){
        Scanner scanner = new Scanner(System.in);
        boolean addAnother = true;
        while (addAnother) {
            System.out.println("_____________________________________");
            System.out.println("\n************** Inserir uma nova ficha *******************\n\t\t\t\t");
            String name = reader.getName("Nome do Jogador: ");
            Date dateBirtday = reader.getDateBirthday("Data de nascimento: ");
            Date dateSchool = reader.getDateSchool("Data de entrada: ");
            int numberShirt = -1;
            boolean validNumber = false;
            while (!validNumber) {
                numberShirt = reader.getNumberShirt("Número da camisola: ");
                boolean numberExists = false;
                for (Player player : players) {
                    if (player.getNumberShirt() == numberShirt) {
                        System.out.println("Erro: Este número de camisola já existe. Por favor, insira um número diferente.");
                        numberExists = true;
                        break;
                    }
                }
                if (!numberExists) {
                    validNumber = true;
                }
            }
            System.out.println("\t\t\t******** Criado com sucesso ********\t\t\t");
            this.players.add(new Player(name,dateBirtday,dateSchool,numberShirt));
        
             System.out.println("Deseja adicionar outro jogador? (s/n)");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("s")) {
                addAnother = false;
            }
        }
    }

    
    public Player(String name, Date dateBirtday, Date dateSchool, int numberShirt) {
        // Initialize instance variables here
        this.playerNumber = ++numberPlayers;
        
        if (name != null) {
            this.name = name;
        } else {
            //System.out.println("O nome não está correto.");
        }
        
        if (numberShirt > 0 && numberShirt != this.numberShirt) {
            this.numberShirt = numberShirt;
        } else {
            //System.out.println("Número da camisola terá que ser superior a 0");
        }
        
        if (dateBirtday != null) {
            this.dateBirtday = dateBirtday;
        }
        
        if (dateSchool != null) {
            this.dateSchool = dateSchool;
        }

    }

    public int getPlayerNumber() {
        return playerNumber;
    }
        
    public static int getNumberPlayers() {
        return numberPlayers;
    }
        
     public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getDateBirthday() {
        return dateBirtday;
    }
    
    public void setDateBirthday(Date dateBirtday) {
        this.dateBirtday = dateBirtday;
    }
    
    public Date getDateSchool() {
        return dateSchool;
    }
    
    public void setDateSchool(Date dateSchool) {
        this.dateSchool = dateSchool;
    }

    public int getNumberShirt() {
        return numberShirt;
    }
    
    public void setNumberShirt(int numberShirt) {
        this.numberShirt = numberShirt;
    }
    
    public int getNumberRegister() {
        return numberRegister;
    }
    
   

    public void showAllPlayers() {
        if (this.players.size() == 0) {
        System.out.println("Nenhum jogador cadastrado.");
        } else {
            System.out.println("\n----Lista de jogadores----\n");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Player player : this.players) {
                System.out.println("Número de Jogador: " + player.getPlayerNumber()+ "\nNome: " + player.getName() + "\nData de nascimento: " + sdf.format(player.getDateBirthday()) +
                        "\nData de entrada: " + sdf.format(player.getDateSchool()) + "\nNúmero da camisola: " + player.getNumberShirt() + "\n---------------\n");
            }
            System.out.print("Pressione Enter para voltar ao menu...");
        }
    }

    
    private void searchPlayer() {
         if (players.isEmpty()) { // It is required to have a created player
            System.out.println("Não há jogadores cadastrados.");
            return;
        }
        boolean continueChanging = true;
        while (continueChanging) {
            System.out.println("_____________________________________");
            System.out.println("\n************** Procurar Jogador *******************\n\t\t\t\t");
            int playerNumber = reader.getNumberPlayers("Digite o número do jogador:"); //Asks to enter player number
            Player player = null;
            for (Player pnumber : players){//For each Player find player number  
                if (pnumber.getPlayerNumber() == playerNumber) {
                    player = pnumber;
                    break;
                }
            }
            if (player == null) { //If there is no player number, or
                System.out.println("Jogador não encontrado.");
                continue;
            } else {
                System.out.println("Informações do jogador " + playerNumber + " >");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Nome do Jogador: " + player.getName());
                System.out.println("Data de nascimento: " + sdf.format(player.getDateBirthday()));
                System.out.println("Data de entrada: " + sdf.format(player.getDateSchool()));
                System.out.println("Número da camisola: " + player.getNumberShirt());  
            }
            break;
        }   
    }
    
    public void showPlayersContainsName(String search) {
         //System.out.println("hello");
        if (players.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
            return;
        }
        if (search == null || search.trim().isEmpty()) {
            Scanner scanner = new Scanner(System.in); // define a new Scanner object
            System.out.print("Digite o nome a ser pesquisado: ");
            search = scanner.nextLine(); // get the user input
        }
        boolean continueChanging = true;
        while (continueChanging) {
            System.out.println("\n---- Jogador Encontrado ----\n");
            boolean foundPlayer = false; // add a flag to keep track of whether any players have been found
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Player player : this.players) {
                if (player.getName().toLowerCase().contains(search.toLowerCase())) {
                    foundPlayer = true;
                    System.out.println("Número de Jogador: " + player.getPlayerNumber() + "\nNome: " + player.getName() + "\nData de nascimento: " + sdf.format(player.getDateBirthday()) +
                            "\nData de entrada: " + sdf.format(player.getDateSchool()) + "\nNúmero da camisola: " + player.getNumberShirt() + "\n---------------\n");
                }
            }
        
            if (!foundPlayer) { // if no players were found, print an error message
                System.out.println("Não foram encontrados jogadores com o nome '" + search + "'.");
            }
            break;
        }
    }



     public void changePlayerInfo(){
        if (players.isEmpty()) { // It is required to have a created player
            System.out.println("Não há jogadores cadastrados.");
            return;
        }
        boolean continueChanging = true;
        
        while (continueChanging) {
            System.out.println("_____________________________________");
            System.out.println("\n************** Alterar Jogador *******************\n\t\t\t\t");
            int playerNumber = reader.getNumberPlayers("Digite o número do jogador:"); //Asks to enter player number
            Player player = null;
            for (Player pnumber : players){//For each Player find player number  
                if (pnumber.getPlayerNumber() == playerNumber) {
                    player = pnumber;
                    break;
                }
            }
            if (player == null) { //If there is no player number, or
                System.out.println("Jogador não encontrado.");
                continue;
            } else {
                System.out.println("Informações do jogador " + playerNumber + " >");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Nome do Jogador: " + player.getName());
                System.out.println("Data de nascimento: " + sdf.format(player.getDateBirthday()));
                System.out.println("Data de entrada: " + sdf.format(player.getDateSchool()));
                System.out.println("Número da camisola: " + player.getNumberShirt());            
                System.out.println("O que deseja alterar?");
                int option = Menu.menuAlterarJogador();
                
                switch (option) {
                    case 1:
                        System.out.println("Alterando todas as informações do jogador " + playerNumber + "...");
                        String newName = reader.getName("Nome do Jogador: ");
                        Date DateBirthday = reader.getDateBirthday("Data de nascimento: ");
                        Date DateSchool = reader.getDateSchool("Data de entrada: ");
                        boolean newValidNumber = false;
                        int newNumberShirt = -1;
                        while (!newValidNumber) {
                            newNumberShirt = reader.getNumberShirt("Número da camisola: ");
                            boolean newNumberExists = false;
                            for (Player p : players) {
                                if (p.getNumberShirt() == newNumberShirt && p != player) {
                                    System.out.println("Erro: Este número de camisola já existe para outro jogador. Por favor, insira um número diferente.");
                                    newNumberExists = true;
                                    break;
                                }
                            }
                            if (!newNumberExists) {
                                newValidNumber = true;
                            }
                        }
                        player.setName(newName);
                        player.setDateBirthday(DateBirthday);
                        player.setDateSchool(DateSchool);
                        player.setNumberShirt(newNumberShirt);
                        System.out.println("Todas as informações do jogador " + playerNumber + " foram alteradas com sucesso.");
                       boolean continueChangingPlayerInfoNewPlayer = reader.getBoolean("Deseja alterar mais alguma informação do jogador? (s/n)");
                        if (continueChangingPlayerInfoNewPlayer) {
                            break; // set playerNumber back to the stored value
                        }
                        Menu.menuJogador();
                        break;
                        
                   case 2:
                        System.out.println("Nome do Jogador atual: " +player.getName());
                        String name = reader.getName("Nome do Jogador novo: ");
                        //String name = reader.getName("Nome do Jogador novo: ");
                        //System.out.println("Nome do Jogador novo:");
                        player.setName(name);
                        System.out.println("Alterado com sucesso. Nome atual do jogador "+ playerNumber + ": " + player.getName());
                        //System.out.print("A informação do jogador " + playerNumber + " é agora ");
                        //System.out.println("Nome do Jogador: " + player.getName());
                        boolean continueChangingPlayerInfoName = reader.getBoolean("Deseja alterar mais alguma informação do jogador? (s/n)");
                        if (continueChangingPlayerInfoName) {
                            break; // set playerNumber back to the stored value
                        }
                        Menu.menuJogador();
                        break;
                    case 3:
                        Date oldDateBirthday = player.getDateBirthday();
                        Date newDateBirthday = null;
                        while (newDateBirthday == null) {
                            //Date dateBirthday = reader.getDateBirthday("Nome do Jogador atual: " + player.getDateBirthday());
                            System.out.println("Data de nascimento atual: " + reader.formatDate(oldDateBirthday));
                            String dateBirthday = reader.getString("Data de nascimento Novo: " );
                            try {
                                newDateBirthday = new SimpleDateFormat("dd/MM/yyyy").parse(dateBirthday);
                            } catch (ParseException e) {
                                System.out.println("Data de nascimento inválida.");
                            }
                        }
                        player.setDateBirthday(newDateBirthday);
                        // System.out.println("Data de nascimento alterada com sucesso.");
                        // System.out.print("A informação do jogador " + playerNumber + " é agora ");
                        // System.out.println(" Data de nascimento: " + reader.formatDate(newDateBirthday));
                        System.out.println("Alterado com sucesso. Data de nascimento atual do jogador "+ playerNumber + ": " + reader.formatDate(newDateBirthday));
                        boolean continueChangingPlayerInfoDateBirthday = reader.getBoolean("Deseja alterar mais alguma informação do jogador? (s/n)");
                        if (continueChangingPlayerInfoDateBirthday) {
                            break; // set playerNumber back to the stored value
                        }
                        Menu.menuJogador();
                        break;
                    case 4:
                        Date oldDateSchool = player.getDateSchool();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        System.out.println("Data de nascimento atual: " + reader.formatDate(oldDateSchool));
                        String dateSchool = reader.getString("Data de entrada nova: ");
                        try {
                            Date newDateSchool = dateFormat.parse(dateSchool);
                            player.setDateSchool(newDateSchool);
                            System.out.println("Alterado com sucesso. Data de entrada atual do jogador "+ playerNumber + ": " + reader.formatDate(newDateSchool));
                            //System.out.println("Data de entrada alterada com sucesso.");
                        } catch (ParseException e) {
                            System.out.println("Data de entrada inválida.");
                        }
                        boolean continueChangingPlayerInfoDateSchool = reader.getBoolean("Deseja alterar mais alguma informação do jogador? (s/n) ");
                        if (continueChangingPlayerInfoDateSchool) {
                            break; // set playerNumber back to the stored value
                        }
                        Menu.menuJogador();
                        break;
                    case 5:
                        int oldNumberShirt = player.getNumberShirt();
                        boolean validNumber = false;
                        int numberShirt = -1;
                        while (!validNumber) {
                            //numberShirt = reader.getNumberShirt("Número da camisola (atual: " + oldNumberShirt + "): ");
                            System.out.println("Número da camisola atual: " + player.getNumberShirt());
                            String dateBirthday = reader.getString("Número da camisola Novo: " );
                            boolean numberExists = false;
                            for (Player p : players) {
                                if (p.getNumberShirt() == numberShirt && p != player) {
                                    System.out.println(
                                            "Erro: Este número de camisola já existe para outro jogador. Por favor, insira um número diferente.");
                                    numberExists = true;
                                    break;
                                }
                            }
                            if (!numberExists) {
                                validNumber = true;
                            }
                        }
                        player.setNumberShirt(numberShirt);
                        System.out.println("Número da camisola alterado com sucesso.");
                        boolean continueChangingPlayerInfoNumberShirt = reader.getBoolean("Deseja alterar mais alguma informação do jogador? (s/n)");
                        if (continueChangingPlayerInfoNumberShirt) {
                            break; // set playerNumber back to the stored value
                        }
                        Menu.menuJogador();
                        break;
                    case 6:
                        Menu.menuJogador();
    
                }
            }
        }
    }
}


    

    




    

