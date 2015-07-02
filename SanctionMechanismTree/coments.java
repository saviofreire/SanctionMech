
(i)		Incluir um atributo que trate sobre as metas que estão no operador ESCOLHA. 
		Lembre-se que o mecanismo deve perceber apenas a meta que foi realmente escolhida;

	/*	Eu fui olhar no MOISE+ e ele trata as metas em escolha da seguinte forma: se duas metas A e B estao em escolha,
	 * 	isso não significa necessariamente que uma delas deve ser escolhida previamente, mas que
	 * 	qualquer uma delas pode ser executada. Porém uma e somente uma deve ser executada.
	 * 	Então no algoritmo eu verifico 
	 * 	se A e B não foram cumpridas ambas recebem punição individual
	 * 	se A nao foi cumprida e B sim ninguem recebe punição
	 * 	se B não foi cumprida e A sim ninguem recebe pinição
	 * 
	 */


(ii) 	Percebi que você implementou a escolha das metas que serão cumpridas ou não utilizando Threads. 
		Poderíamos deixar mais genérica para que facilitasse a execução dos próximos estudos de caso;

	/*	Na verdade a função execução de metas foi criada pra exemplificar 
	 * 	foi onde eu defini que o g12 iria falhar porém esta execução acontecerá a medida que os agentes 
	 * 	autonomicamente realizam suas tarefas. Aí entra o cálculo ddos cutos.
	 * 
	 */
(iii) Comparei o algoritmo com o artigo que enviamos para o CLEI e não foi incluída a entidade Contrato;


(iv) 	Analisando os resultados, seria interessante colocar o valor do custo coletivo e individual separados. 
		Veja os resultados do mesmo estudo de caso que calculamos no artigo:
	
	/*	O resultado g1	Cvmf = -3 (aqui seria apenas o custo gerencial, não?)
	 *  que deu diferente é porque o código somava a individual + a gerencial da meta g1
	 *  pq além de ser uma meta gerencial ela também está na hierarquia e se violada recebe individual
	 *  pois ela faz parte da sequencia g1 g2 g3
	 *  o código agora calcula separos os custos
	 *  
	 *  
	 *  A arquitetura é construída pela árvore
	 *  e a contagem de sanções é feita pela "leitura" da árvore,
	 *  ou seja leitura da hierarquia em si.
	 *  
	 */