#!/bin/bash

start_location=""
end_location=""
result_file=""
file_cnt=""
home="/home/yes"

echo "---- 작업 시작 ----"
echo "[출발지 전체 경로명]을 입력하세요."
read start_location
echo

until [[ ${start_location} =~ ${home} ]]
do
	echo "[경고]출발지 경로를 자신의 홈 경로로 입력해주세요"
	echo "[출발지 전체 경로명]을 다시 입력하세요"
	read start_location
done
	if test -d ${start_location}; then
		echo "이미 존재하는 디렉토리를 출발지 경로로 설정하였습니다"
	else
		dir_name=${start_location:10}
		mkdir ${dir_name}
		echo "신규 출발지 디렉토리가 생성되었습니다"
	fi


echo "[도착지 전체 경로명]을 입력하세요."
read end_location
echo

until [[ ${end_location} =~ ${home} ]]
do
	echo "[경고]도착지 경로를 자신의 홈 경로로 입력해주세요"
	echo "[도착지 전체 경로명]을 다시 입력하세요"
	read end_location
done
	if test -d ${end_location}; then
		echo "이미 존재하는 디렉토리를 도착지 경로로 설정하였습니다"
	else
		dir_name=${end_location:10}
		mkdir ${end_location}
		echo "신규 도착지 디렉토리가 생성되었습니다"
	fi

echo "[결과 파일명]을 입력하세요."
read result_file
echo
echo "[생성파일 갯수]를 입력하세요."
read file_cnt

for (( i = 1; i <= ${file_cnt}; i++))
do
	touch ${start_location}/work${i}.log
	echo "${start_location}/work${i}.log 이 생성되었습니다."
done
	echo
	echo "총 ${file_cnt}개의 파일 생성이 완료되었습니다"
	sleep 1
	echo


echo "압축을 진행합니다."
	tar_file=${start_location:10}.tar.gz
	tar -zcvf ${tar_file} ${start_location:10}
echo "${tar_file} 이 생성되었습니다."
echo


	mv ${tar_file} ${end_location}
echo "파일을 이동하였습니다"
echo "${end_location}/${tar_file}"
echo

#find -name ${tar_file}
#sleep 10

	tar -zxvf ${end_location}/${tar_file} -C ${end_location} 
echo "${tar_file} 파일이 압축 해제되었습니다."
echo


	rm -rf ${end_location}/${tar_file}
echo "${tar_file} 파일을 삭제하였습니다."
echo


	ls -al ${start_location} > ${end_location}/${result_file}
echo "복사한 파일 목록 파일을 생성하였습니다."
echo "${end_location}/${result_file}"
echo "---- 작업 종료 ----"

