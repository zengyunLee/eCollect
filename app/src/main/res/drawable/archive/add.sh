#!/bin/bash
#脚本自动将目录下的文件require
postfix="this.rootDir.set('"
suffix=".png));"
function getdir(){
    for file in $1
    do
    if test -f $file
    then
        echo ${postfix}"require("$file${suffix} >> temp
    else
        postfix="this."${file}".set('"
        getdir $file
    fi
    done
}

#if test -f "temp"
#then
#    rm temp
#fi

getdir .
