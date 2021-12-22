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
