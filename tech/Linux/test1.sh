ECHO="/usr/bin/echo"
RM="/usr/bin/rm"
READ="/usr/bin/read"

PWD1=`pwd`
PWD2=pwd
${ECHO} "PWD1=${PWD1}"
${ECHO} "PWD2=${PWD2}"

${ECHO} TEST

#rm /home/yes/yes.txt
#echo "delete ok"

#${READ} HOURS
read HOURS
#/usr/bin/read HOURS

${ECHO} "hour=${HOURS}"
