# robocode

O respectivo projeto propõe criar um robô utilizando a API do Robocode. O robô criado herda da classe Robot. O mesmo será posto em uma arena de combate virtual para duelar contra os demais robôs.

![image](https://github.com/mtsfreitas/robocode/assets/21324690/920e5c1d-c379-4b19-891c-4a158a28ce2a)

[Projeto do modelo e nome do respectivo robô colorizado]

Para a construção do robô, foi consultado as fontes descritas nas referências desta documentação, que incluem a documentação da API na linguagem JAVA. O seu desenvolvimento foi realizado na IDE Netbeans.

![image](https://github.com/mtsfreitas/robocode/assets/21324690/a7032307-8b49-4998-b70c-4840b8ee1557)

[Robô “MetalGear” com suas cores definidas no jogo.]


# Decisões de projeto

Para visualizar as respectivas ações do robô, é necessário importar o código fonte no programa Robocode, ou adicionar o caminho “...\Robocode\build\classes” caso esteja utilizando uma IDE como por exemplo: Netbeans. O MetalGear possui os seguintes métodos:

## 1. Método: “onScannedRobot”
a. Disparos a longa distância (Distancia >= 300) : Para tentar prever o movimento do inimigo foi definido o disparo de 3 projéteis de seu canhão, divididos em poder fogo de “fire(1)”, “fire(3)”, “fire(1)”, sendo que no seu primeiro disparo o canhão desloca 5 pixels para a esquerda, o segundo disparo o canhão atira reto e o último disparo é deslocado 3 pixels para a direita.

b. Disparos a queima lata (Distancia < 300) : Qualquer inimigo a esta distância será disparado projéteis de poder de fogo “fire(3)”.

## 2. Método: “onHitWall”
Ao se esbarrar com uma parede, o robô muda o sentido da direção do movimento de modo não ficar preso nela;

## 3. Método: “onHitByBullet"
Quando o robô é atingido por um projétil inimigo, automaticamente irá se deslocar 100 pixels, numa tentativa de se esquivar outros tiros.

## 4. Método: “onHitRobot”
Quando se esbarra em um robô inimigo, ele redireciona a mira para este robô e atira com potência máxima (3). Além disso, ele recua de modo a se afastar dele.

## 5. Método: “setAdjustGunForRobotTurn”
O canhão vira independente da vez do robô.

# Considerações 
Com este projeto, nota-se a importância da definição de interfaces para outros desenvolvedores. Fica evidente, portanto, que foi possível observar todos os conceitos de orientação objetos, tendo uma maior presença de polimorfismo e herança. É importante evidenciar que o desenvolvimento do robô pelo robocode instigou a leitura de sua API para desenvolver em cima de uma base consistente muito bem detalhada.


# Referências
[1] Robocode. Disponível em: <https://robocode.sourceforge.io/> Acesso em
01/12/2019.
[2] Robocode 1.9.3.0 API (JAVA). Disponível em:
<https://robocode.sourceforge.io/docs/robocode/> Acesso em 01/12/2019.
[3] Installing Robocode & Using Netbeans to build robots. Disponível em:
<https://www.youtube.com/watch?v=5PsMHEL-1hQ> Acesso em 01/12/2019.
[4] Robocode - Estudo sobre os robôs exemplos. Disponível em:
<https://www.youtube.com/watch?v=Bz0RO1Fg1QY> Acesso em 02/12/2019.
[5] Robocode Tutorial - Part 01. Disponível em:
<https://www.youtube.com/watch?v=QQfSnrt5myA> Acesso em 02/12/2019.




