package file;

import java.io.*;

public class LeituraNotas {
    public static void main(String[] args) {

        String caminho = "D:\\JAVA\\Industria\\src\\file\\notas.txt";

        File arquivo =  new File(caminho);

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
            Double soma =0.0;
            Double media= 0.0;
            Integer contador=0;
            String linha;
            while((linha = br.readLine()) !=null){
                contador++;
                String[] posicoes = linha.split(",");
                Integer nota = Integer.parseInt(posicoes[1]);
                String nome = posicoes[0];

                soma += nota;
                System.out.println("Nome: "+nome+", Nota: "+nota);
            }
            media = soma/contador;
            System.out.println("Média dos alunos "+media);




        }catch (FileNotFoundException e){
            System.out.printf("Erro ao buscar o arquivo.");
        }catch (IOException e){
            System.out.println("Erro ao abrir o arquivo");
        }
    }



}