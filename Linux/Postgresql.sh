#Postgres 설치
#오류가 나는 경우 선행되어야하는 의존성파일 rpm 설치 (-ivh)
rpm -ivh python39-devel-3.9.7-1.module_el8.6.0+930+10acc06f.x86_64.rpm

#python3-rpm-generators 설치
yum -y install python3-rpm-generators


#사전에 만들어 둔 shell 파일을 실행하여 설치함
#1. shell 파일 실행 전 설치를 할 계정을 설정해야함 => root 계정으로
cd /LCA/tmp/lib/PCM_SETUP
vi INSTALL_PG14.4.sh
/INST_TYPE
    INST_TYPE="root"
    #INST_TYPE="postgres"

	#1-1.사전 준비
		#설치관련 모듈 다운로드 받기 : https://www.postgresql.org
		#postgresqlXX-libs-XXX -1PGDG.rhel7.x86_64.rpm
		#postgresqlXX- XXX -1PGDG.rhel7.x86_64.rpm
		#postgresqlXX-server-XXX-1PGDG.rhel7.x86_64.rpm
		
		#1-1-1. DB data 경로(/LCA/LCM/DB/data) 확인 및 생성 -> DB 설정 및 실제 데이터를 관리하고 있는 폴더
		#1-1-2. DB 사용 PORT(default 5432) 방화벽 열기		
	#1-2. RPM 파일을 이용한 설치(모든 의존성 파일 포함)
		
	
#2. shell 파일 실행
sh INSTALL_PG14.4.sh

	
#3. Postgres 환경변수 설정 (DB 시작/종료 계정을 root 계정으로 했을 경우)
vi /root/.bash_profile 		#기본 포트 변경 시 설정 필요

#변경된 설정이 바로 적용되지 않는 경우
source /root/.bash_profile


#4.Postgres 설정 변경 -> postgresql.conf
vi /LCA/LCM/DB/data/postgresql.conf

	listen_addresses = '*'
	port = 보안에 유리한 포트로 변경
	password_encryption = scram-sha-256

systemctl stop postgresql-14
systemctl restart postgresql-14
systemctl start postgresql-14


#5. Postgres 접근방법 설정 변경 -> pg_hba.conf
#METHOD 변경: TYPE == local
#trust(비밀번호 입력없이 접근 가능) -> scram-sha-256(비밀번호 입력 후 접근 가능)
#METHOD를 scram-sha-256으로 변경한 뒤 psql 명령어 실행 시 암호를 입력하게 됨
vi /LCA/LCM/DB/data/pg_hba.conf


#PG 작동 코드
systemctl stop postgresql-14
systemctl restart postgresql-14
systemctl start postgresql-14


#6. Postgres 서비스(daemon) 등록
#7. 관리자 계정의 비밀번호 설정 및 일반계정 추가
