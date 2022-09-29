#tomcat 설치
tar -xzvf PCM_SETUP_T8_5_81_nile_was_P14_4_for_Rocky8.5_20220728.tar.gz PCM_SETUP/
mv PCM_SETUP ../lib
cd ../lib/PCM_SETUP/
sh INSTALL_TOMCAT_8.5.81.sh
cd /LCA/LCM/webapps/ROOT/
cp index.jsp index.jsp.backup


#index 파일 수정하기
vi index.jsp


#apache - tomcat 연동
yum install gcc gcc-c++ httpd-devel

tar -xzvf tomcat-connectors-1.2.48-src.tar.gz
mv tomcat-connectors-1.2.48-src/ ../lib
cd /LCA/tmp/lib/tomcat-connectors-1.2.48-src/native/
#which apxs 
#./configure --with-apxs=/usr/bin/apxs
./configure --with-apxs=/usr/local/apache/bin/apxs
make && make install


#설치 확인 – 경로 : /usr/local/apache/modules/mod_jk.so 파일
grep mod_jk.so


#SELinux 보안관련 설정 변경
chcon -u system_u -r object_r -t httpd_modules_t /usr/local/apache/modules/mod_jk.so


#기존 파일: 설정 값 추가
cd /usr/local/apache/conf/
vi httpd.conf

	# jk_module ID를 가진 설정 값을 mod_jk.so 모듈에 적용
	LoadModule jk_module modules/mod_jk.so
	# conf/extra/httpd-jk.conf 설정 파일도 추가 
	Include conf/extra/httpd-jk.conf



#새로운 파일 생성: httpd.conf 에서 LoadModule 로 추가한 jk_module의 설정 값을 추가
vi /usr/local/apache/conf/extra/httpd-jk.conf

	<IfModule jk_module>   # jk_module 은 id 값임
	JkWorkersFile conf/extra/workers.properties
	JkShmFile logs/mod_jk.shm
	JkLogFile logs/mod_jk.log
	#error, warn, info, debug, trace
	JkLogLevel info
	JkLogStampFormat "[%y %m %d %H:%M:%S]"
	JkRequestLogFormat "%w %V %T"
	JkOptions +ForwardKeySize +ForwardURICompat -ForwardDirectories
	JkMountFile conf/extra/uriworkermap.properties
	</IfModule>


#새로운 파일 생성: mod_jk 설정 (httpd-jk.conf 파일에서 설정했던 JkWorkersFile의 파일을 작성)
vi /usr/local/apache/conf/extra/workers.properties

	# 실행시킬 was(tomcat) 리스트를 작성하며 우리는 was가 하나이기 때문에 하나만 등록(ID는 맘대로 부여 가능)
	worker.list=wk_tomcat   
	worker.wk_tomcat.host=localhost
	#worker.wk_tomcat.host=127.0.0.1
	worker.wk_tomcat.port=8009
	worker.wk_tomcat.type=ajp13
	worker.wk_tomcat.lbfactor=1

#TOMCAT 설정 확인
vi /usr/share/tomcat/conf/server.xml

	#필요에 따라 설정 값이 달라질 수 있으며 workers.properties 에서 설정한 port 와 type 만 동일하게 맞추면 됨
	<Connector protocol="AJP/1.3“ address="::1" port="8009" redirectPort="8443" enableLookups="false" secretRequired="false" />


#기존 파일: mod_jk 설정 -> httpd-jk.conf파일에서 설정했던 JkMountFile 파일을 작성
# 웹 접속 시 페이지 처리 주체를 설정
vi /usr/local/apache/conf/extra/uriworkermap.properties

	# 아래 접속에 대해서는 tomcat 이 처리
	JkMount /*=wk_tomcat
	JkMount /*.jsp=wk_tomcat
	JkMount /*.json=wk_tomcat
	JkMount /*.xml=wk_tomcat
	JkMount /*.do=wk_tomcat

	# tomcat 이 처리하는 목록에서 제외 (web server가 처리하도록 함)
	!/=wk_tomcat
	!/*.htm=wk_tomcat
	!/*.html=wk_tomcat
	!/*.jpg=wk_tomcat
	!/*.gif=wk_tomcat
	!/*.png=wk_tomcat


#Apache 설정 (apache가 설치된 경로에 따라 달라짐)
vi /usr/local/apache/conf/httpd.conf

	#Apache 와 TOMCAT 의 Dcument(웹 페이지) 위치를 맞춰주기 위한 작업
	DocumentRoot "/LCA/LCM/webapps/ROOT“ # webapps 경로에 따라 다름
    <Directory "/LCA/LCM/webapps/ROOT“>     # webapps 경로에 따라 다름
		….
	</Directory>
	
	#PORT 및 URL 없이 IP로 접속(Apache) 했을 때, 바로 접속할 페이지 설정
	<IfModule dir_module>
		DirectoryIndex index.html index.jsp  # tomcat ROOT 폴더에 추가 되어있는 페이지에 따라 다름
	</IfModule>

	#Apache 실행 시 실행 그룹 및 사용자 설정
	User tomcat	# tomcat 실행 권한 명에 따라 다름
	Group tomcat	# tomcat 실행 권한 명에 따라 다름

	

#SELinux 보안관련 설정 (webapps 경로에 따라 다름)
chcon -R --type=httpd_sys_rw_content_t /LCA/LCM/webapps/ROOT


#결과 확인
/usr/local/apache/bin/httpd -k start / stop
service tomcat start / stop

#Apache 접속 로그 창
tail -f /usr/local/apache/logs/access_log

#Tomcat 접속 로그 창
tail -f /usr/share/tomcat/logs/localhost_access_log.YYYY-MM-DD.txt
