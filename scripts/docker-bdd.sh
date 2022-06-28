#!/bin/bash

#Verifiction docker installer

cd ..
echo $PWD
OUTPUT=($(docker --version))
PATH="$PWD/Code/bddpoker.sql"
if [[ "$OUTPUT" == *"Docker"* ]];
then
	
DOCKER_BDD="docker run -d --name some-mysql -p 3306:3306 -e MYSQL_DATABASE=pokerdb -e MYSQL_ROOT_PASSWORD=ydvwnj3 -v ${PATH}:/docker-entrypoint-initdb.d/init.sql mysql:oracle"

$DOCKER_BDD

else 
	echo "Vous n'avez pas docker d'intallé..."
fi

