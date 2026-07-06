#Set the base image
FROM docker.io/node:18-alpine

#Set the working directory
WORKDIR /usr/app
#WORKDIR will do the following commands:
#mkdir /usr/app -p
#cd /usr/app

#Copy the package.json to the container
COPY ./package.json ./

#Install the dependencies
RUN npm install

#Copy the remaining files into the container
COPY ./ ./

#Command to start the node server
CMD ["npm", "run", "start"]