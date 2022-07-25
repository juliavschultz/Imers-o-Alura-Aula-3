import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {
    
    public List<Conteudo> extraiConteudos(String json) {
        //EXTRAIR OS DADOS QUE INTERESSAM --PARSER (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json); //CRIA UMA LISTA DE ATRIBUTOS -AQUI ESTA É VAZIA-

        List<Conteudo> conteudos = new ArrayList<>(); //FAZ UMA LISTA DOS CONTEÚDOS

        //POPULAR A LISTA DE CONTEÚDOS - QUAIS ATRIBUTOS VAMOS PEGAR?-
        for (Map<String, String> atributos : listaDeAtributos) {

           String titulo = atributos.get("title");
           String urlImagem = atributos.get("image")
                   .replaceAll("(@+)(.*).jpg$", "$1.jpg"); //RETIRA UMA PARTE DO ITEM PRA PEGAR A IMAGEM EM TAMANHO ORIGINAL
           var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo); //PREENCHE A LISTA DE CONTEUDOS
        }

        return conteudos;
   }
}
