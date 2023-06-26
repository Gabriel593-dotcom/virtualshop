#!/bin/bash

BASE_PATH=/home/gab/java_projects/virtual-shop
MS_EUREKA_SERVER_PATH=$BASE_PATH/ms-eureka-server
MS_API_GATEWAY_PATH=$BASE_PATH/ms-api-gateway-zuul
MS_SALE_PATH=$BASE_PATH/ms-sale
MS_PRODUCT_PATH=$BASE_PATH/ms-product
SERVICES_LIST=($MS_EUREKA_SERVER_PATH $MS_API_GATEWAY_PATH $MS_SALE_PATH $MS_PRODUCT_PATH)
run='mvn spring-boot:run -X'

for service in ${SERVICES_LIST[@]}; do   
    echo "SERVIÇO>>>>> $service"
    cd $service
    gnome-terminal -x bash -c "$run; exec $SHELL";
done
