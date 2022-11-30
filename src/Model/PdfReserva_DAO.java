package Model;

import static Model.PdfDeclaracao_DAO.nome;
import static Model.PdfDeclaracao_DAO.url;
import static View.TelaPrincipal_GUI.cod2;
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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PdfReserva_DAO {
    
    static String url = "jdbc:mysql://localhost:3306/godear"; // enderço do BD
    static String username = "root";        //nome de um usuário de seu BD
    static String password = "";  // senha do BD
    static String id;
    static String id_res;
    static String nome;
    static String cpf;
    static String cel;
    static String sala;
    static String data_res;
    static String inicio;
    static String fim;
    
    
    public static void Relatorio() throws DocumentException {

        Document doc = null;
        OutputStream os = null;

        try {

            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);

            try {
                //cria a stream de saída
                //                           
                os = new FileOutputStream("Relatorio.pdf");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PdfReserva_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                //associa a stream de saída ao
                PdfWriter.getInstance(doc, os);
            } catch (DocumentException ex) {
                Logger.getLogger(PdfReserva_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            //abre o documento
            doc.open();
            
            //Fonte do título
            Font fonte = new Font(FontFamily.COURIER, 20, Font.BOLD); // Cria a Fonte a ser usada
            Paragraph titulo = new Paragraph("Godear - Reservas", fonte); // A fonte é aplicada ao texto após a vírgula ([...], f);
            titulo.setAlignment(Element.ALIGN_CENTER); // Centraliza o título
            titulo.setSpacingAfter(20); // Coloca um espaço entre o Título e o texto
            doc.add(titulo);
                        
            //adiciona o texto ao PDF (Parágrafo)
            //Paragraph paragrafo = new Paragraph("No dia (VAR data HOJE), o cliente (VAR Nome_Cliente) com telefone (VAR Telefone), alugou a sala (var Num Sala) para o dia (VAR Comeco_Reserva) no horário : (VAR Inicio) até (VAR Fim).");
            //doc.add(paragrafo);
            
            PdfPTable table = new PdfPTable(8);
        // Título para a tabela
        Paragraph tableHeader = new Paragraph("Dados de Reservas");
 
        PdfPCell header = new PdfPCell(tableHeader);
        PdfPCell col1 = new PdfPCell(new Paragraph("ID"));
        PdfPCell col2 = new PdfPCell(new Paragraph("NOME"));
        PdfPCell col3 = new PdfPCell(new Paragraph("CPF"));
        PdfPCell col4 = new PdfPCell(new Paragraph("CEL"));
        PdfPCell col5 = new PdfPCell(new Paragraph("SALA"));
        PdfPCell col6 = new PdfPCell(new Paragraph("DATA"));
        PdfPCell col7 = new PdfPCell(new Paragraph("INICIO"));
        PdfPCell col8 = new PdfPCell(new Paragraph("FIM"));
        // Definindo que o header vai ocupar as 3 colunas
        header.setColspan(8);
        // Definindo alinhamento do header
        header.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        // Adicionando o header à tabela
        table.addCell(header);
        table.addCell(col1);
        table.addCell(col2);
        table.addCell(col3);
        table.addCell(col4);
        table.addCell(col5);
        table.addCell(col6);
        table.addCell(col7);
        table.addCell(col8);

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
            
            Controller.conexaoBanco.carregaDriver();
        Connection con = null;   
    try {
    con = (Connection) DriverManager.getConnection(url, username, password);
    } catch (SQLException ex) {

    Logger.getLogger(PdfReserva_DAO.class.getName()).log(Level.SEVERE, null, ex);

            
                   }
            String sql = "SELECT id_res FROM reservas LIMIT 10000";
     
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
            
                while(rs.next()){
                    id = rs.getString("id_res");
                    for(int i=0;i<id.length();i++){
                        String SQL = "SELECT id_res,nome_res,cpf_res,cel_res,sala_res,data_res,inicio_res,fim_res FROM reservas WHERE id_res ="+id.charAt(i);
     
                        try {
                            PreparedStatement tst = con.prepareStatement(SQL);
                            ResultSet rr = tst.executeQuery();

                            while(rr.next()){
                                id_res = rr.getString("id_res");
                                nome = rr.getString("nome_res");
                                cpf = rr.getString("cpf_res"); 
                                cel = rr.getString("cel_res");
                                sala = rr.getString("sala_res");
                                data_res = rr.getString("data_res");
                                inicio = rr.getString("inicio_res");
                                fim = rr.getString("fim_res");
                                
 
                                table.addCell(id_res);
                                table.addCell(nome);
                                table.addCell(cpf);
                                table.addCell(cel);
                                table.addCell(sala);
                                table.addCell(data_res);
                                table.addCell(inicio);
                                table.addCell(fim);

                            }
                        } catch (Exception ex) {

                        }
                    }
                    
     
                }
            } catch (Exception ex) {
                
            }
            
        doc.add(table);    
        }finally {

            if (doc != null) {

                //fechamento do documento
                doc.close();
            }

            if (os != null) {
                try {
                    //fechamento da stream de saída
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(PdfReserva_DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    
        
        try {
            Desktop.getDesktop().open(new File("Relatorio.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(PdfReserva_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
