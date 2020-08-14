### How this project is consist ###

* Spring-Boot
* H2 database
* jOOQ

### How do I build it up? ###

* In Maven
```bash
$ mvn clean package -e -X
```
* To make docker image
```bash
$ docker build --build-arg JAR_FILE=target/{package_file_name} -t {docker_image_name} .
```
* To execute the docker container
```bash
$ docker run -p 8080:8080 {docker_image_name}
```

### How to connect RexRay Volumn

* Install RexRay plugin in docker 
```bash
$ docker plugin install rexray/s3fs S3FS_ACCESSKEY={value} --grant-all-permissions
```

* To execute the docker container and connect rexray
```bash
$ docker run -d -p 8080:8080 -v {S3FS_bucket_name}:/{mounted_path_name} {docker_image_name}
```

[reference - markdown](https://heropy.blog/2017/09/30/markdown/)
