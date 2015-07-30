read num
count=0

for (( i=0; i<$num; i++ )) 
do
    read next
    let "count += next"
done

printf "%.3f \n" $(echo "$count / $num" | bc -l)
