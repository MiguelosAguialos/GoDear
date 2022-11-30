/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.TelaPrincipal_GUI;
import static View.TelaPrincipal_GUI.cel1;
import static View.TelaPrincipal_GUI.cod2;
import static View.TelaPrincipal_GUI.cpf1;
import static View.TelaPrincipal_GUI.data1;
import static View.TelaPrincipal_GUI.fim1;
import static View.TelaPrincipal_GUI.inicio1;
import static View.TelaPrincipal_GUI.nome1;
import static View.TelaPrincipal_GUI.sala1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class Consultar_DAO {
    static String url = "jdbc:mysql://localhost/godear"; // enderço do BD
    static String username = "root";        //nome de um usuário de seu BD
    static String password = "";  // senha do BD
    
     public static void Consultar(){
         try{     //Iniciando o possivel tratamento de erros
            //Declarando a variavel código
            int codigo = Integer.valueOf(cod2.getText());
            Controller.conexaoBanco.carregaDriver(); // Carregando o driver
            try {// Tratamento de erro para a conexao
                // Declarando  a variavel de conexão con
                // e estabelendo a conexão
                Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Declarando uma string com o comando mySQL para consulta
                String sql = "SELECT nome_res,cpf_res,cel_res, sala_res, data_res, inicio_res, fim_res FROM reservas where id_res = "+cod2.getText();
                // Criando variavel que executara o comando da string sql
                Statement stm = (Statement) con.createStatement();
                try//Tratamento de erro da consulta
                { //Criando variavel que exibira os resultados
                    //Executando o comando da string sql na variavel rs
                    ResultSet rs = stm.executeQuery(sql);

                    int i=0; // Variavel utilizada para saber se ha dados cadastrados

                    while (rs.next()) {  // Criando variaveis que receberão os valores do banco de dados
                        String nome = rs.getString("nome_res");
                        String cpf = rs.getString("cpf_res");
                        String cel = rs.getString("cel_res");
                        String sala = rs.getString("sala_res");
                        String data = rs.getString("data_res");
                        String inicio = rs.getString("inicio_res");
                        String fim = rs.getString("fim_res");

                        i++;

                        //JOptionPane.showMessageDialog(null,"Nome: " + nome + "\nEmail: " +telefone + "\nTelefone: " +telefone, "Resultado",-1);
                        nome1.setText(String.valueOf(nome));
                        cpf1.setText(String.valueOf(cpf));
                        cel1.setText(cel);
                        data1.setText(data);
                        sala1.setText(String.valueOf(sala));
                        inicio1.setText(String.valueOf(inicio));
                        fim1.setText(String.valueOf(fim));

                    }

                    if(i==0){ // Verificando se ha dados cadastrados atraves da variavel i

                        JOptionPane.showMessageDialog(null,"Dado não cadastrado","Resultado",-1);

                    }

                } catch (Exception ex) { // Consulta mal sucedida
                    JOptionPane.showMessageDialog(null,"\nErro ao consultar!","ERRO",0);
                }

            } catch (SQLException ex) {
                // Conexão com servidor mal sucedida
                JOptionPane.showMessageDialog(null,"Erro ao conectar com o servidor","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Código fora do formato
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            View.TelaPrincipal_GUI.cod2.setText("");
        }
     }
     
     public static void Alterar(){
      String nom = nome1.getText(); // recebendo o nome
      String cpf = cpf1.getText(); // recebendo o email         
      String celular = cel1.getText();// recebendo o telefone
      String data = data1.getText();
      String sala = sala1.getText();
      String inicio = inicio1.getText();
      String fim = fim1.getText();

       Controller.conexaoBanco.carregaDriver();
       
      try {     
            Connection con = null;
      try {
            con = (Connection) DriverManager.getConnection(url, username, password);
      }catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal_GUI.class.getName()).log(Level.SEVERE, null, ex);
      }
            String sql = "UPDATE reservas SET nome_res='"+nom+"',cpf_res='"+cpf+"',cel_res='"+celular+"',sala_res='"+sala+"',data_res='"+data+"',inicio_res='"+inicio+"',fim_res='"+fim+"' WHERE id_res="+cod2.getText();
            
     
            try { 
                com.mysql.jdbc.PreparedStatement inserir = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

                JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                nome1.setText("");
                cpf1.setText("");
                cel1.setText("");
                data1.setText("");
                sala1.setText("");
                inicio1.setText("");
                fim1.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            cel1.setText("");
        }
     }

     public static void Excluir(){
         Controller.conexaoBanco.carregaDriver(); // Carregando o driver


       // int codigo = Integer.valueOf(cod2tela0.getText()); // Recebendo o código

                

        try {// Tratamento de erro para a conexao
            // Declarando  a variavel de conexão con
            // e estabelendo a conexão
            Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
           

            // Criando String com comando SQL para exclusão
            String sql = "DELETE FROM reservas WHERE id_res = "+cod2.getText();;

            try // Tratamento de erros para exclusão
            {// Criando Variavel para executar a ação
                com.mysql.jdbc.PreparedStatement excluir = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
                excluir.execute();// Executando a exclusão

                JOptionPane.showMessageDialog(null,"\nExclusão realizada com sucesso!!!\n","",-1);
                cod2.setText("");
                nome1.setText("");
                cpf1.setText("");
                cel1.setText("");
                data1.setText("");
                sala1.setText("");
                inicio1.setText("");
                fim1.setText("");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na exclusão!","ERRO!",0);
            }

        } catch(NumberFormatException erro){ // Codigo digitado com caracteres não numericos
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod2.setText("");

        }
     }
}
