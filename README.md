# paginacao-nmaisum-spring-boot

Link do tutorial  
https://www.youtube.com/watch?v=sqbqoR-lMf8  

Github do projeto  
https://github.com/devsuperior/aulao_nmais1  

Como retornar paginado o produto com suas categorias em uma associacao muitos para muitos?  
![](/img/uml_produto_categoria.png)  

DTO - Data Transfer Object  
É uma boa pratica usar DTO para que fique isolado da camada de transacao dos dados, as entidades ficam sendo monitoradas pelo jpa  
enquanto o jpa precisa de informacoes as transacoes ficam abertas, para solucionar isso, é importante passar os dados sendo trabalhados  
para a camada de dto, assim as transacoes se fecham e os dados podem ser utilizados livres da camada transacional.  

![](/img/exemploDTO1.png)  


Se fizer um JOIN FETCH não funciona a paginacao  
Caused by: org.hibernate.QueryException: query specified join fetching, but the owner of the fetched association was not present in the select list [FromElement{explicit,not a collection join,fetch join,fetch non-lazy properties,classAlias=null,role=com.example.paginacaonmaisumspringboot.entities.Product.categories,tableName=tb_category,tableAlias=category2_,origin=tb_product product0_,columns={product0_.id,className=com.example.paginacaonmaisumspringboot.entities.Category}}]
  
consulta paginada em sql tem uma clausula limit no final  
O limit nao entra na semantica de que um produto tem n categorias, quando e limitado ele retorna apenas a quantidade de linhas que foi marcada  
independente do que seja.
![](/img/distorcaoSqlRelacionalLimit.png)  

O correto e usar o sql com IN  
![](/img/sqlComLimit.png)  

