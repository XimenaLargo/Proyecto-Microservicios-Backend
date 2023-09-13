# ExamenParcial
Examen parcial de la materia Especialización Backend I


## Integrantes
- Milene Arce
- Ximena Largo

### ✨ Resiliencia - Resilence4j

Cuando se llama al metodo   *getAllByGenre()*   dentro del servicio de catalog-service este hace el llamado a través de Feign hacía los microservicios de serie-service y movie-service para listar las peliculas y series guardadas dentro de estos microservicios, en caso de que haya alguna falla, el circuit breaker entrará en acción e intentara conectarse al servicio a espera de que este responda, si esto no funciona se ejecutara el metodo  *getCatalogFallbackValue()*  el cuál hará una consulta a la base de datos de catalog-service y listara las series y peliculas que este posea.

<img src="https://raw.githubusercontent.com/XimenaLargo96/XimenaLargo96/1c1b2064d3b7830b64de820f9dd2c7c37302714a/publicImages/circuitbreaker.PNG" />

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
