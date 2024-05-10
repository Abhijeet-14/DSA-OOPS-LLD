# **DOCKER**

**Container - an isolated env for running app.**

VS

**VM** - an abstraction of a machine (Physical hardware)

* VM1 - (APP-1), node 14, mongo 4
* VM2 - APP 2, node 9, mongo 6

* these 2 are isolated but it uses system OS, so it's check os licence & slow to start

**Container:**

- allow running multiple apps in isolation
- lightweight
- Use OS of the host
- start quick
- need less hardware memory

**Docker Architechure:**

* client ---REST API---> Docker Engine

**INSTALL:**

- https://docs.docker.com/get-docker
- SYSTEM REQ: goto windows features
- turn on hyper-v and container
- at end of install: wsl2 installation is incomplete
- click the link -> download latest linux kernel (wsl2 package)
- install done
- $ docker version
- u'll see client & server,
- if not seeing server, that means remote connection error or some issue

---

# Development Workflow:

**IMAGES AND CONTAINERS:**

- **Image**: it is a snapshot of complete environment

  - it is helpful to jump between various version of a app, just by changing the image.
  - it contains everythng related to that version/image (os, software, app code)
- **Container**: running instance of an image

  - goto  https://hub.docker.com [simply a registry like npm]-> where you will see all public images.
  - to pull any of them in our docker system -> docker pull <image_name>
  - docker run node:latest
  - docker pull nginx [nginx is web server, reverse proxy, load balancer etc]
  - download newer image nginx:latest, "latest" is a tag
  - to check run $ docker images
  - $ docker run nginx:latest
  - $ docker container ls or $ docker ps [to check whether container is running or not ]
  - to run in detach mode -> $ docker run -d nginx:latest
  - to STOP container -> $ docker stop <container_id>

**EXPOSING PORT of NGINX:**

to run nginx server -> $ docker run -d -p 8080:80 nginx:latest

it transfer all the req to port 8080 to port 80 inside in container

[multiple port] -> $ docker run -d -p 8080:80 -p 3000:80 nginx:latest

**MANAGING CONTAINER:**

docker stop <container_name / container _id>

docker ps [list only running container]

docker ps -a [all container]

docker rm <container_id / container_name> [DELETE CONTAINER]

docker ps -q [only up container_id]

docker ps -aq [all container_id]

docker rm $(docker ps -aq) [to delete all container]

docker rm -f <container_id> [FORCE DELETE]

**NAME CONTAINER:**

docker run --name website-container  -d -p 3000:80 nginx:latest

docker start website-container

[ps with FORMATTING] docker ps -a --format "CONTAINER_ID: {{.ID}}\nNAME: {{ .Names}}\nIMAGE: {{.Image}}\nSTATUS: {{.Status}}\nPORTS: {{.Ports}}\nCREATED: {{.CreatedAt}}\nCOMMAND: {{.Command}}\n\n"

save format style to variable ->

$ export My_Format="CONTAINER_ID: {{.ID}}\nNAME: {{ .Names}}\nIMAGE: {{.Image}}\nSTATUS: {{.Status}}\nPORTS: {{.Ports}}\nCREATED: {{.CreatedAt}}\nCOMMAND: {{.Command}}\n\n"   [bash]

$ set My_Format = ... [CMD]

docker ps --format=$My_Format [bash]

docker ps --format=%My_Format% [cmd]

**DOCKER VOLUMES:**

Allow sharing Data[files, folders]

b/w HOST & CONTAINER

b/w CONTAINERS

if we add files to host -> it will be also present in actual container -> VICE-VERSA

add files in folder of container

**VOLUME B/W HOST & CONTAINER:**

 goto a directory

$ docker run --name `<custom-container-name>` -v `<your-directory>`:/usr/share/nginx/html:ro -d nginx

instead of your-directory -> we can give current working directory -> $(pwd)

ro:  READ ONLY, by this we can only read the content of the host.

to get HOST directory:

docker exec -it `<contatiner-name>` bash

now you can access -> try -> ls -a

but if you try -> touch about.html -> can't touch -> bcoz READ ONLY

exit from host -> exit

[READ n WRITE]: $ docker run --name `<custom-container-name>` -v `<your-directory>`:/usr/share/nginx/html -d nginx

**VOLUME B/W CONTAINER & CONTAINER:**

$ docker run --name `<new-container-name>` --volumes-from `<current-container>` -d -p 8080:80  nginx

---

## DOCKERFILE:

**CREATE DOCKERFIE**

    -  while building custom image -> we don't need to mount from HOST to ACTUAL CONTAINER

    - create custom image

    - create a file root folder -> Dockerfile -> no extension

    - we always build own-image in reference of existing some image

    - inside Dockerfile ->

    FROM  nginx:latest

    ADD  .  usr/share/nginx/html

**DOCKER BUILD:**

    - $ docker build --tag`<image-name>`:latest  `<docker-file-diretory>`

    - for current working directory -> use dot [.] instead of docker-file-directory

    - [create container inside custom image]  => $ docker run --name`<contianer-name>` -p 8080:80 -d `<custom-image>`:latest

**NODE-JS and EXPRESS-JS**

install nodejs

create a simple app

create Dockerfile ->

    FROM node:latest

    WORKDIR /app [it will create folder '/app' -> and run all below command of inside /app]

    ADD  .  . [2nd dot means -> it will save in /app directory]

    RUN npm install

    CMD node index.js

**DOCKER-IGNORE**

- there's certain file which we should ignore in our image e.g., node_modules
- create .dockerignore
- add node_modules & Dockerfile
- we don't need Dockerfile in our image
- now re-build image

  - docker build -t <image_name>:latest  .

**CACHING AND LAYERS:**

- while re-building the image -> we see that ->
- we're mostly changing source-code
- but we're installing the package again and agian
- to prevent this we do caching
- Generalyy docker run all lines below changed line..
- so we will keep the RUN npm install above ADD  .  .
- npm install won't run if ONLY source code will change
- if package.json will change then only npm install will run
