**Run guide for the automation framework**
********************************************

**System requirements**

* Windows 10/11
* JDK 21
* Mozilla Firefox (This is needed to open Allure reort after running tests)

**Firefox settings that must be done for opening allure report (to disable strict origin policy)**

1) Open firefox.
2) On the address bar - type : about:config
3) Click on the button : Accept the risk and continue
4) Search the preference name : 'security.fileuri.strict_origin_policy' and turn the setting to 'False'

**Snaps**

<img width="815" alt="image" src="https://github.com/user-attachments/assets/45c9f961-91ce-4bd0-896e-0f71c286c095" />
<img width="748" alt="image" src="https://github.com/user-attachments/assets/19b26d07-5e97-47a9-8d93-5545f3291283" />
<img width="953" alt="image" src="https://github.com/user-attachments/assets/97fc8cb1-af16-4081-bf8b-bfbf5dafbac7" />

**Running test cases**

1) Go to the project folder and start cmd mode.
2) Type the run command and press ENTER : gradlew.bat clean test -Dcucumber.filter.tags=@SanityTests -PBrowser=Chrome -PEnv=QA generateReport -Ptest.parallel=true

   (The above command is going to run the 3 tests automated).
4) Once done, the allure reports will be generated in the folder : allure-report. Open the file : allure-report/index.html in firefox to view the allure report.
5) Cucumber reports will be generated in the path : target/cucumber-reports and can be opened by opening the file (use any browser) : target/cucumber-reports/Html.html

**snaps**

<img width="683" alt="image" src="https://github.com/user-attachments/assets/93ff29b7-27ee-4099-a591-f41cf17107c1" />
<img width="948" alt="image" src="https://github.com/user-attachments/assets/8e1b6744-9243-4100-b7ef-7b9d11ecd91b" />
<img width="957" alt="image" src="https://github.com/user-attachments/assets/1b35266a-1e61-483a-ba77-604b4d125462" />
<img width="956" alt="image" src="https://github.com/user-attachments/assets/0202e9b3-1331-4e00-9fc8-c0aaca249973" />
<img width="808" alt="image" src="https://github.com/user-attachments/assets/964ea298-aa67-46ab-9ac7-aabbe37fa2f3" />
<img width="946" alt="image" src="https://github.com/user-attachments/assets/95d2cbf8-1e00-41f1-9dc5-5d1ac6a68898" />
<img width="941" alt="image" src="https://github.com/user-attachments/assets/9b5706c6-892c-4a2f-9994-b55eeb62026d" />


















