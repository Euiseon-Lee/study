a=100
b=200
c=300


let d=a+b
echo "d="$d



let d=$a+$b+100
echo "d="$d


e=$(($a+$b))
echo "e="$e


f=`expr $a + $b`
echo "f="$f
