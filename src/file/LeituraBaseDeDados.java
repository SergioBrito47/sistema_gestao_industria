package file;

import java.io.*;

public class LeituraBaseDeDados {
    public static void main(String[] args) {

        String caminho = "D:\\JAVA\\Industria\\src\\file\\base-de-dados - base-de-dados.csv";

        File arquivo =  new File(caminho);

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
            Double soma =0.0;
            Double media= 0.0;
            Integer contador=0;
            String linha;
            while((linha = br.readLine()) !=null){
                contador++;
                String[] posicoes = linha.split(",");
                Integer mes = Integer.parseInt(posicoes[0]);
                Integer ano = Integer.parseInt(posicoes[1]);
                String nome = posicoes[2];
                Integer qtditens = Integer.parseInt(posicoes[3]);
                Integer Valortotal = Integer.parseInt(posicoes[4]);

                soma += Valortotal;
            }
            media = soma/contador;
            //System.out.println("Valor Total das Vendas: "+soma);




        }catch (FileNotFoundException e){
            System.out.printf("Erro ao buscar o arquivo.");
        }catch (IOException e){
            System.out.println("Erro ao abrir o arquivo");
        }
    }



}