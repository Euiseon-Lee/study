arr[0]="hello"
arr[1]="some text"
arr[2]="/home/linux_edu/tech"

echo "${arr[0]}"
echo "${arr[1]}"
echo "${arr[2]}"

echo ${arr}
echo ${arr[*]}

echo ${#arr[*]}
echo ${#arr[@]}


nrr[0]=100
nrr[1]=50
let nrr[2]=nrr[0]+nrr[1]
echo ${nrr[2]}


typeset -u ${arr[0]}
echo ${arr[0]}

typeset -u x="hello"
echo $x

i=0
for item in ${arr[*]}
do 
	echo "arr[${i}]=${item}"
	let i=i+1
done
