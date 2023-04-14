#!/bin/bash
# $1: commit ID
# $2: date string
# $3: log file to write statistics to
# $4: command to TIME
# $5: number of times to run the command

commit=$1
date=$2
log=$3
command=$4
n=$5

git checkout $commit
echo $date >> $log
echo commit id: $commit >> $log
>>log

for ((i=1;i<=$2;i++)) do
    { time $4; }  2>> $log 1>> /dev/null
done

exit



