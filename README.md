# domo-metabase-viewer

A proof of concept Spring Boot application that displays dashboards from the DOMO metabase server. Secured by the showcase realm Keycloak.

https://www.baeldung.com/spring-boot-keycloak

https://developers.redhat.com/blog/2017/05/25/easily-secure-your-spring-boot-applications-with-keycloak/

## DRAFT deployment steps
Doing things manually to test out in OpenShift, this will evolve as we pipeline this application.

oc new-app redhat-openjdk18-openshift~https://github.com/loneil/domo-metabase-viewer