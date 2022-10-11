#SSL: 암호화 기반 인터넷 보안 프로토콜
#SSL 인증서: 클라이언트와 서버간 암호화 통신을 가능하게 하는 제3의 신뢰 기관(CA)이 인증한 인증서
#=> 서버 SSL 설정용 파일, 클라이언트에서 접속할 때 사용되는 인증서(접속 PC에 설치)

#apache 설치경로의 httpd.conf 설정값 추가
vi /usr/local/apache/conf/httpd.conf 

    LoadModule socache_shmcb_module modules/mod_socache_shmcb.so
	# mod_ssl.so 가 없다면 설치 진행 : yum install mod_ssl
    LoadModule ssl_module modules/mod_ssl.so  
    LoadModule rewrite_module modules/mod_rewrite.so
    Include conf/extra/httpd-ssl.conf


#apache 설치경로의 httpd-ssl.conf 설정값 수정
vi /usr/local/apache/conf/httpd-ssl.conf
#또는 /usr/local/apache/conf/extra/httpd-ssl.conf

    DocumentRoot "/LCA/LCM/webapps/ROOT"  #webapps 경로에 따라 다름
    ServerName localhost
    SSLEngine on
    SSLCertificateFile "/usr/local/apache/conf/파일명.crt"
    SSLCertificateKeyFile "/usr/local/apache/conf/파일명.key"
	#적용X SSLCACertificatePath "/usr/local/apache/conf/파일명CA.crt"


#SELinux 보안관련 설정 변경 -> SELinux 사용 여부가 enforcing인 경우만 해당됨
#사용여부 확인
vi /etc/sysconfig/selinux

chcon -t cert_t /usr/local/apache/conf/파일명.crt
chcon -t cert_t /usr/local/apache/conf/파일명.key
#적용X chcon -t cert_t /usr/local/apache/conf/파일명CA.crt


#SSL(HTTPS) 포트(443) 방화벽 열기
firewall-cmd --permanent --zone=public --add-port=443/tcp
firewall-cmd –reload

#방화벽 목록 확인
firewall-cmd --list-ports

#서버에 인증서 등록 (keystore) -> /LCA/LCM/webapps 경로에 업로드
#등록 시 비밀번호 적용 필요
keytool importkeystore –srckeystore 파일명.keystore

#TOMCAT 설정 파일에 SSL 적용 (tomcat 설치 경로)
vi /usr/share/tomcat/conf/server.xml
<Connector port="8443" protocol="org.apache.coyote.http11.Http11Protocol"
        maxThreads="150" SSLEnabled="true" scheme="https" secure="true"
        clientAuth="false" sslEnabledProtocols="TLSv1.2"
        <!-- 파일 위치 및 암호 -->
        keystoreFile="${user.home}/webapps/파일명.keystore" 
        keystorePass="#비밀번호" 
        <!-- 지원 암호화 방법 -->
        ciphers="TLS_RSA_WITH_AES_128_GCM_SHA256,TLS_RSA_WITH_AES_256_GCM_SHA384,TLS_DHE_RSA_WITH_AES_128_GCM_SHA256,TLS_DHE_RSA_WITH_AES_256_GCM_SHA384,TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384" />


#/usr/local/apache/logs/ssl_request_log 로그 파일에서 암호화 통신 확인 가능
#성공적인 통신은 Apache 의 ssl 로그가 찍힌 뒤, TOMCAT 의 접근 로그에도 로그가 남아야 함
