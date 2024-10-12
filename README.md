# RabbitMQ
para acessar o rabbitMq acesse http://localhost:15672/

## O que foi necessário para usare eviar umamensagem no rabbitMQ

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-amqp</artifactId>
<version>3.3.4</version>
</dependency>

<dependency>
<groupId>com.fasterxml.jackson.core</groupId>
<artifactId>jackson-databind</artifactId>
</dependency>

Na sua classe de configuração do rabbitMQ adicione o metodo rabbitTemplate e dentro dele use o jsonMessageConverter 
para converter as mensagens

# H2
para acessar o banco de dados http://localhost:1234/h2-console aonde 1234 é a porta da aplicação
na JDBC URL fique atento para usar igual esta no seu aplicatio.yml jdbc:h2:mem:testdb

# Docker
docker compose up -d, verifique o que esta sendo criado no docker 


