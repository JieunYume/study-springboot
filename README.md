# study-springboot

백엔드 개발자를 위한 스프링부트 스터디

## 스터디 참여 및 과제 제출 가이드라인

1. 저장소 Fork 하기
원본 저장소를 자신의 GitHub 계정으로 Fork 하세요.
   - 오른쪽 상단의 'Fork' 버튼을 클릭합니다.
   - 자신의 계정을 선택하여 Fork를 완료합니다.
   (이때 main 브랜치만 가져오기에 체 하셨다면 3번 이후에 git fetch upstream 을 실행해주세요)


2. 자신의 컴퓨터에 클론하기
   Fork한 저장소를 자신의 컴퓨터로 클론합니다.
   ![image](https://github.com/ChoMinGi/study-springboot/assets/81455273/f886889c-0bb3-40b6-b8d4-16fc63f5c68d)


3. 원본 저장소를 Upstream으로 추가하기
   클론한 디렉토리로 이동후에 원본 저장소의 변경사항을 쉽게 가져오기 위해 Upstream을 설정합니다.
   ![image](https://github.com/ChoMinGi/study-springboot/assets/81455273/e91ac46c-e66f-40f2-84e3-172766b16b85)

   `git remote add upstream https://github.com/ApptiveDev/study-springboot.git` <br/>
   이후에 branch -a 명령어로 브랜치를 확인합니다. 해당 터미널에서 나올 경우에는 :q로 exit 합니다.

   
4. 작업할 step 브랜치 생성하기
   !![image](https://github.com/ChoMinGi/study-springboot/assets/81455273/5f7817b6-24eb-4f10-b513-8f4d6ddca5ee)

   예시: Source를 Apptive의 study-step1으로 설정하고 New branch name 으로 step1 을 설정한다.<br/>

   혹은 터미널 이용<br/>
   `git checkout -b study-step1 upstream/study-step1`<br/>


6. 생성한 브랜치로 이동하고 폴더 생성하기
   브랜치로 이동합니다.
     ``` git checkout study-step1```
   ![image](https://github.com/ChoMinGi/study-springboot/assets/81455273/5dc67e9c-69bd-445d-9095-fc2f6429c971)



   자신의 브랜치에 (자신의 이름) 폴더를 만든다.
   ![image](https://github.com/ChoMinGi/study-springboot/assets/81455273/9f3d65f3-c118-49dd-8c29-3a4cea145f09)



7. 과제 작업하기
   지정된 폴더 내에서 과제를 수행합니다.
   ![image](https://github.com/ChoMinGi/study-springboot/assets/81455273/bfcf1797-b9c0-42b7-8117-51bb2e8e6e61)



8. 변경사항 커밋하기
   과제가 완료되면 변경사항을 커밋합니다.

   ```
   git add .
   git commit -m "예시: step1 ERD 작성 완료"
   ```



9. 자신의 GitHub 저장소에 푸시하기
   변경사항을 자신의 GitHub 저장소에 푸시합니다.


    `git push origin step-n`

   

10. 원본 저장소에 변경사항을 Pull Request 보내기

   GitHub에서 자신의 저장소로 이동합니다.<br/>

   
   'New pull request' or Compare and pull request 버튼을 클릭합니다. (step1에 새로운 push가 있다고 이렇게 뜨는 경우가 대부분입니다.)<br/>

   
   ![image](https://github.com/ChoMinGi/study-springboot/assets/81455273/f58d70c8-1ca1-4913-a135-34c04e5de39b)

   Base repository는 원본 저장소의 해당 step 브랜치로 설정합니다.<br/>

   
   (대부분의 경우 Able to merge가 뜰겁니다. )<br/>

   
   ![image](https://github.com/ChoMinGi/study-springboot/assets/81455273/b9da9916-1ea4-49c7-9558-06590dda2ed7)
   
   <br/><br/>
   내용을 작성하고 스터디를 진행하는 해당 기수의 스터디장에게 "Reviewers" 을 설정해주시고 자신을 Assignees 로 설정을 합니다.<br/>
   
   ![image](https://github.com/ChoMinGi/study-springboot/assets/81455273/9bcc3638-f796-4f84-bdf6-1b3e40fdf7c2)
   
   'Create pull request' 버튼을 클릭합니다. 이후에 스터디장의 리뷰나 피드백을 기다리시면 됩니다!

   



11. 다음 step을 위한 준비
   리뷰 후에 원본 저장소에 변경사항이 병합되면 다음 step을 위해 다음 과제를 확인하고 준비합니다.



이제 스터디를 진행하시면 됩니다. 화이팅입니다~~
