package Model;
import View.TelaLogin_GUI;
import View.TelaPrincipal_GUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login_DAO {
    static String login;
    static String senha;
    
    public static int aprovado = 0;

    static String url = "jdbc:mysql://localhost:3306/godear"; // enderço do BD
    static String username = "root";        //nome de um usuário de seu BD
    static String password = "";  // senha do BD

    public static void verificarLogin(){
        login = View.TelaLogin_GUI.login.getText();
        senha = View.TelaLogin_GUI.senha.getText();
        Controller.conexaoBanco.carregaDriver();
        Connection con = null;   
    try {
    con = (Connection) DriverManager.getConnection(url, username, password);
    } catch (SQLException ex) {

    Logger.getLogger(Login_DAO.class.getName()).log(Level.SEVERE, null, ex);

            
                   }
            String SQL = "SELECT login_user,senha_user FROM usuarios";
     
            try {
                PreparedStatement pst = con.prepareStatement(SQL);
                ResultSet rs = pst.executeQuery();
            
                while(rs.next()){
                    String log = rs.getString("login_user");
                    String pass = rs.getString("senha_user");
                    
                    if(login.equals(log) && senha.equals(pass)){
                        new TelaPrincipal_GUI().setVisible(true);
                        aprovado = 1;
                    } else{
                        JOptionPane.showMessageDialog(null,"\nErro ao fazer Login! \nPor favor verifique os dados novamente para realizar o login com sucesso.","ERRO",0);
                    }
                }
            } catch (Exception ex) {
                
            }
       
              }

        
    }
