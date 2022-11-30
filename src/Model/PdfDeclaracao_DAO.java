package Model;

import static Model.Login_DAO.url;
import View.TelaPrincipal_GUI;
import static View.TelaPrincipal_GUI.cod3;
import com.itextpdf.text.BadElementException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PdfDeclaracao_DAO {
    
    static String url = "jdbc:mysql://localhost:3306/godear"; // enderço do BD
    static String username = "root";        //nome de um usuário de seu BD
    static String password = "";  // senha do BD
    static String nome = "";
    static String cel = "";
    static String sala = "";
    static String data_res = "";
    static String inicio = "";
    static String fim = "";
    
    public static void Relatorio() throws DocumentException {
        
        
        Controller.conexaoBanco.carregaDriver();
        Connection con = null;   
    try {
    con = (Connection) DriverManager.getConnection(url, username, password);
    } catch (SQLException ex) {

    Logger.getLogger(Login_DAO.class.getName()).log(Level.SEVERE, null, ex);

            
                   }
            String sql = "SELECT nome_res,cel_res, sala_res, data_res, inicio_res, fim_res FROM reservas where id_res = "+cod3.getText();
     
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
            
                while(rs.next()){
                    nome = rs.getString("nome_res");
                    cel = rs.getString("cel_res");
                    sala = rs.getString("sala_res");
                    data_res = rs.getString("data_res");
                    inicio = rs.getString("inicio_res");
                    fim = rs.getString("fim_res");
     
                }
            } catch (Exception ex) {
                
            }
        
        
        
        Document doc = null;
        OutputStream os = null;

        try {

            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);

            try {
                //cria a stream de saída
                //                           
                os = new FileOutputStream("Declaracao.pdf");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PdfDeclaracao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                //associa a stream de saída ao
                PdfWriter.getInstance(doc, os);
            } catch (DocumentException ex) {
                Logger.getLogger(PdfDeclaracao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            //abre o documento
            doc.open();

            //Adiciona uma imagem ao PDF
            //Image img = null;
            //try {
            //    img = Image.getInstance("src\\Images\\cdz.jpg");
            //} catch (BadElementException ex) {
            //    Logger.getLogger(PdfDeclaracao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            //} catch (IOException ex) {
            //    Logger.getLogger(PdfDeclaracao_DAO.class.getName()).log(Level.SEVERE, null, ex);
            //}
            //img.setAlignment(Element.ALIGN_CENTER);
            //doc.add(img);
            
            
            //Fonte do título
            Font fonte = new Font(FontFamily.COURIER, 20, Font.BOLD); // Cria a Fonte a ser usada
            Paragraph titulo = new Paragraph("Godear - Declaração", fonte); // A fonte é aplicada ao texto após a vírgula ([...], f);
            titulo.setAlignment(Element.ALIGN_CENTER); // Centraliza o título
            titulo.setSpacingAfter(20); // Coloca um espaço entre o Título e o texto
            doc.add(titulo);
                        
            //adiciona o texto ao PDF (Parágrafo)
            Date data = new Date();
            if(cod3.getText() != null){
                Paragraph paragrafo = new Paragraph("No dia "+data+", o cliente "+nome+" com telefone "+cel+", alugou a sala "+sala+" para o dia "+data_res+" para o horário : "+inicio+" até "+fim+".");
                doc.add(paragrafo);
            }
            

        } finally {

            if (doc != null) {

                //fechamento do documento
                doc.close();
            }

            if (os != null) {
                try {
                    //fechamento da stream de saída
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(PdfDeclaracao_DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        try {
            Desktop.getDesktop().open(new File("Declaracao.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(PdfDeclaracao_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
