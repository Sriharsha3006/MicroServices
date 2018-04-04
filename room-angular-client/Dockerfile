FROM node:6
COPY package.json
RUN npm cache clean
RUN npm install
COPY . 
EXPOSE 8808
CMD ["npm","start"]