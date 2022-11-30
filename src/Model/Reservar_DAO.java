package Model;

import View.TelaPrincipal_GUI;
import static View.TelaPrincipal_GUI.celReserva;
import static View.TelaPrincipal_GUI.cpfReserva;
import static View.TelaPrincipal_GUI.fimReserva;
import static View.TelaPrincipal_GUI.nomeReserva;
import static View.TelaPrincipal_GUI.salaReserva;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static View.TelaPrincipal_GUI.inicioReserva;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alunos
 */
public class Reservar_DAO {
    static String url = "jdbc:mysql://localhost/godear"; // enderço do BD
    static String username = "root";        //nome de um usuário de seu BD
    static String password = "";  // senha do BD
    static String nom;
    static String cpf;
    static String cel;
    static String sala;
    static String data;
    static String inicio;
    static String fim;
    
    public static void Reservar(){
        nom = nomeReserva.getText();
        cpf = cpfReserva.getText();
        cel = celReserva.getText();
        sala = salaReserva.getSelectedItem().toString();
        data = View.TelaPrincipal_GUI.data.getText();
        inicio = inicioReserva.getText();
        fim = fimReserva.getText();
        
        Controller.conexaoBanco.carregaDriver();
        Connection con = null;    
    try {
        
        con = (Connection) DriverManager.getConnection(url, username, password);
    } catch (SQLException ex) {

    Logger.getLogger(TelaPrincipal_GUI.class.getName()).log(Level.SEVERE, null, ex);

            
                   }

        
        String sql = "INSERT INTO reservas(nome_res,cpf_res,cel_res,sala_res,data_res,inicio_res,fim_res) VALUES('"+nom+"','"+cpf+"','"+cel+"','"+sala+"','"+data+"','"+inicio+"','"+fim+"')";
        
        try { // Tratamento de Erros para inserção

                // Criando varialvel que executara a inserção
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

                JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                nomeReserva.setText("");
                cpfReserva.setText("");
                celReserva.setText("");
                View.TelaPrincipal_GUI.data.setText("");
                inicioReserva.setText("");
                fimReserva.setText("");
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }
    }
}
