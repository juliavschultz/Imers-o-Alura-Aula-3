import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNASA implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json) {

        //EXTRAIR OS DADOS QUE INTERESSAM --PARSER
        var parser = new JsonParser(); 
        List<Map<String, String>> listaDeAtributos = parser.parse(json); //CRIA UMA LISTA DE ATRIBUTOS -AQUI ESTA É VAZIA-

        List<Conteudo> conteudos = new ArrayList<>(); //FAZ UMA LISTA DOS CONTEÚDOS

        //POPULAR A LISTA DE CONTEÚDOS - QUAIS ATRIBUTOS VAMOS PEGAR?-
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title"); //NOME DO ATRIBUTO NA API - TITLE
            String urlImagem = atributos.get("url"); //NOME DO ATRIBUTO NA API - URL

            var conteudo = new Conteudo(titulo, urlImagem); //CADA ITEM/CONTEUDO CONTA COM TITULO E URL

            conteudos.add(conteudo); //AQUI CADA CONTEÚDO SERÁ ADICIONADO A LISTA CONTEUDOS
        }

        return conteudos;
    }

}