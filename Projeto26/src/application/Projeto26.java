package application;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/*TRABALHANDO COM ARQUIVOS*/
public class Projeto26 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String path = "C:\\temp\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
            escreveArquivo();
            System.out.println("Escrever arquivos funcionou!");

            lerDiretorios(input);
            System.out.println("Ler diretórios funcionou!");


        lerCaminhoArquivo(input);
        System.out.println("Ler caminhos de arquivo funcionou!");
        input.close();
        }
    private static void escreveArquivo(){

        System.out.println("**************Escrita em arquivos**************** ");
        String [] lines = new String [] {"Good morning", "Good afternoon", "Good evening", "Good night"};

        String path = "C:\\temp\\out.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
        catch (IOException e) {
            //System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }


    }
    private static void lerDiretorios(Scanner input){

        System.out.println("************* MANIPULANDO DIRETORIO *************** ");
        System.out.print("Informe o caminho do diretório: ");
        String caminho = input.nextLine();

        File path = new File(caminho);

        File[] diretorios = path.listFiles(File::isDirectory);
        System.out.println("Diretórios");
        for (File arquivo : diretorios) {
            System.out.println(arquivo.getName());
        }

        File[] files = path.listFiles(File::isFile);
        System.out.println("Arquivos");
        for (File arquivo : files) {
            System.out.println(arquivo.getName());
        }
        boolean success = new File(caminho + "\\novapastateste").mkdirs();
        System.out.println("SubDiretório criado com sucesso!");

    }
    private static void lerCaminhoArquivo(Scanner input){

        System.out.println("************* LEITURA DE CAMINHOS DE ARQUIVOS *************** ");
        System.out.print("Informe o caminho do diretório: ");
        String caminho = input.nextLine();
        File path = new File(caminho);

        System.out.println("getPath traz isso aqui ---> " + path.getPath());
        System.out.println("getParent traz isso aqui ---> " + path.getParent());
        System.out.println("getName traz isso aqui ---> " + path.getName());



    }
    }

