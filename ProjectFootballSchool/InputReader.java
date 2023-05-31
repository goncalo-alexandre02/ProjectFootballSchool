import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.text.ParseException;
import java.util.Calendar;

/**
 * Escreva uma descrição da classe InputReader aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class InputReader
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
     private Scanner reader;
    public String name;
    public int playerNumber; 
    
    public InputReader() {
        reader = new Scanner(System.in);
    }
    
    public String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();

    }
    
    public String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    
    public boolean getBoolean(String message) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("s") || input.equals("sim")) {
                return true;
            } else if (input.equals("n") || input.equals("não")) {
                return false;
            } else {
                System.out.println("Por favor, digite \"s\" para Sim ou \"n\" para Não.");
            }
        }
    }


    private void showFormattedQuestion(String question) {
        if (question == null) {
            question = "";
        }
        question += "";
        System.out.print(question);
    }
    
    public int getIntegerNumber(String question) {
        showFormattedQuestion(question);

        while (!reader.hasNextInt()) {
            reader.nextLine();
            showFormattedQuestion(question);
        }
        int number = reader.nextInt();
        reader.nextLine();
        return number;
    }
    
    public int getNumberShirt(String question) {
        showFormattedQuestion(question);
        int number = -1;
        while (number < 0) {
            try {
                String input = reader.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Erro: O valor não pode estar vazio.");
                    showFormattedQuestion(question);
                } else if (!input.matches("[0-9]+")) {
                    System.out.println("Erro: O valor deve ser um número.");
                    showFormattedQuestion(question);
                } else {
                    number = Integer.parseInt(input);
                    if (number < 0) {
                        System.out.println("Erro: O valor deve ser maior ou igual a 0.");
                        showFormattedQuestion(question);
                    }
                }
            } catch (NumberFormatException e) {
                showFormattedQuestion(question);
            }
        }
        return number;
    }



    
    // public double getRealNumber(String question) {
        // showFormattedQuestion(question);

        // while (!reader.hasNextDouble()) {
            // reader.nextLine();
            // showFormattedQuestion(question);
        // }
        // double number = reader.nextDouble();
        // reader.nextLine();
        // return number;
    // }
    
   public String getName(String prompt) {
        String name;
        boolean containsNumbers;
        do {
            System.out.print(prompt);
            name = reader.nextLine();
            containsNumbers = name.matches(".*\\d+.*"); //It only accepts letters, not numbers.
            if (containsNumbers) {
                System.out.println("Nome inválido. Por favor, insira apenas letras.");
            } else if (name.trim().isEmpty()) {
                System.out.println("Nome inválido. Por favor, insira um nome não vazio.");
            }
        } while (containsNumbers || name.trim().isEmpty());
        return name;
    }


    public String getText(String question) {
        showFormattedQuestion(question);
        return reader.nextLine();
    }
    
    public Date getDateBirthday(String question) {
        showFormattedQuestion(question);
        Date date = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                String input = reader.nextLine();
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                date = format.parse(input);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                Calendar now = Calendar.getInstance();
                now.add(Calendar.YEAR, -4);
                Calendar maxDate = Calendar.getInstance();
                maxDate.add(Calendar.YEAR, -11);
                if (cal.after(now) || cal.before(maxDate)) {
                    showFormattedQuestion("Erro: Deve ter entre 4 e 11 anos de idade.\n");
                    showFormattedQuestion(question);
                } else {
                    validDate = true;
                }
            } catch (ParseException e) {
                showFormattedQuestion("Erro: A data não pode ser nula.\n");
                showFormattedQuestion(question);
            }
        }
        return date;
    }



    
    // public Date getDate(String question) {
        // showFormattedQuestion(question);
        // Date date = null;
        // boolean validDate = false;
        // while (!validDate) {
            // try {
                // String input = reader.nextLine();
                // DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                // date = format.parse(input);
                // Calendar cal = Calendar.getInstance();
                // cal.setTime(date);
                // Calendar now = Calendar.getInstance();
                // if (cal.before(now)) {
                    // validDate = true;
                // } else {
                    // showFormattedQuestion(question);
                // }
            // } catch (ParseException e) {
                // showFormattedQuestion(question);
            // }
        // }
        // return date;
    // }
    
    public Date getDate(String question) {
        showFormattedQuestion(question);
        Date date = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                String input = reader.nextLine();
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                date = format.parse(input);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                Calendar minDate = Calendar.getInstance();
                minDate.add(Calendar.YEAR, -11);
                Calendar maxDate = Calendar.getInstance();
                maxDate.add(Calendar.YEAR, -4);
                if (cal.after(minDate) && cal.before(maxDate)) {
                    validDate = true;
                } else {
                    showFormattedQuestion("Erro: Por favor, insira uma data de entrada entre " + format.format(maxDate.getTime()) + " e " + format.format(minDate.getTime()) + ".\n");
                    showFormattedQuestion(question);
                }
            } catch (ParseException e) {
                showFormattedQuestion(question);
            }
        }
        return date;
    }

    
    public Date getDateSchool(String question) {
        showFormattedQuestion(question);
        Date date = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                String input = reader.nextLine();
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                date = format.parse(input);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                Calendar now = Calendar.getInstance();
                if (cal.before(now)) {
                    // Check if the user is younger than 11 years
                    Calendar elevenYearsAgo = Calendar.getInstance();
                    elevenYearsAgo.add(Calendar.YEAR, -11);
                    if (cal.after(elevenYearsAgo)) {
                        validDate = true;
                    } else {
                        // Display an error message and prompt the user to enter a valid date
                        System.out.println("Erro: Você deve ter pelo menos 11 anos de idade.");
                        showFormattedQuestion(question);
                    }
                } else {
                    showFormattedQuestion(question);
                }
            } catch (ParseException e) {
                showFormattedQuestion(question);
            }
        }
        return date;
    }
    
    public static String formatDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }


    public int getNumberPlayers(String question){
        System.out.print( question);
        Scanner scanner = new Scanner(System.in);
        int playerNumber = scanner.nextInt();
        System.out.println("");
        return playerNumber;
    }

    
    public int getNumberTrainer(String question){
        System.out.print( question);
        Scanner scanner = new Scanner(System.in);
        int trainerNumber = scanner.nextInt();
        System.out.println("");
        return trainerNumber;
    }
    // public Date getDate(String question) {
    // showFormattedQuestion(question);
    
    // Date date = null;
    // boolean validDate = false;
    // while (!validDate) {
        // try {
            // String input = reader.nextLine();
            // DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            // date = format.parse(input);
            // Calendar cal = Calendar.getInstance();
            // cal.setTime(date);
            // Calendar now = Calendar.getInstance();
            // if (cal.before(now)) {
                // // Check if the user is younger than 4 or older than 11 years
                // Calendar elevenYearsAgo = Calendar.getInstance();
                // elevenYearsAgo.add(Calendar.YEAR, -11);
                // Calendar fourYearsAgo = Calendar.getInstance();
                // fourYearsAgo.add(Calendar.YEAR, -4);
                // if (cal.after(elevenYearsAgo)) {
                    // // Display an error message if the user is younger than 11 years old
                    // System.out.println("Erro: Você deve ter pelo menos 11 anos de idade.");
                    // showFormattedQuestion(question);
                // } else if (cal.after(fourYearsAgo)) {
                    // // Display an error message if the user is younger than 4 years old
                    // System.out.println("Erro: Você deve ter mais de 4 anos de idade.");
                    // showFormattedQuestion(question);
                // } else {
                    // validDate = true;
                // }
            // } else {
                // showFormattedQuestion(question);
            // }
        // } catch (ParseException e) {
            // showFormattedQuestion(question);
        // }
    // }
    // return date;
    // }


}
