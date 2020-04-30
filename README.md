# password.api.iti

## About

This application allow us to:
- **validatePassword** based on some rules;

#### Was built using:
- Scala 2.13.1
- Sbt 1.13.10
- Akka 2.6.4
    - AkkaHttp 10.1.11
- Circe 0.12.3

#### Structure
- main
    - contracts
    - controllers
    - rejection
    - utils
    - validators
- test

## Running

Running application on background(`-d`)

    docker-compose up -d

The **application** will running on port `9001`

#### Interact

    curl -d '{"password":"value1"}' -H "Content-Type: application/json" -X POST http://localhost:9001/validatePassword


## Testing

    docker-compose run --rm passwordvalidation_api sbt test
