# Android_MVVM_Practice

안드로이드 MVVM 패턴 연습

M - MODEL  
V - VIEW  
VM - VIEW MODEL

View Binding과 Data Binding을 위해
```
android {

    dataBinding{
        enabled = true;
    }

    viewBinding{
        enabled = true;
    }
}
```
현재까지 View Binding과 Data Binding과  
Live Data , ViewModel 까지 실습을 해 보았다.

LiveData 사용의 이점

- UI와 데이터 상태의 일치 보장
- 메모리 누수 없음
- 중지된 활동으로 인한 비정상 종료 없음
- 수명 주기를 더 이상 수동으로 처리하지 않음
- 최신 데이터 유지
- 적절한 구성 변경
- 리소스 공유

너무 매력적인 라이브러리 인것같다. 여태까지 왜 몰랐는지...
```
model = new ViewModelProvider(this).get(UserProfileViewModel.class);

        model.liveData.observe(this, new Observer<UserProfile>() {
            @Override
            public void onChanged(UserProfile userProfile) {
                binding.setUserProfile(userProfile);
            }
        });
```
이런식으로 ViewModel과 결합해서 사용하면 효용이 배가 된다.

11 / 19 아직 실습이 마무리 된것이 아니니 더욱 더 열심히 달려야겠다.
그리고 이번에 패턴들을 공부하면서 지금까지 만들었던 프로젝트들이 얼마나 좋지않은 스파게티 코드인지 알게되었다...ㅠㅠ  
공부하면 할수록 문제점들이 하나 둘 씩 보이게 되었다. 먼저 공부했으면 좋았을텐데 정말 아쉽지만
앞으로의 프로젝트에는 배운것들을 잘 쓰겠다는 다짐을 하게 되는 계기가 된것같다 화이팅!

ps. 시간나면 모의비트 코드 수정하면서 연습해봐야겠다..!!
