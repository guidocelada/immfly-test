# RUN PROJECT
```
mvn clean package
docker-compose up
```
# CHECK IF IT WORKS
```
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMiwiZXhwIjoxODkzNDU2MDAwLCJzY29wZSI6WyJBRE1JTiJdfQ.hG5b6nwwWtVyPxKgvXSLQhVqGHxScWW-AK_rE65vQe19TAg9B7BIe_-NrDSSAaLcMi7kLsFZu5ekSCrn9xIV5tOXBAXUQQ7yGaFoo9wPI_tP0VU-JiXmvmMtlTPo-jAJHPhZ6u2SwJXlKXhxTEiGQt6eBDaWheJ3pGyhSg7PTP7WLoXxt5TMvnIYbNkS6Jy7I3iapDI32Fw2U-ZkuFvhN5Ch65ZDvGN_1S1eOzKGUYw55wm63nM65ws7k5QS1fIpCRggoFr9CN4vsA2lJ29L3-lxXwT1vkbd8S9NOxcNc2dUC1-s1ip68d5uNPs-0i3JkC_JfHrAsmv6JUfRyAbBTA" http://localhost:8080/v1/flight-information/EC-MYT/653
```

# DEVELOP
Run external services and then debug the Java app in your IDE.
```
docker-compose up wiremock redis
```

readme# BUILD DOCKER IMAGE AGAIN
```
docker-compose build immfly-flights
```
