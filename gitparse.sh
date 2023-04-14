#!/bin/bash
function timeRegression {
    exit
}
#checkout the commit, run thing, checkout main.
log="regression_git.log"
#holds the line number of distinct commit dates
arr=$(grep -n "Date" $log | sed "s@:.*@@")
index=0
month="Apr"
for i in $arr
do
    commit_date=$(sed -n ${i}p $log)
    ((index++))
    if !((index%5)); then
        #extract commit id
        commitid=$(sed -n $((i-2))p $log | awk '{print $2}')
        git checkout $commitid
        echo $commit_date >> logger
        sleep 5
        git checkout master
    fi
done