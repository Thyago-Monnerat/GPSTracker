
# 📌 GPS Tracking 

## Sistema de monitoramento de gps feito com Kafka + Websocket

### Geral:
* GPS mockado, enviando um trajeto fixo e fazendo requisições POST atualizando a posição
* Kafka com zookeeper para receber as atualizações
* Kafka Producer para receber a requisição POST e enviar para o Kafka
* Kafka Consumer para ouvir nos tópicos do Kafka, e postar no Websocket
* Frontend para consumir o Websocket do Kafka Consumer e atualizar a interface gráfica
---

### Instruções
* Na pasta raiz, utilize docker-compose para subir os containers, o frontend deve estar disponível no endereço localhost:80.
* O GPS mockado não está no docker, ele precisa ser iniciado manualmente em um JRE.
* O GPS utiliza o Feign para fazer requisições Http.
* Assim que o GPS mockado for iniciado, será pedido para digitar 'y' no terminal.
* Com o 'y' validado, será enviado trajeto fixo para o kafkaProducer via Http POST. utilizei as coordenadas do aeroporto Santos Dumont - RJ (origem) e aeroporto de Congonhas - SP (destino). Essas informações estão mockadas apenas para simular um vôo, por exemplo.
* O GPS possui uma lógica de, a cada 5 segundos, ele calcula 1% do trajeto em linha reta fazendo a interpolação linear das coordenadas. A fórmula usada foi: P = A + (B-A) * t. Onde A é a coordenada de origem, B a coordenada de destino e t é a porcentagem, nesse caso.
* A lógica do GPS mockado:
    ```
    
    public void startTravel(TravelDTO travelDTO) throws InterruptedException {
        gpsClient.sendCoords(travelDTO);

        //Tracking
        double initLat = travelDTO.getInitCoords().getLat();
        double initLon = travelDTO.getInitCoords().getLon();
        double endLat = travelDTO.getFinalCoords().getLat();
        double endLon = travelDTO.getFinalCoords().getLon();

        double percentage = 0.01;

        double calcLat1Percentage = initLat;
        double calcLon1Percentage = initLon;

        for (; percentage < 1.00; percentage += 0.01) {
            gpsClient.sendTracking(new LocalCoordsDTO(calcLat1Percentage, calcLon1Percentage));

            calcLat1Percentage = initLat + (endLat - initLat) * percentage;
            calcLon1Percentage = initLon + (endLon - initLon) * percentage;

            Thread.sleep(5000);
        }
    ```
---
### Fluxo
!["Fluxo do sistema"]("./gpsFlow.png")