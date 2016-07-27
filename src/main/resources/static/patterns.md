#Angularjs em Patterns

##abstrato

Uma das melhores maneiras de aprender algo novo é ver como as coisas que você já conhece são usados ​​nele. Este documento não tem a intenção de fazer seus leitores familiarizados com o projeto ou padrões arquitetônicos; ele sugere compreensão básica dos conceitos de OOP, padrões de projeto e os padrões arquitetônicos. O objetivo deste artigo é descrever o quão diferente design de software e padrões arquitetônicos são aplicados em angularjs ou quaisquer angularjs aplicação de uma única página.

##Introdução

O documento começa com breve visão geral do quadro angularjs. A visão geral explica os principais componentes angularjs - directivas, filtros, controladores, serviços, de escopo. A segunda seção lista e descreve design diferente e os padrões arquitetônicos, que são implementados dentro do quadro. Os padrões são agrupados por o componente angularjs eles são usados ​​em. Se alguns padrões são utilizados dentro de vários componentes que serão explicitamente mencionados.

A última seção contém alguns padrões arquitetônicos, que são comumente utilizados no interior a maioria dos aplicativos de uma única página construídos com angularjs.

##Visão geral angularjs

Angularjs é um framework JavaScript desenvolvido pelo Google. Ele pretende fornecer uma base sólida para o desenvolvimento de aplicações CRUD de uma única página (SPA). SPA é uma aplicação web, que uma vez carregado, não exige recarga completa da página quando o usuário executa qualquer ação com ele. Isto significa que todos os recursos do aplicativo (dados, modelos, scripts, estilos) deve ser carregado com o pedido inicial ou melhor - a informação e os recursos devem ser carregados sob demanda. Como a maioria dos aplicativos CRUD tem características e requisitos comuns, angularjs pretende fornecer o melhor conjunto deles out-of-the-box. Algumas características importantes de angularjs são:

* dados de duas vias de ligação
* Injeção de dependência
* separação de preocupações
* testability
* abstração

A separação de preocupações é obtida dividindo-se cada aplicação angularjs em componentes separados, tais como:

* parciais
* controladores
* directivas
* Serviços
* filtros

Esses componentes podem ser agrupados dentro de diferentes módulos, o que ajuda a atingir um nível mais alto de abstração e lidar com a complexidade. Cada um dos componentes encapsula um pedaço específico de lógica da aplicação.

##Partials

As parciais são strings HTML. Eles podem conter angularjs expressões dentro dos elementos ou os seus atributos. Uma das diferenças entre a angularjs e os outros quadros é o facto de que os modelos 'angularjs não estão em um formato intermediário, que tem de ser transformado em HTML (como é o caso com mustache.js e guiador, por exemplo).

Inicialmente, cada SPA cargas index.html arquivo. No caso de angularjs este arquivo contém um conjunto de padrões e HTML personalizado atributos, elementos e comentários, que configuram e arranque do aplicativo. Cada ação do usuário sub-seqüenciado requer apenas carga de uma outra mudança parcial ou do estado da aplicação, por exemplo através dos dados de ligação proporcionada pela estrutura.

###Amostra parcial

```html

<html ng-app>
 <!-- Body tag augmented with ngController directive  -->
 <body ng-controller="MyController">
   <input ng-model="foo" value="bar">
   <!-- Button tag with ng-click directive, and
          string expression 'buttonText'
          wrapped in "{{ }}" markup -->
   <button ng-click="changeFoo()">{{buttonText}}</button>
   <script src="angular.js"></script>
 </body>
</html>
 
```
Com expressões angularjs parciais definir que tipo de ações devem ser executadas para o tratamento de diferentes interações do usuário. No exemplo acima, o valor do atributo ng clique com estados que o método changeFoo da corrente âmbito será invocado.

##Controladores

Os controladores angularjs são funções de JavaScript, que ajudam a manipular as interações do usuário com o aplicativo web (por exemplo, eventos de mouse, os eventos de teclado, etc.), anexando métodos para o escopo. Todos exigida externo, para os controladores, os componentes são fornecidos através do mecanismo de injeção de dependência de angularjs. Os controladores também são responsáveis ​​por fornecer o modelo para as parciais, anexando os dados para o escopo. Podemos pensar em como esses dados vista de modelo.

```js
function MyController($scope) {
  $scope.buttonText = 'Click me to change foo!';
  $scope.foo = 42;

  $scope.changeFoo = function () {
    $scope.foo += 1;
    alert('Foo changed');
  };
}
```

Por exemplo, se o controlador de fio de exemplo acima com o parcial prevista na secção anterior, o utilizador irá ser capaz de interagir com a aplicação em algumas maneiras diferentes.

Altere o valor de foo, digitando na caixa de entrada. Isso irá refletir imediatamente o valor de foo por causa das duas vias de ligação de dados.
Altere o valor de foo, clicando no botão, que será marcado Clique-me a mudar foo!.
Todos os elementos personalizados, atributos, comentários ou classes poderiam ser reconhecidos como angularjs directivas se forem previamente definidos como aqueles.

##Scope

Scope no angularjs é um objecto JavaScript, que está exposta aos parciais. O escopo pode conter diferentes propriedades - primitivos, objectos ou métodos. Todos os métodos ligados ao âmbito de aplicação poderia ser invocado por avaliação de angularjs expressão dentro dos parciais associadas ao escopo do dado ou chamada direta do método de qualquer componente, que mantém referência ao âmbito. Usando adequadas directivas, os dados ligados ao âmbito de aplicação poderia ser binded à vista de tal forma que cada mudança na parcial irá refletir uma propriedade escopo e cada mudança de uma propriedade escopo irá refletir a parcial.

Outra característica importante dos âmbitos de qualquer aplicação angularjs é que eles estão conectados em uma cadeia protótipo (exceto escopos, que são explicitamente declarados como isolado). Desta forma, qualquer escopo filho será capaz de chamar métodos de seus pais, uma vez que são propriedades de seu protótipo, direta ou indireta.

Âmbito herança é ilustrada no seguinte exemplo:

```html
<div ng-controller="BaseCtrl">
  <div id="child" ng-controller="ChildCtrl">
    <button id="parent-method" ng-click="foo()">Parent method</button>
    <button ng-click="bar()">Child method</button>
  </div>
</div>
```

```js
function BaseCtrl($scope) {
  $scope.foo = function () {
    alert('Base foo');
  };
}

function ChildCtrl($scope) {
  $scope.bar = function () {
    alert('Child bar');
  };
}
```

Com div # criança está associada ChildCtrl mas desde o alcance injetado dentro ChildCtrl herda prototipicamente do seu âmbito pai (ou seja, aquele injetado dentro BaseCtrl) o método foo é acessível por botão # pais e método.

##Directives

Em angularjs as directivas são o lugar onde todas as manipulações DOM devem ser colocados. Como regra geral, quando você tem manipulações DOM em seu controlador, você deve criar uma nova directiva ou considerar refatoração do já existente, que poderia lidar com as manipulações DOM necessários. Cada directiva tem um nome e uma lógica associada a ele. No caso mais simples da directiva contém apenas nome e definição de postLink função, que encapsula toda a lógica necessária para a directiva. Em casos mais complexos da directiva poderia conter uma grande quantidade de propriedades, tais como:

* template
* compilar função
* função de ligação
* etc ...

Ao citar o nome das directivas que podem ser usados ​​dentro os parciais declarativas.

Exemplo:

```js
myModule.directive('alertButton', function () {
  return {
    template: '<button ng-transclude></button>',
    scope: {
      content: '@'
    },
    replace: true,
    restrict: 'E',
    transclude: true,
    link: function (scope, el) {
      el.click(function () {
        alert(scope.content);
      });
    }
  };
});
```
```html
<alert-button content="42">Click me</alert-button>
```

No exemplo acima, a tag <alerta-button> <-botão de alerta /> será substituído elemento botão. Quando o usuário clica no botão a seqüência 42 será alertado.

Uma vez que a intenção deste artigo não é explicar a API completa de angularjs, vamos parar com as directivas aqui.

##Filters

Os filtros em angularjs são responsáveis ​​para a encapsulação de lógica necessária para a formatação de dados. Normalmente, os filtros são usados ​​dentro dos parciais, mas eles também são acessíveis nos controladores, directivas, serviços e outros filtros através de Dependency Injection.

Aqui está uma definição de um filtro de amostra, o que muda a string dada em maiúsculas:

```js
myModule.filter('uppercase', function () {
  return function (str) {
    return (str || '').toUpperCase();
  };
});
```

Dentro de um parcial este filtro poderia ser usado usando a sintaxe tubulação do Unix:

```html
<div>{{ name | uppercase }}</div>
```

Dentro de um controlador do filtro pode ser utilizado como se segue:

```js
function MyCtrl(uppercaseFilter) {
  $scope.name = uppercaseFilter('foo'); //FOO
}
```

##Services

Cada pedaço de lógica, que não pertence aos componentes descritos acima devem ser colocados dentro de um serviço. Normalmente serviços encapsular a lógica do domínio específico, a lógica de persistência, XHR, WebSockets, etc. Quando os controladores na aplicação tornou-se também "gordura" do código repetitivo deve ser colocado dentro de um serviço.

```js
myModule.service('Developer', function () {
  this.name = 'Foo';
  this.motherLanguage = 'JavaScript';
  this.live = function () {
    while (true) {
      this.code();
    }
  };
});
```

O serviço pode ser injetado dentro de qualquer componente, que apoia a injeção de dependência (controladores, outros serviços, filtros, directivas).

```js
function MyCtrl(Developer) {
  var developer = new Developer();
  developer.live();
}
```

##Angularjs Patterns

Na próxima de um par de seções, vamos dar uma olhada como o design tradicional e os padrões arquitetônicos são compostos nos componentes angularjs.

No último capítulo, vamos dar uma olhada em alguns padrões arquitetônicos, que são frequentemente utilizadas no desenvolvimento de uma única página com Applications (mas não exclusivamente) angularjs.

##Services

> Singleton
>
> O padrão singleton é um padrão de projeto que restringe a instanciação de uma classe para um objeto. Isso é útil quando exatamente um objeto é necessária para coordenar as ações em todo o sistema. O conceito é por vezes generalizado para sistemas que operam de maneira mais eficiente quando existe > apenas um objecto, ou para restringir a instanciação para um certo número de objectos.
> No diagrama abaixo UML é ilustrado o padrão de design singleton.

##Singleton

Quando dada a dependência é exigido por qualquer componente, angularjs resolve-lo usando o seguinte algoritmo:

Leva o seu nome e faz uma pesquisa em um mapa hash, que é definido em um fechamento lexical (para que ele tenha uma visibilidade privada).
Se a dependência existe angularjs passá-lo como parâmetro para o componente, o que exige.
Se a dependência não existe:
Angularjs instanciar-lo chamando o método de fábrica de seu fornecedor (ie $ get). Note que instanciar a dependência pode exigir chamada recursiva para o mesmo algoritmo, para resolver todas as dependências exigidas pela dependência dada. Este processo pode levar a dependência circular.
Angularjs armazena em cache-lo dentro do mapa de hash mencionado acima.
Angularjs passa-o como parâmetro para o componente, o que exige.
Nós podemos ter um melhor olhar para o código fonte dos angularjs, que implementa o método getService:

```js
function getService(serviceName) {
  if (cache.hasOwnProperty(serviceName)) {
    if (cache[serviceName] === INSTANTIATING) {
      throw $injectorMinErr('cdep', 'Circular dependency found: {0}', path.join(' <- '));
    }
    return cache[serviceName];
  } else {
    try {
      path.unshift(serviceName);
      cache[serviceName] = INSTANTIATING;
      return cache[serviceName] = factory(serviceName);
    } catch (err) {
      if (cache[serviceName] === INSTANTIATING) {
        delete cache[serviceName];
      }
      throw err;
    } finally {
      path.shift();
    }
  }
}
```

Podemos pensar em cada serviço como um solteirão, porque cada serviço é instanciado não mais do que uma única vez. Podemos considerar o cache como um gerente singleton. Há uma ligeira variação a partir do diagrama UML ilustrado acima, porque em vez de manter, referência particular estático para o singleton dentro de sua função de construtor, mantemos a referência dentro do gerente singleton (indicado no trecho acima como de cache).

Desta forma, os serviços são realmente únicos, mas não implementadas através do padrão Singleton, que oferece algumas vantagens sobre a implementação padrão:

* Além disso, melhora a capacidade de teste de seu código-fonte
* Você pode controlar a criação de objetos do solteirão (no nosso caso o contêiner IoC controla-lo para nós, por instanciar os singletons preguiçoso)

Para uma discussão mais aprofundada sobre este tema da Misko Hevery artigo no blog do Google Testing poderia ser considerada.

##Factory Method

O padrão Factory Method é um padrão criacional, que usa métodos de fábrica para lidar com o problema da criação de objetos sem especificar a classe exata do objeto que será criado. Isto é feito através da criação de objetos por meio de um método de fábrica, o que é ou especificados em uma interface (classe abstrata) e implementado na implementação de classes (classes concretas); ou implementado em uma classe base, que pode ser substituído quando herdou em classes derivadas; em vez de por um construtor.
Factory Method

Vamos considerar o seguinte trecho:

```JS
myModule.config(function ($provide) {
  $provide.provider('foo', function () {
    var baz = 42;
    return {
      //Factory method
      $get: function (bar) {
        var baz = bar.baz();
        return {
          baz: baz
        };
      }
    };
  });
});
```

No código acima nós usamos a configuração callback para definir novo "provedor". Provider é um objeto, que tem um método chamado $ get. Uma vez que em JavaScript não temos as interfaces ea linguagem é pato-digitado existe uma convenção para nomear o método de fábrica dos fornecedores de que maneira.

Cada serviço, filtro, directiva e controlador tem um fornecedor (ou seja, objeto que método de fábrica, chamada $ get), que é responsável pela criação de instância do componente.

Nós podemos cavar um pouco mais fundo na implementação 'angularjs:

```JS
//...

createInternalInjector(instanceCache, function(servicename) {
  var provider = providerInjector.get(servicename + providerSuffix);
  return instanceInjector.invoke(provider.$get, provider, undefined, servicename);
}, strictDi));

//...

function invoke(fn, self, locals, serviceName){
  if (typeof locals === 'string') {
    serviceName = locals;
    locals = null;
  }

  var args = [],
      $inject = annotate(fn, strictDi, serviceName),
      length, i,
      key;

  for(i = 0, length = $inject.length; i < length; i++) {
    key = $inject[i];
    if (typeof key !== 'string') {
      throw $injectorMinErr('itkn',
              'Incorrect injection token! Expected service name as string, got {0}', key);
    }
    args.push(
      locals && locals.hasOwnProperty(key)
      ? locals[key]
      : getService(key)
    );
  }
  if (!fn.$inject) {
    // this means that we must be an array.
    fn = fn[length];
  }

  return fn.apply(self, args);
}
```

A partir do exemplo acima, podemos observar como o $ get método é realmente usado:

```js
instanceInjector.invoke(provider.$get, provider, undefined, servicename)
```

O trecho acima chama a invocação de método de instanceInjector com o método de fábrica (ou seja, $ get) de determinado serviço, como primeiro argumento. Dentro invocação 's corpo annotate é chamado com o primeiro argumento do método de fábrica. Anotar resolve todas as dependências através do mecanismo de injeção de dependência de angularjs, que foi considerado acima. Quando todas as dependências são resolvidas o método de fábrica está sendo chamado: fn.apply (self, args).

Se pensarmos em termos do diagrama UML acima, podemos chamar o provedor de um "ConcreteCreator" ea componente real, que está a ser criado um "produto".

Existem algumas vantagens da utilização do método padrão de fábrica, neste caso, devido à dissimulação ele cria. Desta forma, o quadro pode cuidar dos boilerplates durante a instanciação de novos componentes como:

* O momento mais apropriado, quando o componente tem de ser instanciada
* Resolver todas as dependências necessárias pelo componente
* O número de instâncias do componente dado é permitido ter (para serviços e filtra apenas um único, mas um múltiplo para os controladores)


> Decorator
>
> O padrão da decoração (também conhecido como envoltório, uma nomenclatura alternativa partilhada com o padrão Adapter) é um padrão de design que permite que o comportamento a ser adicionado a um objecto individual, estaticamente ou dinamicamente, sem afectar o comportamento de outros objectos a > partir da mesma classe.

Angularjs fornece a maneira out-of-the-box para estender e / ou melhorar a funcionalidade dos serviços já existentes. Usando o método decorador de $ fornecem você pode criar "wrapper" de qualquer serviço que você já definido ou utilizado por um terceiro:

```js
myModule.controller('MainCtrl', function (foo) {
  foo.bar();
});

myModule.factory('foo', function () {
  return {
    bar: function () {
      console.log('I\'m bar');
    },
    baz: function () {
      console.log('I\'m baz');
    }
  };
});

myModule.config(function ($provide) {
  $provide.decorator('foo', function ($delegate) {
    var barBackup = $delegate.bar;
    $delegate.bar = function () {
      console.log('Decorated');
      barBackup.apply($delegate, arguments);
    };
    return $delegate;
  });
});
```

O exemplo acima define novo serviço chamado foo. Na configuração de retorno de chamada é chamado o método $ provide.decorator com o primeiro argumento "foo", que é o nome do serviço, queremos decorar e segunda função argumento fábrica, que implementa a decoração real. $ Delegado mantém referência ao original serviço foo. Usando o mecanismo de injeção de dependência de angularjs, a referência a esta dependência local é passada como primeiro argumento da função de construtor. Nós decoramos o serviço, substituindo seu método bar. A decoração real é simplesmente estender bar invocando mais uma declaração console.log - console.log ('decorado'); e depois que chamar o original bar método com o contexto apropriado.

Usando este padrão é especialmente útil quando precisamos modificar a funcionalidade de serviços de terceiros. Nos casos em que são necessárias várias decorações semelhantes (como medição de desempenho de vários métodos, autorização, registro, etc.), podemos ter um monte de duplicações e violam o princípio DRY. Em tais casos, é útil utilizar-oriented programming aspecto. O quadro AOP apenas para angularjs Estou ciente poderia ser encontrado na github.com/mgechev/angular-aop.

##Facade

>A fachada é um objeto que fornece uma interface simplificada para um conjunto maior de código, como uma biblioteca de classes. A fachada pode:
>* fazer uma biblioteca de software fácil de usar, entender e teste, desde a fachada tem métodos convenientes para as tarefas comuns;
>* tornar a biblioteca mais legível, pelo mesmo motivo;
>* reduzir as dependências de código fora sobre o funcionamento interno de uma biblioteca, já que a maioria de código usa a fachada, permitindo assim uma maior flexibilidade no desenvolvimento do sistema;
>* enrole uma coleção de APIs mal projetado com uma única API bem concebido (como por necessidades de tarefas).

###Facade

Existem algumas fachadas na angularjs. Cada vez que você quer para proporcionar maior nível API para determinada funcionalidade que você praticamente criar uma fachada.

Por exemplo, vamos dar uma olhada como podemos criar um XMLHttpRequest pedido POST:

```js
var http = new XMLHttpRequest(),
    url = '/example/new',
    params = encodeURIComponent(data);
http.open("POST", url, true);

http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
http.setRequestHeader("Content-length", params.length);
http.setRequestHeader("Connection", "close");

http.onreadystatechange = function () {
  if(http.readyState == 4 && http.status == 200) {
    alert(http.responseText);
  }
}
http.send(params);
```

Mas se queremos publicar estes dados através dos angularjs $ http serviço que pode:

```js
$http({
  method: 'POST',
  url: '/example/new',
  data: data
})
.then(function (response) {
  alert(response);
});
```

ou podemos mesmo:

```js
$http.post('/someUrl', data)
.then(function (response) {
  alert(response);
});
```

A segunda opção oferece versão pré-configurada, o que cria uma solicitação HTTP POST para o URL dado.

Ainda maior nível de abstração está sendo criado por $ recurso, que é construir sobre o $ http serviço. Vamos dar uma olhada mais neste serviço no Active Record e Proxy seções.

#Proxy

Um proxy, na sua forma mais geral, é um funcionamento de classe como uma interface para outra coisa. O proxy pode fazer interface com qualquer coisa: uma conexão de rede, um grande objeto na memória, um arquivo, ou algum outro recurso que é caro ou impossível de duplicar.
Proxy

Podemos distinguir três tipos diferentes de proxy:

* Proxy Virtual
* Proxy Remoto
* Proxy proteção

Neste sub-capítulo, vamos dar uma olhada em implementação de Proxy Virtual 'angularjs.

No trecho abaixo, há uma chamada para o get método de $ recurso instância, chamado Usuário:

```js
var User = $resource('/users/:id'),
    user = User.get({ id: 42 });
console.log(user); //{}
```

console.log que gera um objeto vazio. Uma vez que o pedido de AJAX, o que acontece por trás da cena, quando User.get é invocado, é assíncrona, não temos o usuário real quando console.log é chamado. Logo após User.get faz a solicitação GET retorna um objeto vazio e mantém referência a ele. Podemos pensar em como este objeto de proxy virtual (um espaço reservado simples), que seria preenchida com os dados reais, uma vez que o cliente recebe resposta pelo servidor.

Como é que isso funciona com angularjs? Bem, vamos considerar o seguinte trecho:

```js
function MainCtrl($scope, $resource) {
  var User = $resource('/users/:id'),
  $scope.user = User.get({ id: 42 });
}
```

<Extensão  ng-bind = "user.name"> </ palmo>
Inicialmente, quando o trecho acima é executada, a propriedade do usuário do escopo $ objeto será com valor um objeto vazio ({}), o que significa que user.name será indefinido e nada será processado. Internamente angularjs manterá referência a este objeto vazio. Uma vez que o servidor retorna a resposta para o pedido get, angularjs irá preencher o objeto com os dados, recebidos do servidor. Durante o próximo $ digerir angularjs de loop irá detectar mudanças em $ scope.user, o que levará a atualização da exibição.

##Active Record

> O objeto Active Record é um objeto, que transporta os dados e comportamento. Normalmente, a maioria dos dados nesses objetos é persistente, a responsabilidade do objeto Active Record é cuidar da comunicação com o banco de dados, a fim de criar, atualizar, recuperar ou apagar os dados. Ele pode > delegar essa responsabilidade para objetos de nível inferior, mas chama a instância ou métodos estáticos do objeto registro ativo causar a comunicação de dados.

###Active Record

Angularjs define um serviço chamado $ recurso. Na versão atual do angularjs (1.2+) que está sendo distribuído no módulo fora do núcleo dos angularjs.

De acordo com a documentação dos angularjs $ recurso é:

Uma fábrica que cria um objeto de recurso que lhe permite interagir com as fontes de dados do lado do servidor RESTful. O objeto de recurso retornado tem métodos de ação que fornecem comportamentos de alto nível, sem a necessidade de interagir com o baixo nível de serviço $ http.
Aqui está como $ recurso poderia ser usado:

var Usuário = $ recurso ('/ usuários /: id'),
    user =  new  Usuário ({
      Nome:  'foo',
      idade:  42
    });

. utilizador $ save ();
A chamada de $ recurso criará uma função de construtor de nossas instâncias do modelo. Cada um dos casos modelo terá métodos, que podem ser utilizados para as diferentes operações CRUD.

Dessa forma, podemos usar a função de construtor e os seus métodos estáticos por:

User.get ({ID do usuário: ID do usuário});
O código acima irá retornar imediatamente um objeto vazio e manter referência a ele. Uma vez que a resposta ter sido devolvido e analisado com êxito, angularjs preencherá esse objeto com os dados recebidos (ver procuração).

Você pode encontrar mais detalhes sobre $ resource A magia de US $ recurso e documentação 'angularjs.

Desde que afirma Martin Fowler

responsabilidade do objeto Active Record é cuidar da comunicação com o databse a fim de criar ...
$ recurso não implementa exatamente o padrão Active Record, uma vez que ele se comunica com o serviço RESTful em vez do banco de dados. De qualquer forma, podemos considerá-lo como "Active Record como a comunicação RESTful".

Interceptando Filtros

Criar uma cadeia de filtros componíveis para implementar o pré-processamento comum e tarefas de pós-processamento durante uma solicitação de página da Web.
Composto

Em alguns casos, você precisa fazer algum tipo de pré e / ou pós-processamento de solicitações HTTP. No caso dos Filtros interceptando você pré / pós-processamento determinada solicitação HTTP / resposta, a fim de incluir o registo, a segurança ou qualquer outra preocupação, que é influenciada pelo órgão ou cabeçalhos de solicitação. Basicamente, o Interceptar Filtros padrão incluem uma cadeia de filtros, cada um dos quais processam dados em determinada ordem. A saída de cada filtro é de entrada do próximo.

Em angularjs temos a idéia dos Filtros interceptando em $ httpProvider. $ HttpProvider tem uma propriedade de matriz chamado interceptores, que contém uma lista de objetos. Cada objeto pode ter propriedades chamado: pedido, resposta, RequestError, responseError.

RequestError é um interceptor, que é chamado quando um interceptor anterior jogou um erro ou resolvidos com uma rejeição, respectivamente responseError está sendo chamado quando o anterior resposta interceptor tem jogado um erro.

Aqui está um exemplo básico como você pode adicionar usando interceptadores objeto literal:

$ httpProvider.interceptors. empurrar (função ($ q, Dependency1, 
  dependency2) {return 
   {'pedido': função (configuração) {//
        o mesmo que acima 
    },
    'Resposta':  função (resposta) {//
        o mesmo que acima
    }
  };
});
Directivas

Composto

O padrão composto é um padrão de design de particionamento. O padrão de compósito que descreve um grupo de objectos estão a ser tratadas da mesma forma como uma única instância de um objecto. A intenção de um compósito é a "compor" objetos em estruturas de árvore para representar hierarquias parte-todo.
Composto

De acordo com o Gang of Four, MVC é nada mais do que combinação de:

Estratégia
Composto
Observador
Eles afirmam que a vista é composição de componentes. Em angularjs a situação é semelhante. Nossos pontos de vista são formados por uma composição de directivas e de elementos DOM, em que estas directivas poderia ser aplicada.

Vamos olhar para o exemplo a seguir:

<! doctype html>
<Html>
  <Cabeça>
  </ Cabeça>
  <Corpo>
    <Zippy  título = "Zippy">
      Zippy!
    </ Zippy>
  </ Corpo>
</ Html>
myModule.directive ('Zippy', função ()
  {return {
    restringir:  'E',
    template:  '<div> <div class = "header"> </ div> <div class = "conteúdo" ng-transclude> </ div> </ div> ",
     ligação: função (escopo, el) { 
      el. encontrar ('.header'). click (função () {
        . el encontrar ('.content') .toggle ();
      });
    }
  }
});
Este exemplo define uma diretiva simples, que é um componente de UI. O componente definido (chamado de "Zippy") tem cabeçalho e conteúdo. Clique no seu cabeçalho alterna a visibilidade do conteúdo.

Desde o primeiro exemplo, podemos observar que toda a árvore DOM é uma composição de elementos. O componente de raiz é o html elemento, imediatamente seguida pela elementos aninhados cabeça e corpo e assim por diante ...

Na segunda, JavaScript, exemplo, vemos que o modelo de propriedade da directiva, contém marcação com ng-transclude directiva dentro dela. Então isso significa que dentro da directiva Zippy temos outra directiva chamado ng-transclude, ou seja, a composição das directivas. Teoricamente podemos ninho dos componentes infinitamente até chegar a um nó folha.

Intérprete

Na programação de computadores, o padrão de intérprete é um padrão de projeto que especifica como avaliar frases em uma língua. A idéia básica é ter uma classe para cada símbolo (terminal ou não-terminal), em uma linguagem de computador especializado. A árvore de sintaxe de uma frase na língua é um exemplo do padrão composto e é usada para avaliar (interpretar) a sentença.
Intérprete

Por detrás da sua $ ​​parse serviço, angularjs fornece sua própria implementação de intérprete de uma DSL (Domain Specific Language). O DSL usado é simplificada ea versão do JavaScript modificado. As principais diferenças entre as expressões JavaScript e angularjs expressões que angularjs expressões:

pode conter filtros com UNIX como sintaxe tubulação
não jogue quaisquer erros
Não temos quaisquer declarações de controle de fluxo (exceções, loops, se as declarações embora você possa usar o operador ternário)
são avaliadas no contexto dado (o contexto da actual $ escopo)
Dentro do $ parse serviço são definidos dois componentes principais:

// Responsável pela conversão de determinada cadeia em tokens 
var Lexer;
 // Responsável por analisar os tokens e avaliação da expressão 
var Analisador;
Uma vez determinada expressão foram tokenized ele é armazenado em cache internamente, por causa de preocupações de desempenho.

As expressões terminais na angularjs DSL são definidos como se segue:

var  OPERADORES  = {/
   * jshint bit a bit: false */ ' null ' : function (){ return null ;},
   ' true ' : function (){ return true ;},
   ' false ' : function (){ return false ;},
   undefined : noop,
   ' + ' : function ( self , locals , a , b ){
         //...
     
      },
  '*': Função (auto, moradores, um, b) {return um (self, moradores) * b (self, moradores);},
   '/': função (auto, moradores, um, b) {return um ( auto, moradores) / b (self, moradores);},
   '%': função (auto, moradores, um, b) {return um (self, moradores)% b (self, moradores);},
   '^': função (auto, moradores, um, b) {return um (self, moradores) ^ b (self, moradores);},
   '=': noop,
   '===': função (auto, moradores, um, b) {retornar um (self, moradores) === b (self, moradores);},
   '==!': função (auto, moradores, um, b) {return um (self, moradores)! == b (self , moradores);},
   '==': função (auto, moradores, um, b) {return um (self, moradores) == b (self, moradores);},
   '=!': função (auto, locals , a, b) {return um (self, moradores) =! b (self, moradores);},
   '<': função (auto, moradores, um, b) {return um (self, moradores) 
  <b (self , moradores);}, '>': função (auto, moradores, um, b) {return um (self, moradores)> b (self, moradores);},
   '<=': função (auto, moradores, um , b) {return um (self, moradores) <= b (self, moradores);},
   '> =': função (auto, moradores, um, b) {return um (self, moradores)> = b (self , moradores);},
   '&&': função (auto, moradores, um, b) {return um (self, moradores) && b (self, moradores);},
   '||': função (auto, moradores, um , b) {return um (self, moradores) || b (self, moradores);},
   '&': função (auto, moradores, um, b) {return um (self, moradores) & b (self, locals );},
   '|': função (auto, moradores, um, b) {return b (self, moradores) (self, moradores, um (self, moradores));},
   '!': função (auto, locals , um) {return! um (self, moradores);} 
};
Podemos pensar a função associada a cada terminal como a implementação do abstractexpression interface 's.

Cada cliente interpreta dada expressão angularjs em um contexto específico - escopo específico.

Alguns exemplos de expressões angularjs são:

// ToUpperCase filtro é aplicado ao resultado da expressão 
// (foo)? Bar: Baz 
(foo)? bar: Baz | toUpperCase
Ver Template

Processa informações em HTML, incorporando marcadores em uma página HTML.
Ver Template

A renderização de páginas dinâmicas não é aquela coisa trivial. Ele está ligado com uma grande quantidade de encadeamentos de cordas, as manipulações e frustração. Maneira muito mais fácil para construir a sua página dinâmica é escrever sua marcação e incorporar pequenos expressões no seu interior, que são ultimamente avaliados em determinado contexto e assim por todo o modelo está sendo compilados ao seu formato final. No nosso caso, este formato vai ser HTML (ou mesmo DOM). Este é exatamente o que os motores de modelos fazer - eles tomam dada DSL, avaliá-lo no contexto apropriado e, em seguida, transformá-lo em seu formato final.

Modelos são muito usados ​​especialmente no back-end. Por exemplo, você pode inserir código PHP dentro do HTML e criar uma página dinâmica, você pode usar Smarty ou você pode usar eRuby com Ruby, a fim de incorporar código Ruby dentro de suas páginas estáticas.

Para JavaScript há uma abundância de modelo de motores, como mustache.js, guidão, etc. A maioria destes motores de manipular o modelo como um string. O modelo poderia ser localizados em lugares diferentes - como arquivo estático, que é buscada com AJAX, como roteiro incorporado dentro de sua visão ou mesmo embutido em seu JavaScript.

Por exemplo:

<Script de tipo = "template / bigode">  
  <h2> Names </ h2>
   {{#NAMES}} 
    <strong> {{name}} </ forte>
   {{/ nomes}} 
</ script de>
O modelo de motor transforma essa string em elementos DOM por compilá-lo dentro de um determinado contexto. Desta forma, todas as expressões incorporadas na marcação são avaliados e substituído por seu valor.

Por exemplo, se avaliar o modelo acima no contexto da seguinte objeto: {nomes: ['foo', 'bar', 'baz']}, por isso vamos começar:

<H2> Nomes </ h2>
  <Strong> foo </ strong>
  <Strong> barra </ strong>
  <Strong> baz </ strong>
Angularjs modelos são realmente HTML, eles não estão em um formato intermediário como os modelos tradicionais são. O que angularjs compilador faz é percorrer a árvore DOM e procurar directivas já conhecidos (elementos, atributos, classes ou mesmo comentários). Quando angularjs encontra qualquer destas directivas ele invoca a lógica que lhes estão associados, o que pode incluir a avaliação das expressões diferentes no contexto do escopo atual.

Por exemplo:

<Ul  ng-repeat = "nome em nomes">
  <Li> {{name}} </ li>
</ Ul>
no contexto do escopo:

$ scope.names = ['foo', 'bar', 'baz'];
irá produzir o mesmo resultado que o descrito acima. A principal diferença aqui é que o modelo não é enrolado dentro de um script de tag HTML, mas é em vez disso.

Escopo

Observador

O observador padrão é um padrão de projeto de software no qual um objeto, chamado o assunto, mantém uma lista de seus dependentes, chamados de observadores, e notifica-los automaticamente de quaisquer mudanças de estado, geralmente chamando um dos seus métodos. É usada principalmente para implementar sistemas de manuseio de eventos distribuídos.
Observador

Há duas maneiras básicas de comunicação entre os escopos em um aplicativo angularjs. A primeira é chamada de métodos de escopo pai de um escopo filho. Isso é possível desde que o escopo filho herda prototipicamente por seu pai, como mencionado acima (ver Scope). Isto permite a comunicação em uma única direção - filho para o pai. Algumas vezes é necessário chamar o método de determinado escopo criança ou notificá-la sobre um evento disparado no contexto do escopo pai. Angularjs fornece observador padrão built-in, que permite isso. Outro caso de uso possível, do padrão de observador, é quando vários escopos está interessado em determinado evento, mas o âmbito de aplicação, em que contexto o evento é acionado, não tem conhecimento deles. Isso permite que a dissociação entre os diferentes âmbitos, não dos escopos deve estar ciente de o resto dos escopos.

Cada escopo angularjs tem métodos públicos chamados $ em, $ emitem e $ transmissão. O método $ on aceita tópico como primeiro argumento e retorno de chamada como segunda. Podemos pensar no retorno de chamada como um observador - um objeto, que implementa o Observer de interface (em JavaScript as funções são de primeira classe, para que possamos fornecer apenas a execução do notificar método):

funcionar  ExampleCtrl ($ escopo) {
  $ escopo. $ em ('nome-evento', função de manipulador ()
    {// corpo 
  });
}
Desta forma, o escopo atual "subscreve" a eventos do tipo caso-name. Quando evento-nome é acionado em qualquer escopo pai ou filho do dado um, manipulador seria chamado.

Os métodos $ emitem e $ transmissão são usados ​​para fatos geradores respectivamente cima e para baixo através da cadeia de escopo. Por exemplo:

funcionar  ExampleCtrl ($ escopo) {
  . $ âmbito $ emitem ('evento-nome ", {foo:' bar '}); 
}
O escopo no exemplo acima, dispara o evento evento de nome para todos os escopos para cima. Isto significa que cada um dos escopos pai do dado um, que são inscritos no evento de evento-nome, seria notificado e seu manipulador callback será invocado.

Analógica é o caso quando o método $ transmissão é chamado. A única diferença é que o evento seria transmitido para baixo - a todas as crianças escopos. Cada escopo pode se inscrever em qualquer evento com várias chamadas de retorno (ou seja, ele pode associar vários observadores a determinado evento).

Na comunidade JavaScript este padrão é mais conhecido como publish / subscribe.

Para um exemplo de melhores práticas, ver Padrão Observer como um serviço externo

Cadeia de Responsabilidades

O padrão de cadeia de responsabilidade é um padrão de design que consiste em uma fonte de objetos de comando e uma série de objetos de processamento. Cada objeto de processamento contém lógica que define os tipos de objetos de comando que ele pode manipular; o resto é passado para o próximo objeto de processamento na cadeia. Um mecanismo existe também para a adição de novos objectos de processamento para o final desta cadeia.
Cadeia de Responsabilidades

Como afirmado acima os âmbitos em uma aplicação angularjs formam uma hierarquia conhecida como a cadeia do escopo. Alguns dos âmbitos são "isolado", o que significa que eles não herdam prototipicamente pelo seu escopo pai, mas está conectado a ela através do seu $ pai propriedade.

Quando $ emitem ou $ transmissão são chamados podemos pensar na cadeia de escopo como ônibus evento, ou até mesmo com mais precisão cadeia de responsabilidades. Uma vez que o evento é accionado ele é emitido baixo ou para cima (de acordo com o método, que foi chamado). Cada escopo subsequente pode:

Manipular o evento e passá-lo para a próxima escopo na cadeia
Manipular o evento e parar a sua propagação
Passar o evento para o próximo escopo na cadeia sem manuseá-lo
Pare a propagação do evento sem manuseá-lo
No exemplo abaixo, você pode ver um exemplo no qual ChildCtrl aciona um evento, que é propagado para cima através da cadeia de escopo. No caso acima, cada um dos escopos pai (o utilizado no ParentCtrl e aquele usado em MainCtrl) está indo para lidar com o evento fazendo login no console: "foo recebido". Se qualquer um dos âmbitos deve ser considerado como destino final ele pode chamar o método stopPropagation do objeto de evento, passado para a chamada de retorno.

myModule.controller ('MainCtrl', função ($ escopo) {
  . $ âmbito $ em ('foo', função ()
    {consola. log ('foo recebeu');
  });
});

myModule.controller ('ParentCtrl', função ($ escopo) {
  $ âmbito $ em (. 'foo', função (e) 
    {consola. log ('foo recebeu');
  });
});

myModule.controller ('ChildCtrl', função ($ escopo) {
  . $ âmbito $ emitem ('foo');
});
As diferentes manipuladores do diagrama UML acima são os escopos diferentes, injetados para os controladores.

Comando

Na programação orientada a objeto, o padrão de comando é um padrão comportamental projeto em que um objeto é usado para representar e sintetizar todas as informações necessárias para chamar um método em um momento posterior. Esta informação inclui o nome do método, o objeto que possui o método e os valores para os parâmetros do método.
Comando

Antes de continuar com a aplicação do padrão de comando permite descrever como angularjs implementa vinculação de dados.

Quando queremos ligar o nosso modelo para a vista que usar a directivas ng-bind (para ligação de dados de sentido único) e ng-modelo (para ligação de dados de duas vias). Por exemplo, se queremos que cada mudança no modelo de foo para refletir o ponto de vista nós podemos:

<Extensão  ng-bind = "foo"> </ palmo>
Agora, cada vez que alterar o valor de foo o texto interno da extensão será alterada. Podemos obter o mesmo efeito com mais expressões angularjs complexos, como:

<Extensão  ng-bind = "foo + '' + bar | maiúscula"> </ palmo>
No exemplo acima, o valor da extensão será o valor uppercased concatenada de foo e barra. O que acontece nos bastidores?

Cada $ escopo tem método chamado $ relógio. Quando o compilador angularjs encontrar a directiva ng-bind ele cria um novo observador da expressão foo + '' + bar | maiúsculo, ou seja. $ âmbito $ relógio ("foo + '' + bar | maiúscula", function () {/ * corpo * /});. O retorno de chamada irá ser desencadeada de cada vez o valor da mudança de expressão. No caso atual o callback irá atualizar o valor do span.

Aqui é o primeiro de um par de linhas de a implementação de $ relógio:

$ Relógio: função (watchExp, ouvinte, 
  objectEquality) {var escopo = esta,  
      get = compileToFn (watchExp, 'assistir'),
      matriz = escopo. $$ observadores,
      observador = {
        fn: ouvinte,
        última: initWatchVal,
        chegar: chegar,
        exp: watchExp,
        eq:  !! objectEquality
      };
// ...
Podemos pensar o observador de objeto como um comando. A expressão do comando está a ser avaliado em cada "$ digerir" loop. Uma vez angularjs detecta alterações na expressão, ele chama o ouvinte função. O observador de comando encapsula toda a informação necessária para assistir dada expressão e delega a execução do comando para o ouvinte (o receptor real). Podemos pensar no $ escopo quanto do comando do cliente eo $ digerir laço como do comando Invoker.

Controladores

Controlador de Página

Um objeto que lida com uma solicitação para uma página ou ação específica em um Web site. Martin Fowler
Controlador de Página

De acordo com o 4 o controlador página:

Página padrão Controlador aceitar a entrada do pedido de página, invocar as ações solicitadas sobre o modelo, e determinar a visão correta a ser usada para a página resultante. Separar a lógica despachar a partir de qualquer código relacionado à vista
Uma vez que há um monte de comportamento duplicado entre as diferentes páginas (como rodapés de renderização, cabeçalhos, cuidando de sessão do usuário, etc.) controladores de página podem formar uma hierarquia. Em angularjs temos controladores, que são de âmbito mais limitado de responsabilidades. Eles não aceitam solicitações de usuários, uma vez que este é responsabilidade do $ rota ou $ estaduais serviços e a renderização da página é da responsabilidade das directivas ng-view / ui-view.

Da mesma forma que os controladores de página, controladores angularjs lidar com as interações do usuário, fornecer e atualizar os modelos. O modelo está exposto à vista quando ele está sendo anexado ao âmbito, todos os métodos invocados pela vista, em resultado de acções do utilizador, são aqueles que já estão conectados ao escopo. Uma outra semelhança entre os controladores e os controladores de página angularjs representa a hierarquia, que eles formam. Ele corresponde à hierarquia âmbito. Que as ações ordinárias maneira pode ser isolado para os controladores de base.

Os controladores em angularjs são bastante semelhante ao código-behind em ASP.NET WebForms, uma vez que as suas responsabilidades quase sobreposição. Aqui está um exemplo de hierarquia entre alguns controladores:

<! doctype html>
<Html>
  <Cabeça>
  </ Cabeça>
  <Corpo  ng-controller = "MainCtrl">
    <Div  ng-controller = "ChildCtrl">
      <Espaço> {{user.name}} </ palmo>
      <Botão  ng clique com o botão = "click ()"> Clique </ botão>
    </ Div>
  </ Corpo>
</ Html>
função  MainCtrl ($ âmbito, $ local, 
  Utilizador) {se (! User.isAuthenticated ()) {
    $ location.path ('/ não autenticado');
  }
}

funcionar  ChildCtrl ($ âmbito, 
  Utilizador) {$ alcance. clique = função ()
    {alerta ("Você clicou em mim! ');  
  };
  $ scope.user = User.get (0);
}
Este exemplo ilustra visa a maneira mais simples de se reutilizar a lógica usando um controlador de base, de qualquer maneira em aplicações de produção Eu não recomendo que você coloque a sua lógica de autorização nos controladores. O acesso às diferentes rotas pôde ser determinada em um nível mais alto de abstração.

O ChildCtrl é responsável por manipular ações como clicar no botão com o rótulo "Click" e expondo o modelo para a vista, anexando-o ao alcance.

Outros

Módulo Padrão

Esta não é realmente um padrão de design da Gang of Four, nem um de P da EAA. Este é um padrão tradicional JavaScript, cujo objetivo principal é fornecer encapsulamento e privacidade.

Usando o padrão de módulo que você pode conseguir privacidade com base em escopo léxico funcional do JavaScript. Cada módulo pode ter zero ou mais membros privados, que estão escondidos no escopo local de uma função. Esta função retorna um objeto, que exporta a API pública do módulo de dado:

var página = (função () {

  var título;

  função  setTitle (t) 
    {documento. title = t; 
    título = t;
  }

  funcionar  getTitle ()
    {return título;
  }

  retornar {
    setTitle: setTitle,
    getTitle: getTitle
  };
} ());
No exemplo acima, temos IIFE (Imediatamente-Chamado Expressão Function), que depois de ser chamado retorna um objeto, com dois métodos (setTitle e GetTitle). O objeto retornado está sendo atribuído à página variável.

Neste caso, o utilizador do Página objecto não tem acesso directo ao título variável, que é definida dentro do escopo local do IIFE.

O padrão módulo é muito útil na definição de serviços em angularjs. Usando este padrão, podemos simular (e realmente conseguir) a privacidade:

app.factory ('foo', função () {

  funcionar  privateMember ()
    {// corpo ...
  }

  função  publicMember ()
    {// corpo ...
    privateMember ();
    //corpo
  }

  retornar {
    publicMember: publicMember
  };
});
Uma vez que quer injetar foo dentro de qualquer outro componente que não será capaz de usar os métodos privados, mas apenas as públicas. Esta solução é extremamente poderoso, especialmente quando se está construindo uma biblioteca reutilizável.

Data Mapper

Um mapeador de dados é uma camada de acesso a dados que realiza transferência bidirecional de dados entre um armazenamento persistente de dados (geralmente um banco de dados relacional) e uma representação de dados na memória (a camada de domínio). O objectivo do padrão é para manter a representação em memória e o armazenamento de dados persistente independentes uns dos outros e do próprio mapeador de dados.
Data Mapper

Como a descrição acima estados, o mapeador de dados é usado para transferência bidirecional de dados entre um armazenamento de dados persistente e uma representação na memória de dados. Normalmente o nosso aplicativo angularjs comunica com servidor de API, que é escrito em qualquer linguagem server-side (Ruby, PHP, Java, JavaScript, etc.).

Normalmente, se temos RESTful API $ recurso vai nos ajudar a comunicar com o servidor em Active Record como a moda. Embora, em algumas aplicações as entidades de dados retornados pelo servidor não estão no formato mais adequado, o que nós queremos usar no front-end.

Por exemplo, vamos supor que temos aplicação em que cada usuário possui:

nome
endereço
lista de amigos
E nosso API tem os métodos:

GET / user /: id - retorna o nome do usuário eo endereço de determinado usuário
GET / amigos /: id - retorna a lista de amigos de determinado usuário
Solução possível é que os dois serviços diferentes, uma para o primeiro e um método para a segunda. Provavelmente solução mais útil seria se nós temos um único serviço chamado do usuário, que carrega os amigos do usuário quando o usuário solicitar:

app.factory ('Usuário', função ($ q) {

  função  do usuário (nome, endereço, 
    amigos) {isso. nome = nome;
     este .Address = endereço;
     este .friends = amigos; 
  }

  Usuário. Chegar  =  função (params) 
    {var user = $ http.get ('/ user /' + params. Id), 
        amigos = $ http.get ('/ amigos /'  + params. id);
    $ q. tudo ([usuário, amigos])
    .then (função (usuário, 
      amigos) {retornar novo usuário (user. nome, user.address, amigos);  
    });
  };
  retornar do usuário;
});
Desta forma, criamos mapeador de pseudo-dados, que se adapta a nossa API de acordo com os requisitos de SPA.

Podemos usar o usuário do serviço por:

função  MainCtrl ($ âmbito, Utilizador) {
  User.get ({id:  1})
  .Então (função (dados) {
    $ scope.user = dados;
  });
}
E a seguinte parcial:

<Div>
  <Div>
    Nome: {{}} user.name
  </ Div>
  <Div>
    Endereço: {{}} user.address
  </ Div>
  <Div>
    Amigos com ids:
    <Ul>
      <Li  ng-repeat = "amigo em user.friends"> {{}} amigo </ li>
    </ Ul>
  </ Div>
</ Div>
Pattern Observer como um serviço externo

Cerca de

Abaixo está um exemplo tirado aqui. Esta é uma fábrica angular que cria um serviço de implementar o padrão Observer. Ele funciona bem com o método ControllerAs de trabalhar, pois ele pode ser muito mais eficiente que $ escopo. $ Relógio e mais específica para um escopo ou objeto único de US $ emitem e US $ transmissão quando utilizado corretamente.

Caso de Uso: Você usaria esse padrão para a comunicação entre 2 controladores que usam o mesmo modelo, mas não estão conectados de qualquer maneira.

Controlador Exemplo

Abaixo exemplo mostra como anexar, notificar e desanexar um evento.

angular.module ('app.controllers')
  .controller ('ObserverExample', ObserverExample);
. ObserverExample $ injete = ['ObserverService', '$ limite de tempo'];

função  ObserverExample (ObserverService, $ de tempo limite) 
  {var vm = esta;
   var id = 'vm1';  

  ObserverService.attach (callbackFunction, 'let_me_know', id)

  função  callbackFunction (params) 
    {consola. log ("agora eu sei ');
    ObserverService.detachByEvent ('let_me_know')
  }

  $ timeout (função () {
    ObserverService.notify ('let_me_know');
  }, 5000);
}
Forma alternativa de remover evento

angular.module ('app.controllers')
  .controller ('ObserverExample', ObserverExample);
. ObserverExample $ injete = ['ObserverService', '$ limite de tempo', '$ escopo'];

função  ObserverExample (ObserverService, $ de timeout, $ escopo) 
  {var vm = esta;
   var id = 'vm1';  
  ObserverService.attach (callbackFunction, 'let_me_know', id)

  função  callbackFunction (params) 
    {consola. log ("agora eu sei ');
  }

  $ timeout (função () {
    ObserverService.notify ('let_me_know');
  }, 5000);

  // Ouvintes limpeza quando este controlador é destruído 
  $ escopo. $ Em ('$ destruir', função de  manipulador () {
    ObserverService.detachByEvent ('let_me_know')
  });
}
Referências

Wikipedia. A fonte de todas as breves descrições dos padrões de projeto é wikipedia.
Documentação angularjs '
Repositório git 'angularjs
Controlador de Página
Padrões de arquitetura de aplicações corporativas (P da EAA)
Usando Dependência injecção para evitar Singletons
Por que alguém iria usar o Publish / Subscribe padrão (em JS / jQuery)?
Angularjs em Patterns é mantido por mgechev.
Esta página foi gerada por GitHub Pages usando o tema Cayman por Jason Longo.