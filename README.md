# ExamenParcial
Examen parcial de la materia Especialización Backend I


## Integrantes
- Milene Arce
- Ximena Largo

### ✨ Resiliencia - Resilence4j

Cuando se llama al metodo   *getAllByGenre()*  dentro del servicio de catalog-service, este hace una consulta a su base de datos no relacional. Si algo falla, se activa el circuit breaker e intenta hacer 5 llamados y si tres de ellos fallan, pasa a estado open 
y en el siguiente llamado hace una petición a través de Feign a los microservicios de movie-service y serie-service.

<img src="https://raw.githubusercontent.com/XimenaLargo96/XimenaLargo96/main/publicImages/resilience.jpeg" />

### 🚀 Screeshots del dashboard de zipkin

<img src="https://raw.githubusercontent.com/XimenaLargo96/XimenaLargo96/main/publicImages/zipkin-dashboard.PNG" />
<img src="https://raw.githubusercontent.com/XimenaLargo96/XimenaLargo96/main/publicImages/captura-zipkin-dependecies.PNG" />

### ✨ Screenshots de los test realizados

- Respuesta de la APi al crear una película desde catalog-service
<img src="https://raw.githubusercontent.com/XimenaLargo96/XimenaLargo96/main/publicImages/Creacion-pelicula.PNG" />

- Respuesta de la api al listar peliculas desde catalog-service
<img src="https://raw.githubusercontent.com/XimenaLargo96/XimenaLargo96/main/publicImages/listar-peliculas.PNG" />

- Confirmación de respuesta del load balancer random
<img src="https://raw.githubusercontent.com/XimenaLargo96/XimenaLargo96/main/publicImages/loadbalancer.PNG" />

- Comprobación de funcionamiento del gateway
<img src="https://raw.githubusercontent.com/XimenaLargo96/XimenaLargo96/main/publicImages/gateway.PNG" />
