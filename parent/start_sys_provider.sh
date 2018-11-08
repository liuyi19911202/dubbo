#!/bin/sh
. /etc/profile
export LANG=zh_CN.UTF-8

pid=`ps aux | grep 'system-provider' | grep -v grep | awk '{print $2}'`
if [ "${pid}" != "" ]
then
  `kill -9 ${pid}`
fi

java -jar ./system/system-provider/target/system-provider.jar &

  