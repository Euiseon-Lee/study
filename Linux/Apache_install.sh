# 압축파일 푸는 코드 (위치: /LCA/tmp/lib)
mkdir /LCA/tmp/lib
mv *.tar.gz /LCA/tmp/lib
cd /LCA/tmp/lib
tar -xzvf m4-1.4.19.tar.gz
tar -xzvf autoconf-2.71.tar.gz
tar -xzvf automake-1.16.tar.gz
tar -xzvf apr-1.7.0.tar.gz
tar -xzvf apr-util-1.6.1.tar.gz
tar -xzvf pcre2-10.37.tar.gz
tar -xzvf httpd-2.4.54.tar.gz

mkdir /LCA/tmp/tar
mv *.tar.gz /LCA/tmp/tar

# 의존성 파일인 gcc 설치
yum groupinstall "Development tools"



# 압축파일 순서대로 설치
# m4
cd /LCA/tmp/lib/m4-1.4.19
./configure --prefix=/usr
if [[ "$?" -ne 0 ]]
then exit;
else
	make && make install
fi 

#autoconf
cd /LCA/tmp/lib/autoconf-2.71
./configure --prefix=/usr
if [[ "$?" -ne 0 ]]
then exit;
else
	make && make install
fi

#automake
cd /LCA/tmp/lib/automake-1.16
./configure --prefix=/usr
if [[ "$?" -ne 0 ]]
then exit;
else
	make && make install
fi

#apr
cd /LCA/tmp/lib/apr-1.7.0
yum install expat-devel             #expat.hat 파일 설치
./configure --prefix=/usr/local/src/apr-1.7.0
if [[ "$?" -ne 0 ]]
then exit;
else
	make && make install
fi

#apr-util
cd /LCA/tmp/lib/apr-util-1.6.1
./configure --prefix=/usr/local/src/apr-util-1.6.1 --with-apr=/usr/local/src/apr-1.7.0
if [[ "$?" -ne 0 ]]
then exit;
else
	make && make install
fi

#pcre
cd /LCA/tmp/lib/pcre2-10.37
yum install pcre-devel -y           #pcre 의존성 설치
./configure --prefix=/usr/local/src/pcre2-10.37 --with-apr=/usr/local/src/apr-1.7.0 --with-apr=/usr/local/src/apr-util-1.6.1
if [[ "$?" -ne 0 ]]
then exit;
else
	make && make install
fi

#httpd
cd /LCA/tmp/lib/httpd-2.4.54
./configure --prefix=/usr/local/apache --enable-modules=most --enable-mods-shared=all --enable-so --with-apr=/usr/local/src/apr-1.7.0 --with-apr-util=/usr/local/src/apr-util-1.6.1
if [[ "$?" -ne 0 ]]
then exit;
else
	make && make install
fi




#-------------------------------------------------------------
#/usr/local/src에 들어가서 설치파일이 제대로 설치되었는지 확인
cd /usr/local/src | ll

#/usr/local에 들어가서 apache 설치가 되었는지 확인
cd /usr/local | ll | grep apache

#Apache 설정 바꾸기
vi /usr/local/apache/conf/httpd.conf
/ServerName www.example.com:80\
yy | p | cc
ServerName 127.0.0.1:80
esc
wq!

#Apache 실행코드
/usr/local/apache/bin/httpd -k start

#port 확인 및 방화벽 open 
#tcp6 :::80으로 httpd 열려있는지 확인
#netstat command 설치 == yum -y install net-tools
netstat -tulpn | grep LISTEN

#포트 80 번 방화벽 개방
#예상결과: success -> success -> 80/tcp
firewall-cmd --permanent --zone=public --add-port=80/tcp
firewall-cmd --reload
firewall-cmd --list-ports

#서비스 작동여부 확인 및 작동시키기 -> 수동설치 시 
#systemctl list-unit-files | grep httpd
#systemctl enable httpd


#ifconfig로 ip 확인하여 http://IP:80/ 실행
