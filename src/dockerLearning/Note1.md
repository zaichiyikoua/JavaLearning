### docker的安装和配置
#### 基础情况:我自己的虚拟机用的是VMware，linux是centOS7.0 64位

#### 1.首先，如果已经安装过docker，则需要卸载原来的老版本docker
#### 2.安装需要的软件包， yum-util 提供yum-config-manager功能，另外两个是devicemapper驱动依赖的
#### 2.1 sudo yum install -y yum-utils device-mapper-persistent-data lvm2
#### 3.设置yum源，安装stable仓库(这个是必须的)
#### 3.1 sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
#### 4.安装docker
#### 4.1 sudo yum install -y docker-ce
#### 5.启动并加入开机启动
#### 5.1 sudo systemctl start docker
#### 5.2 sudo systemctl enable docker
#### 6.验证安装是否成功(有client和service两部分表示docker安装启动都成功了)
#### 6.1 docker version