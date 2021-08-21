To run the application on Docker, run the following lines in your CMD:

docker build -t bottomline/autocomplete:1.0-SNAPSHOT .
docker run -d -p 9090:9090 bottomline/autocomplete:1.0-SNAPSHOT

To receive a list of possible names given a name prefix, run the next line in the URL:

localhost:9090/getNames?prefix={ write your prefix here } 

Change the "{ write your prefix here }" section to the prefix of your choosing.