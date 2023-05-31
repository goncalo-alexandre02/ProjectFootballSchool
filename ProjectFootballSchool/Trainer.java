import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;

/**
 * Escreva uma descrição da classe Trainer aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Trainer
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private InputReader reader= new InputReader();
    private ArrayList<Trainer> trainers;
    private ArrayList<Player> players;
    private String name;
    private Date dateSchool;
    private TrainerCategory category;
    private static int numberTrainers = 0;
    private int trainerNumber;
    public int playerNumber;

        /**
         * Construtor para objetos da classe Trainer
         */
    public Trainer()
    {
        // inicializa variáveis de instância
        this.trainers = new ArrayList<>();
        players = new ArrayList<Player>();
    }
    
    public int getTrainerNumber() {
        return trainerNumber;
    }
        
    public static int getNumberTrainers() {
        return numberTrainers;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getDateSchool() {
        return dateSchool;
    }
    
    public void setDateSchool(Date dateSchool) {
        this.dateSchool = dateSchool;
    }
    
    public TrainerCategory getCategory(){
        return category;
    }
    
    public void setCategory(TrainerCategory category) {
        this.category = category;
    }

    

    public static void showMenuTrainer() {
        Trainer trainer = new Trainer();
        int option;
        Scanner scanner = new Scanner(System.in);
        String input;
    
        do {
            String search = null;
            option = Menu.menuTrainer();
            switch (option) {
                case 1:
                    trainer.makeTrainer();
                    break;
                case 2:
                    trainer.changeTrainerInfo();
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 3:
                    trainer.searchTrainer();
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 4:
                    trainer.showTrainerContainsName(search);
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 5:
                    trainer.showAllTrainers();
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 6:
                    trainer.classificationPlayer();
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scanner.nextLine(); // wait for user to press enter
                    System.out.println();
                    break;
                case 7:
                    Main.main();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 7);
        scanner.close(); // close the Scanner object when you're done using it
    }

    public void makeTrainer(){
        Scanner scanner = new Scanner(System.in);
        boolean addAnother = true;
        while (addAnother) {
            System.out.println("_____________________________________");
            System.out.println("\n************** Inserir uma nova ficha *******************\n\t\t\t\t");
            String name = reader.getName("Nome do Treinador: ");
            Date dateSchool = reader.getDateSchool("Data de entrada: ");
            TrainerCategory category = getTrainerCategory();
            System.out.println("\t\t\t******** Criado com sucesso ********\t\t\t");
            this.trainers.add(new Trainer(name, dateSchool, category));
             System.out.println("Deseja adicionar outro treinador? (s/n)");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("s")) {
                addAnother = false;
            }
        }
    }
    
    private TrainerCategory getTrainerCategory() {
        Scanner scanner = new Scanner(System.in);
        String input;
        TrainerCategory category = null;
        boolean isValidInput = false;
        do {
            System.out.println("Categoria do treinador (TP/TA/PP/GR): ");
            input = scanner.nextLine().toUpperCase();
            switch (input) {
                case "TP":
                    category = TrainerCategory.MAIN;
                    isValidInput = true;
                    break;
                case "TA":
                    category = TrainerCategory.ASSISTANT;
                    isValidInput = true;
                    break;
                case "PP":
                    category = TrainerCategory.PERSONAL;
                    isValidInput = true;
                    break;
                case "GR":
                    category = TrainerCategory.GOALKEEPER;
                    isValidInput = true;
                    break;
                case "HELP":
                    System.out.println("Opções de categoria: ");
                    for (TrainerCategory c : TrainerCategory.values()) {
                        System.out.println(c.toChar() + " - " + c.toString());
                    }
                    break;
                default:
                    System.out.println("Categoria inválida. Digite HELP para ver as opções.");
                    break;
            }
        } while (!isValidInput);
        return category;
    }   

        public Trainer(String name, Date dateSchool, TrainerCategory category) {
        this.trainerNumber = ++numberTrainers;
        this.name = name;
        this.dateSchool = dateSchool;
        this.category = category;
    }
    
    public void showAllTrainers() {
        if (this.trainers.size() == 0) {
        System.out.println("Nenhum treinador cadastrado.");
        } else {
            System.out.println("\n----Lista de jogadores----\n");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Trainer trainer : this.trainers) {
                System.out.println("Número de Treinador: " + trainer.getTrainerNumber()+ "\nNome: " + trainer.getName()  +
                        "\nData de entrada: " + sdf.format(trainer.getDateSchool()) + "\nCategoria: " + trainer.getCategory() + "\n---------------\n");
            }
        }
    }
    
    private void searchTrainer() {
         if (trainers.isEmpty()) { // It is required to have a created player
            System.out.println("Não há jogadores cadastrados.");
            return;
        }
        boolean continueChanging = true;
        while (continueChanging) {
            System.out.println("_____________________________________");
            System.out.println("\n************** Procurar Treinador *******************\n\t\t\t\t");
            int trainerNumber = reader.getNumberTrainer("Digite o número do treinador:"); //Asks to enter player number
            Trainer trainer = null;
            for (Trainer tnumber : trainers){//For each Player find player number  
                if (tnumber.getTrainerNumber() == trainerNumber) {
                    trainer = tnumber;
                    break;
                }
            }
            if (trainer == null) { //If there is no player number, or
                System.out.println("Treinador não encontrado.");
                continue;
            } else {
                System.out.println("Informações do treinador " + trainerNumber + " >");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Nome do Treinador: " + trainer.getName());
                System.out.println("Data de entrada: " + sdf.format(trainer.getDateSchool()));
                System.out.println("nCategoria: " + trainer.getCategory());  
            }
            break;
        } 
    }
    
    public void showTrainerContainsName(String search) {
         //System.out.println("hello");
        if (trainers.isEmpty()) {
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
            for (Trainer trainer : this.trainers) {
                if (trainer.getName().toLowerCase().contains(search.toLowerCase())) {
                    foundPlayer = true;
                    System.out.println("Número de Treinador: " + trainer.getTrainerNumber()+ "\nNome: " + trainer.getName()  +
                        "\nData de entrada: " + sdf.format(trainer.getDateSchool()) + "\nCategoria: " + trainer.getCategory() + "\n---------------\n");
                }
            }
        
            if (!foundPlayer) { // if no players were found, print an error message
                System.out.println("Não foram encontrados jogadores com o nome '" + search + "'.");
            }
            break;
        }
    }
    
    public void changeTrainerInfo(){
        if (trainers.isEmpty()) { // It is required to have a created player
            System.out.println("Não há jogadores cadastrados.");
            return;
        }
        boolean continueChanging = true;
        
        while (continueChanging) {
            System.out.println("_____________________________________");
            System.out.println("\n************** Alterar Jogador *******************\n\t\t\t\t");
            int trainerNumber = reader.getNumberTrainer("Digite o número do jogador:"); //Asks to enter player number
            Trainer trainer = null;
            for (Trainer tnumber : trainers){//For each Player find player number  
                if (tnumber.getTrainerNumber() == trainerNumber) {
                    trainer = tnumber;
                    break;
                }
            }
            if (trainer == null) { //If there is no player number, or
                System.out.println("Jogador não encontrado.");
                continue;
            } else {
                System.out.println("Informações do jogador " + trainerNumber + " >");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Nome do Jogador: " + trainer.getName());
                System.out.println("Data de entrada: " + sdf.format(trainer.getDateSchool()));
                System.out.println("Categoria: " + trainer.getCategory());            
                System.out.println("O que deseja alterar?");
                int option = Menu.menuAlterarTrainer();
                
                switch (option) {
                    case 1:
                        System.out.println("Alterando todas as informações do treinador " + trainerNumber + "...");
                        String newName = reader.getName("Nome do Treinador: ");
                        Date DateBirthday = reader.getDateBirthday("Data de nascimento: ");
                        Date DateSchool = reader.getDateSchool("Data de entrada: ");
                        TrainerCategory category = trainer.getCategory();
                        trainer.setName(newName);
                        trainer.setDateSchool(DateSchool);
                        trainer.setCategory(category);
                        System.out.println("Todas as informações do treinador " + trainerNumber + " foram alteradas com sucesso.");
                       boolean continueChangingPlayerInfoNewPlayer = reader.getBoolean("Deseja alterar mais alguma informação do jogador? (s/n)");
                        if (continueChangingPlayerInfoNewPlayer) {
                            break; // set playerNumber back to the stored value
                        }
                        Menu.menuJogador();
                        break;
                        
                   case 2:
                        System.out.println("Nome do Jogador atual: " +trainer.getName());
                        String name = reader.getName("Nome do Jogador novo: ");
                        //String name = reader.getName("Nome do Jogador novo: ");
                        //System.out.println("Nome do Jogador novo:");
                        trainer.setName(name);
                        System.out.println("Alterado com sucesso. Nome atual do jogador "+ trainerNumber + ": " + trainer.getName());
                        //System.out.print("A informação do jogador " + playerNumber + " é agora ");
                        //System.out.println("Nome do Jogador: " + player.getName());
                        boolean continueChangingPlayerInfoName = reader.getBoolean("Deseja alterar mais alguma informação do jogador? (s/n)");
                        if (continueChangingPlayerInfoName) {
                            break; // set playerNumber back to the stored value
                        }
                        Menu.menuJogador();
                        break;
                    case 3:
                        Date oldDateSchool = trainer.getDateSchool();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        System.out.println("Data de entrada atual: " + reader.formatDate(oldDateSchool));
                        String dateSchool = reader.getString("Data de entrada nova: ");
                        try {
                            Date newDateSchool = dateFormat.parse(dateSchool);
                            trainer.setDateSchool(newDateSchool);
                            System.out.println("Alterado com sucesso. Data de entrada atual do jogador "+ trainerNumber + ": " + reader.formatDate(newDateSchool));
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
                    case 4:
                        TrainerCategory oldCategory = trainer.getCategory();
                        TrainerCategory newCategory = null;
                        boolean validCategory = false;
                        while (!validCategory) {
                            String input = reader.getString("Nova categoria (TP/TA/PP/GR): ");
                            switch (input.toUpperCase()) {
                                case "TP":
                                    newCategory = TrainerCategory.MAIN;
                                    validCategory = true;
                                    break;
                                case "TA":
                                    newCategory = TrainerCategory.ASSISTANT;
                                    validCategory = true;
                                    break;
                                case "PP":
                                    newCategory = TrainerCategory.PERSONAL;
                                    validCategory = true;
                                    break;
                                case "GR":
                                    newCategory = TrainerCategory.GOALKEEPER;
                                    validCategory = true;
                                    break;
                                case "HELP":
                                    System.out.println("Opções de categoria: ");
                                    for (TrainerCategory c : TrainerCategory.values()) {
                                        System.out.println(c.toChar() + " - " + c.toString());
                                    }
                                    break;
                                default:
                                    System.out.println("Categoria inválida. Digite HELP para ver as opções.");
                                    break;
                            }
                        }
                        trainer.setCategory(newCategory);
                        System.out.println("Categoria alterada com sucesso.");
                        boolean continueChangingTrainerInfoCategory = reader.getBoolean("Deseja alterar mais alguma informação do treinador? (s/n)");
                        if (continueChangingTrainerInfoCategory) {
                            break; // set category back to the stored value
                        }
                        Menu.menuTrainer();
                        break;
                    case 5:
                        Menu.menuJogador();
    
                }
            }
        }
    }
    
    public void classificationPlayer() {
        int playerNumber = reader.getNumberPlayers("Digite o número do jogador:");
        Player player = null;
        for (Player pnumber : players) {
            if (pnumber.getPlayerNumber() == playerNumber) {
                player = pnumber;
                break;
            }
        }
        if (player == null) {
            System.out.println("Jogador não encontrado.");
            return;
        }
        int classificationPlayer = reader.getNumberPlayers("Digite a classificação do jogador:");
        player.setClassificationPlayer(classificationPlayer);
        System.out.println("Player " + playerNumber + " classified as " + classificationPlayer);

    }
}



