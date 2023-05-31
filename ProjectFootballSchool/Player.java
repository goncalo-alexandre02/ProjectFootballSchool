import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

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
    public int playerNumber;
    private String name;
    private Date dateBirtday;
    private Date dateSchool;
    private int numberRegister;
    public int classificationPlayer = 0;
    String filePath = "/Users/goncaloalexandre/Documents/POO/ProjectFootballSchool/doc/baseData.txt";

    
    /**
     * Construtor para objetos da classe Player
     */
    public Player()
    {
        // inicializa variáveis de instância
        this.players = new ArrayList<>();
        String filePath = "/Users/goncaloalexandre/Documents/POO/ProjectFootballSchool/doc/baseData.txt";

    }
    
    public boolean showMenuPlayer() {
        int option;
        Scanner scanner = new Scanner(System.in);
        String input;
        //String filePath;
        //readPlayerData("/Users/goncaloalexandre/Documents/POO/ProjectFootballSchool/doc/baseData.txt");
        boolean continueRunning = true;
        do {
            String search = null;
            option = Menu.menuJogador();
            switch (option) {
                case 1:
                   // Create a new instance of Player
                    makePlayer(filePath); // Populate the new player's information
                    //writePlayerData(players, "/Users/goncaloalexandre/Documents/POO/ProjectFootballSchool/doc/baseData.txt");
                    break;
                case 2:
                    changePlayerInfo(filePath);
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 3:
                    searchPlayer(filePath);
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 4:
                   
                    showPlayersContainsName(search, "/Users/goncaloalexandre/Documents/POO/ProjectFootballSchool/doc/baseData.txt");
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 5:
                    showAllPlayers(filePath);
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 6:
                   //Player.writePlayerData(players, filePath);
               
                return true;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 7);
    
        scanner.close();
        // close the Scanner object when you're done using it
         return false;
    }
   
    

    public int getPlayerNumber() {
        return this.playerNumber;
    }
    
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
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
    
    public int getClassificationPlayer() {
        return classificationPlayer;
    }

    public void setClassificationPlayer(int classificationPlayer) {
        this.classificationPlayer = classificationPlayer;
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
    
    
    public void makePlayer(String filePath) {
    Scanner scanner = new Scanner(System.in);
    boolean addAnother = true;
    int nextPlayerNumber = 0; // Initialize with 0
    //ArrayList<Player> players = readPlayerData(filePath);
    // Retrieve the last player number from the existing players in the database
    if (!players.isEmpty()) {
        nextPlayerNumber = players.get(players.size() - 1).getNumberShirt();
    }
    
    while (addAnother) {
        System.out.println("_____________________________________");
        System.out.println("\n************** Inserir uma nova ficha *******************\n\t\t\t\t");
        String name = reader.getName("Nome do Jogador: ");
        Date dateBirthday = reader.getDateBirthday("Data de nascimento: ");
        System.out.print("Data de entrada (dd/MM/yyyy): ");
        String dateSchoolString = scanner.nextLine();
        
        try {
            Date dateSchool = new SimpleDateFormat("dd/MM/yyyy").parse(dateSchoolString);
            
            int numberShirt = -1;
            boolean validNumber = false;
            
            while (!validNumber) {
                numberShirt = reader.getNumberShirt("Número da camisola: ");
                
                // Check if the player number already exists
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
                    
                    // Update the nextPlayerNumber if the current number is greater
                    if (numberShirt > nextPlayerNumber) {
                        nextPlayerNumber = numberShirt;
                    }
                }
            }
            
            System.out.println("\t\t\t******** Criado com sucesso ********\t\t\t");
            this.players.add(new Player(name, dateBirthday, dateSchool, numberShirt));
            
            System.out.println("Deseja adicionar outro jogador? (s/n)");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("s")) {
                addAnother = false;
            }
        } catch (ParseException e) {
            System.out.println("Erro ao converter data. Certifique-se de usar o formato dd/MM/yyyy.");
        }
    }
    
    writePlayerData(players, filePath);
}




    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    
    public void showAllPlayers(String filePath) {
        ArrayList<Player> players = readPlayerData(filePath);
        if (players.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
        } else {
            System.out.println("\n----Lista de jogadores----\n");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Player player : players) {
                System.out.println("Número de Jogador: " + player.getPlayerNumber() + "\nNome: " + player.getName()
                        + "\nData de nascimento: " + sdf.format(player.getDateBirthday()) + "\nData de entrada: "
                        + sdf.format(player.getDateSchool()) + "\nNúmero da camisola: " + player.getNumberShirt()
                        + "\nClassificação: " + player.getClassificationPlayer() + "\n---------------\n");
            }
        }
    }





    
    public void searchPlayer(String filePath) {
        ArrayList<Player> players = readPlayerData(filePath);
    
        if (players.isEmpty()) {
            System.out.println("Não há jogadores cadastrados.");
            return;
        }
    
        boolean continueSearching = true;
        while (continueSearching) {
            System.out.println("_____________________________________");
            System.out.println("\n************** Procurar Jogador *******************\n\t\t\t\t");
            int playerNumber = reader.getNumberPlayers("Digite o número do jogador:");
            Player player = null;
            for (Player p : players) {
                if (p.getPlayerNumber() == playerNumber) {
                    player = p;
                    break;
                }
            }
            if (player == null) {
                System.out.println("Jogador não encontrado.");
            } else {
                System.out.println("Informações do jogador " + playerNumber + " >");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Nome do Jogador: " + player.getName());
                System.out.println("Data de nascimento: " + sdf.format(player.getDateBirthday()));
                System.out.println("Data de entrada: " + sdf.format(player.getDateSchool()));
                System.out.println("Número da camisola: " + player.getNumberShirt());
            }
            
            continueSearching = false;
        }
    }

    
    public void showPlayersContainsName(String search, String filePath) {
        ArrayList<Player> players = readPlayerData(filePath);
    
        if (players.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
            return;
        }
    
        if (search == null || search.trim().isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o nome a ser pesquisado: ");
            search = scanner.nextLine();
        }
    
        boolean continueShowing = true;
        while (continueShowing) {
            System.out.println("\n---- Jogador Encontrado ----\n");
            boolean foundPlayer = false;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Player player : players) {
                if (player.getName().toLowerCase().contains(search.toLowerCase())) {
                    foundPlayer = true;
                    System.out.println("Número de Jogador: " + player.getPlayerNumber()
                           + "\nNome: " + player.getName()
                        + "\nData de nascimento: " + sdf.format(player.getDateBirthday())
                        + "\nData de entrada: " + sdf.format(player.getDateSchool())
                        + "\nNúmero da camisola: " + player.getNumberShirt()
                        + "\n---------------\n");
                }
            }
    
            if (!foundPlayer) {
                System.out.println("Não foram encontrados jogadores com o nome '" + search + "'.");
            }
    
            continueShowing = false;
        }
    }



    public void changePlayerInfo(String filePath){
        ArrayList<Player> players = readPlayerData(filePath);
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
                System.out.println("Informações do jogador " + player.getPlayerNumber() + " >");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Nome do Jogador: " + player.getName());
                System.out.println("Data de nascimento: " + sdf.format(player.getDateBirthday()));
                System.out.println("Data de entrada: " + sdf.format(player.getDateSchool()));
                System.out.println("Número da camisola: " + player.getNumberShirt());            
                System.out.println("O que deseja alterar?");
                int option = Menu.menuAlterarJogador();
                
                switch (option) {
                    case 1:
                        System.out.println("Alterando todas as informações do jogador " + player.getPlayerNumber() + "...");
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
                        setName(newName);
                        setDateBirthday(DateBirthday);
                        setDateSchool(DateSchool);
                        setNumberShirt(newNumberShirt);
                        System.out.println("Todas as informações do jogador " + player.getPlayerNumber() + " foram alteradas com sucesso.");
                       boolean continueChangingPlayerInfoNewPlayer = reader.getBoolean("Deseja alterar mais alguma informação do jogador? (s/n)");
                        if (continueChangingPlayerInfoNewPlayer) {
                            break; // set playerNumber back to the stored value
                        }
                        Menu.menuJogador();
                         updatePlayerDataInFile(players, filePath);
                        break;
                        
                   case 2:
                        System.out.println("Nome do Jogador atual: " +player.getName());
                        String name = reader.getName("Nome do Jogador novo: ");
                        //String name = reader.getName("Nome do Jogador novo: ");
                        //System.out.println("Nome do Jogador novo:");
                        setName(name);
                        System.out.println("Alterado com sucesso. Nome atual do jogador "+ player.getPlayerNumber() + ": " + player.getName());
                        //System.out.print("A informação do jogador " + playerNumber + " é agora ");
                        //System.out.println("Nome do Jogador: " + player.getName());
                        boolean continueChangingPlayerInfoName = reader.getBoolean("Deseja alterar mais alguma informação do jogador? (s/n)");
                        if (continueChangingPlayerInfoName) {
                            break; // set playerNumber back to the stored value
                        }
                        updatePlayerDataInFile(players, filePath);
                        Menu.menuJogador();
                        break;
                    case 3:
                        Date oldDateBirthday = getDateBirthday();
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
                        setDateBirthday(newDateBirthday);
                        // System.out.println("Data de nascimento alterada com sucesso.");
                        // System.out.print("A informação do jogador " + playerNumber + " é agora ");
                        // System.out.println(" Data de nascimento: " + reader.formatDate(newDateBirthday));
                        System.out.println("Alterado com sucesso. Data de nascimento atual do jogador "+ player.getPlayerNumber() + ": " + reader.formatDate(newDateBirthday));
                        boolean continueChangingPlayerInfoDateBirthday = reader.getBoolean("Deseja alterar mais alguma informação do jogador? (s/n)");
                        if (continueChangingPlayerInfoDateBirthday) {
                            break; // set playerNumber back to the stored value
                        }
                        updatePlayerDataInFile(players, filePath);
                        Menu.menuJogador();
                        break;
                    case 4:
                        Date oldDateSchool = getDateSchool();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        System.out.println("Data de entrada atual: " + reader.formatDate(oldDateSchool));
                        String dateSchool = reader.getString("Data de entrada nova: ");
                        try {
                            Date newDateSchool = dateFormat.parse(dateSchool);
                            setDateSchool(newDateSchool);
                            System.out.println("Alterado com sucesso. Data de entrada atual do jogador "+ playerNumber + ": " + reader.formatDate(newDateSchool));
                            //System.out.println("Data de entrada alterada com sucesso.");
                        } catch (ParseException e) {
                            System.out.println("Data de entrada inválida.");
                        }
                        boolean continueChangingPlayerInfoDateSchool = reader.getBoolean("Deseja alterar mais alguma informação do jogador? (s/n) ");
                        if (continueChangingPlayerInfoDateSchool) {
                            break; // set playerNumber back to the stored value
                        }
                        updatePlayerDataInFile(players, filePath);
                        Menu.menuJogador();
                        break;
                    case 5:
                        int oldNumberShirt = getNumberShirt();
                        boolean validNumber = false;
                        int numberShirt = -1;
                        while (!validNumber) {
                            //numberShirt = reader.getNumberShirt("Número da camisola (atual: " + oldNumberShirt + "): ");
                            System.out.println("Número da camisola atual: " + getNumberShirt());
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
                        updatePlayerDataInFile(players, filePath);
                        Menu.menuJogador();
                        break;
                    case 6:
                        Menu.menuJogador();
    
                }
            }
        }
        
    }
    
    private void updatePlayerDataInFile(List<Player> players, String filePath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        for (Player player : players) {
            writer.write("Número do jogador: " + player.getPlayerNumber());
            writer.newLine();
            writer.write("Nome do jogador: " + player.getName());
            writer.newLine();
            writer.write("Data de nascimento: " + player.getDateBirthday());
            writer.newLine();
            writer.write("Data de entrada: " + player.getDateSchool());
            writer.newLine();
            writer.write("Número da camisola: " + player.getNumberShirt());
            writer.newLine();
            writer.newLine();
        }
        System.out.println("Dados atualizados no arquivo com sucesso.");
    } catch (IOException e) {
        System.out.println("Erro ao atualizar os dados no arquivo: " + e.getMessage());
    }
}
    
    public void writePlayerData(ArrayList<Player> players, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            for (Player player : players) {
                writer.write("Número do jogador: " + player.getPlayerNumber() + "\n");
                writer.write("Nome do jogador: " + player.getName() + "\n");
                writer.write("Data de nascimento: " + formatDate(player.getDateBirthday()) + "\n");
                writer.write("Data de entrada: " + formatDate(player.getDateSchool()) + "\n");
                writer.write("Número da camisola: " + player.getNumberShirt() + "\n");
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever dados do jogador: " + e.getMessage());
        }
    }



    public ArrayList<Player> readPlayerData(String filePath) {
        ArrayList<Player> players = new ArrayList<Player>();
        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            int playerNumber = 0;
            String name = "";
            Date dateBirthday = null;
            Date dateSchool = null;
            int numberShirt = 0;
    
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Número do jogador:")) {
                    String playerNumberValue = line.substring(line.indexOf(":") + 2);
                    playerNumber = Integer.parseInt(playerNumberValue.trim());
                } else if (line.startsWith("Nome do jogador:")) {
                    name = line.substring(line.indexOf(":") + 2);
    
                    String dateBirthdayLine = scanner.nextLine();
                    String dateBirthdayString = dateBirthdayLine.substring(dateBirthdayLine.indexOf(":") + 2);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dateBirthday = dateFormat.parse(dateBirthdayString.trim());
    
                    String dateSchoolLine = scanner.nextLine();
                    String dateSchoolString = dateSchoolLine.substring(dateSchoolLine.indexOf(":") + 2);
                    dateSchool = dateFormat.parse(dateSchoolString.trim());
    
                    String numberShirtLine = scanner.nextLine();
                    if (numberShirtLine.startsWith("Número da camisola:")) {
                        String numberShirtValue = numberShirtLine.substring(numberShirtLine.indexOf(":") + 2);
                        numberShirt = Integer.parseInt(numberShirtValue.trim());
                    }
    
                    Player player = new Player(name, dateBirthday, dateSchool, numberShirt);
                    player.setPlayerNumber(playerNumber);
    
                    players.add(player);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("O arquivo de dados dos jogadores não foi encontrado: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Ocorreu um erro ao analisar as datas dos jogadores: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ocorreu um erro ao ler os números das camisolas dos jogadores: " + e.getMessage());
        }
        return players;
    }

   
}






    

    




    

