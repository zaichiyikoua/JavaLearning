### DOCKER镜像常用命令
#### 1.搜索镜像: docker search {options}
##### 1.1 示例: docker search java，执行该命令会在dockerHub中去搜索含有java这个关键字的镜像仓库

#### 2.下载镜像: docker pull {options}
##### 2.1 示例: docker pull java，执行之后会下载最新版本的java镜像

#### 3.删除本地镜像: docker rmi {options}
##### 3.1 示例: docker rmi hello-world (删除指定镜像)
##### 3.2 示例: docker rmi -f ${docker images} (删除所有镜像)

#### 4.保存镜像: docker save {options} 
##### 4.1  示例: docker save java

#### 5.加载镜像: docker load {options}
##### 5.1 示例: docker load < busybox.tar

#### 6.构建镜像: docker build {options}
##### 6.1 示例: docker build -t itmuch/some-repo:some-tag