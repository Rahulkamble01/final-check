FROM tomcat:8.5.37-jre8
COPY ./angular/articlesearch/dist/articlesearch/. /usr/local/tomcat/webapps/articlesearchui
COPY ./service/target/articlesearch.war /usr/local/tomcat/webapps
