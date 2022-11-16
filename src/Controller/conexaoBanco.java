package Controller;

public class conexaoBanco {
    public static  void carregaDriver(){
       try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver carregado com sucesso!");




       } catch (Exception ex) {
            System.out.println("Driver nao pode ser carregado!");
        }

    }
}
