
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        
        //ENTRADA DA API DO IMDB
        //String url = "https://alura-filmes.herokuapp.com/conteudos";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        
        //ENTRADA DA API QUE SERÁ TRABALHADA - NASA
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNASA();

        var http = new clienteHttp();
        String json = http.buscaDados(url);

        //EXIBIR E MANIPULAR DADOS 
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new gerarFigurinha();

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream(); //INDEPENDENTE DO CONTEUDO -NASA/IMDB-
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.criar(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
            
        }
    }    
}