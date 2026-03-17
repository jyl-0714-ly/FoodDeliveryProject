
# 智享外卖平台

一款基于 Spring Boot 的全栈外卖服务平台，采用前后端分离架构。系统包含管理端与用户端，涵盖从菜品浏览、购物车结算到订单全生命周期管理的核心业务流程。


## 技术栈


后端：Spring Boot + SSM

数据库：MySQL, Redis

中间件：阿里云 OSS, HttpClient, JWT"

工具,"Maven, Git, Swagger / Knife4j"
## Mac开发环境搭建

1.安装JDK8

2.通过Homebrew安装MySQL、Redis、Maven、Nginx
     
①利用DataGrip创建MySQL数据库和表sky.sql
    
②Nginx在终端配置.conf

```
http{
    map $http_upgrade $connection_upgrade{
                default upgrade;
                '' close;
        }

        upstream webservers{
          server 127.0.0.1:8080 weight=90 ;
          #server 127.0.0.1:8088 weight=10 ;
        }
    server {
        listen       8888;
        server_name  localhost;

        #access_log  logs/host.access.log  main;

        location / {
            root   /Users/admin/Desktop/FoodDeliveryProject/sky;
            index  index.html index.htm;
            try_files $uri $uri/ /index.html;
        }

        location /api/ {
        proxy_pass http://localhost:8080/admin/;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_method $request_method;
    }

        location /user/ {
        proxy_pass http://localhost:8080/user/;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    }

        location /ws/ {
        proxy_pass http://webservers;
        proxy_http_version 1.1;
        proxy_read_timeout 3600s;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection $connection_upgrade;
        proxy_set_header Host $host;
     }
     }
}
```
