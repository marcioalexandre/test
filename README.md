# Marcio test

This project uses Quarkus, the Supersonic Subatomic Java Framework.
Non-official project regarding a challenge sent by Truphone.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

### If necessary, install kafka dependecy
$ mvn quarkus:add-extension -Dextensions="quarkus-smallrye-reactive-messaging-kafka"

### To Create Kafka/Topics and Postgres infrastructure
$ docker compose -f docker-compose-kafka.yaml up -d
$ docker compose -f docker-compose-postgres.yaml up -d


# Author:
Marcio Alexandre Silva
marcio.alexandre83@gmail.com

Last update in this file: Aug, 18th.
