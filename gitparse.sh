#!/bin/bash
#checkout the commit, run thing, checkout main.
log="regression_git.log"
#holds the line number of distinct commit dates
arr=$(grep -n "Date" $log | sed "s@:.*@@")
index=0
month="Apr"
for i in $arr
do
    month=$(sed -n ${i}p $log)
    echo $month
    ((index++))
    if !((index%5)); then
        commitid=$(sed -n $((i-2))p $log | awk '{print $2}')
        #commitid=$(awk -v 'n=$((i-2))' '{if(NR==n) print $2}' $log)
       # commitid=$(awk -v n="$((i-2))" "{if(NR==n) print }" $log | echo '$(awk '{$1=$1};1')' | awk "{print $1}" | awk "{print $1}")
        #commitid=$(awk -v n="$((i-2))" "{if(NR==n) print }" $log | awk '{print $2}')
        git checkout $commitid
        sleep 10
        git checkout master
        echo $((i-2))
        echo $commitid
        echo $index
    fi
done