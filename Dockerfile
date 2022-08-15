# podaje obraz bazowy, który będzie służył jako podstawa
# jako przykłądowy obraz podaje eclispe-temurin pobrany z docker hub
# wybieram wersję 18-alpine
FROM eclipse-temurin:18-alpine
# wybieram plika jaki mazostać umieszcony w kontenerze
ADD target/GetFamily-0.0.1-SNAPSHOT.jar .
# podaje port na jakim aplikacja będzie dostępna
EXPOSE 8787
# komenda do uruchomienia obrazu
CMD java -jar GetFamily-0.0.1-SNAPSHOT.jar

# komenda do zbudowania obrazu
#=============   docker build -f Dockerfile -t getfamily:getrestv1 .   ==============
#=============   komenda do uruchomienia docker run -d -p 8787:8080 <idrepository>