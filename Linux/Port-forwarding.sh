포트포워딩 추가
	firewall-cmd --zone=public --add-forward-port=port=443:proto=tcp:toport=8080 --permanent

포트 포워딩 삭제
	firewall-cmd --remove-forward-port=port=443:proto=tcp:toport=8443 --permanent
	firewall-cmd --reload

#포트 목록 확인
	firewall-cmd --list-all


#ssl 접속 로그 확인
	tail -f /usr/local/apache/logs/ssl_request_log

#tomcat 접속 로그 확인
	tail -f /usr/share/tomcat/logs/localhost_access_log.날짜.txt


#포트 포워딩이란?
#	포트(Port)를 전달(Forwarding) == 특정한 포트로 들어오는 데이터 패킷을 다른 포트로 바꿔서 다시 전송해주는 작업
#	서버 포트포워딩을 설정하면, 기본적으로 라우터에 일부 데이터를 네트워크 내의 특정 기기로 전송하라고 명령하게 됨
#	포트포워딩은 말 그대로 포트(port)를 열어 두는 작업

#라우터의 역할
#	라우터에 연결된 모든 기기에 사설 네트워크를 구축해주는 역할
#	라우터는 사설 네트워크를 구축할 뿐만 아니라 공용 IP를 할당
#	라우터에 연결된 기기는 인터넷에 접속하기 위하여 무조건 라우터를 거쳐야함


#ip masquerading
#	리눅스의 NAT(Network Address Translation) 기능
#	내부 컴퓨터들이 리눅스 서버를 통해서 인터넷 등 다른 네트워크에 접속할 수 있도록 해주는 기능
#	내부 컴퓨터들이 생성한 모든 네트워크 요청은 MASQ를 통해서 리눅스 서버의 외부 공인IP로 변환되어 인터넷에 연결
#	외부에서는 리눅스 서버의 IP만 알 수 있을 뿐, 내부 컴퓨터의 존재를 전혀 알 수 없음
#	== 높은 보안성 / 접속 제약 있음
#	이러한 제약은 포워딩(iptable 이용)을 통해서 해소
#	외부에서 특정 포트나 프로토콜로 리눅스 서버에 요청할 경우 지정한 내부 컴퓨터로 연결하도록 규칙을 지정 가능


echo 1 > /proc/sys/net/ipv4/ip_forward
iptables -t nat -A POSTROUTING -j MASQUERADE
iptables -t nat -A PREROUTING -p tcp -i eth0 --dport 8443 -j DNAT --to 10.10.50.187:443
