#ls -l /usr/bbin > number.txt 2>& error.txt
#
#a="Hello"
#b="hello"
#if [ "$a" == "$b" ]
#then
#	echo "a is equal to b"
#else
#	echo "a is not equal to b"
#fi
#
#
#a="Hello"
#b="Holly"
#if [[ "$a" < "b" ]]
#then
#	echo "a is less than b"
#else
#	echo "a might be equal to b or greater than b"
#fi
#
#
#cnt=0
#while (( "${cnt}" < 5 )); do
#	echo "${cnt}"
#	(( cnt = ${cnt} + 1 ))
#done


arr=(1 2 3 4 5 6 7)

for i in ${arr[@]}; do
	echo $i
done
echo

for (( i = 0; i < 10, i++)); do
	echo $i
done
echo
