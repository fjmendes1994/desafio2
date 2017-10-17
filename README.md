# Desafio 2 - STI - Trabalhe-Conosco


## Especificações em que o projeto foi desenvolvido e testado


### $ java -version
```
openjdk version "1.8.0_141"
OpenJDK Runtime Environment (build 1.8.0_141-8u141-b15-1~deb9u1-b15)
OpenJDK 64-Bit Server VM (build 25.141-b15, mixed mode)
```
### $ gradle -v
```
------------------------------------------------------------
Gradle 3.2.1
------------------------------------------------------------

Build time:   2012-12-21 00:00:00 UTC
Revision:     none

Groovy:       2.4.8
Ant:          Apache Ant(TM) version 1.9.9 compiled on March 1 2017
JVM:          1.8.0_141 (Oracle Corporation 25.141-b15)
OS:           Linux 4.9.0-4-amd64 amd64
```

### Para rodar, entre no diretorio do projeto e rode o seguinte comando :
```
$ gradle bootRun
```

### Instruções de uso(com o projeto rodando) :

1. Acesse o site http://www.mapcoordinates.net/
    1. Coloque o endereço que deseja consultar os bicicletarios proximos no campo "Show Location".
    1. Aperte "Enter"
    1. Copie os valores de Latitude e Longitude que irão aparecer no mapa.
  
1. Com o projeto rodando acesse o seguinte link em seu navegador http://localhost:8080/estacao?lati="LATITUDE_AQUI"&longi="LONGITUDE_AQUI"
    1. Subistitua o campo "LATITUDE_AQUI" pelo valor da latitude obtido no http://www.mapcoordinates.net/
    1. Subistitua o campo "LONGITUDE_AQUI" pelo valor da longitude obtido no http://www.mapcoordinates.net/

1. Em seguida deverá aparecer a listagem das estaçoes mais proximas.
