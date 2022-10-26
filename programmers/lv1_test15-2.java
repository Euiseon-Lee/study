public class FindKim {
    public String findKim(String[] seoul){
    //x에 김서방의 위치를 저장하세요.
    int x = 0;
    for(int i = 0; i < seoul.length; i++){
        if(seoul[i].equals("Kim")){
          x = i;
          break;
      }
    }

        return "김서방은 "+ x + "에 있다";
    }
}
